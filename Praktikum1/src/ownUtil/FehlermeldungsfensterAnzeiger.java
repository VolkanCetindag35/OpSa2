package ownUtil;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FehlermeldungsfensterAnzeiger extends Anzeiger {

	private String titel = "Fehler";

	public FehlermeldungsfensterAnzeiger(String titel, String meldung) {
		super(titel, meldung);
		this.titel = titel;
	}

	public void zeigeMeldungsfensterAn() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(this.titel);
		alert.setContentText(this.meldung);
		alert.showAndWait();
	}
}
