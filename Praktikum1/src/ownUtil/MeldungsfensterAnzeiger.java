package ownUtil;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MeldungsfensterAnzeiger extends Anzeiger {

	private static String titel = "Information";

	public MeldungsfensterAnzeiger(String meldung) {
		super(titel, meldung);
	}

	public void zeigeMeldungsfensterAn() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(this.titel);
		alert.setContentText(this.meldung);
		alert.showAndWait();
	}

}
