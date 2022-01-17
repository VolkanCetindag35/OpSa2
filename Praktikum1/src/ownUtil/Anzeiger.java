package ownUtil;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class Anzeiger {

	protected String meldung;
	protected String titel;

	public Anzeiger(String titel, String meldung) {
		this.meldung = meldung;
		if (meldung == null || "".equals(meldung)) {
			this.meldung = "Die Meldung ist nicht vorhanden.";
		}
		this.titel = titel;
		if (titel == null || "".equals(titel)) {
			this.titel = "Der Titel ist nicht vorhanden.";
		}
	}

	public void zeigeMeldungsfensterAn() {
		Alert alert = new Alert(AlertType.NONE);
		alert.setTitle(titel);
		alert.setContentText(this.meldung);
		alert.showAndWait();
	}
}
