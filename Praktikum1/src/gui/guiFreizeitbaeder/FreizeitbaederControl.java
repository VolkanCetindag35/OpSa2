package gui.guiFreizeitbaeder;

import java.io.IOException;

import business.businessFreizeitbaeder.FreizeitbaederModel;
import pattern.*;
import javafx.stage.Stage;

public class FreizeitbaederControl implements Observer {

	private FreizeitbaederView freizeitbaederView;
	private FreizeitbaederModel freizeitbaederModel;

	public FreizeitbaederControl(Stage primaryStage) {
		this.freizeitbaederModel = freizeitbaederModel.getTheInstance();
		this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, freizeitbaederModel);

		freizeitbaederModel.addObserver(this);
	}

	void schreibeFreizeitbadInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbadInCsvDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
			} else if ("txt".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbadInTxtDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
			} else {
				freizeitbaederView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			freizeitbaederView.zeigeFehlermeldungAn("IOException beim Speichern!");
		} catch (Exception exc) {
			freizeitbaederView.zeigeFehlermeldungAn("Unbekannter Fehler beim Speichern!");
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		freizeitbaederView.zeigeFreizeitbadAn();
	}

}