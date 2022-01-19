package gui.guiFreizeitbaeder;

import java.io.IOException;

import business.businessFreizeitbaeder.FreizeitbaederModel;
import javafx.stage.Stage;
import observer.*;

public class FreizeitbaederControl implements Observer {

	private FreizeitbaederView freizeitbaederView;
	private FreizeitbaederModel freizeitbaederModel;

	public FreizeitbaederControl(Stage primaryStage) {
		this.freizeitbaederModel = freizeitbaederModel.getInstance();
		this.freizeitbaederView = new FreizeitbaederView(primaryStage, freizeitbaederModel, this);

		freizeitbaederModel.addObserver(this);
	}

	void schreibeFreizeitbadInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
			} else if ("txt".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
			} else {
				freizeitbaederView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			freizeitbaederView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!", typ);
		} catch (Exception exc) {
			freizeitbaederView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!", typ);
		}
	}

	public void update() {
		freizeitbaederView.zeigeFreizeitbaederAn();
	}

}