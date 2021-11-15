
package gui;

import java.io.IOException;
import business.FreizeitbaederModel;
import javafx.stage.Stage;

public class FreizeitbaederControl {
	private FreizeitbaederView fbView;
	private FreizeitbaederModel fbModel;

	public FreizeitbaederControl(Stage primaryStage) {
		this.fbModel = new FreizeitbaederModel();
		this.fbView = new FreizeitbaederView(primaryStage, fbModel, this);
	}
	
	//umschreiben in csv datei 
	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				this.fbModel.schreibeFreizeitbaederInCsvDatei();
				this.fbView.zeigeInformationsfensterAn("Freizeitbäder wurden gespeichert!");
			}
		else if("txt".equals(typ)){
   			fbModel.schreibeFreizeitbaederInTxTDatei();
   			fbView.zeigeInformationsfensterAn(
   				"Das Freizeitbad wurde gespeichert!");
   		}
			
			else {
				fbView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			fbView.zeigeFehlermeldungsfensterAn("IOException", "IOException beim Speichern!");
		} catch (Exception exc) {
			fbView.zeigeFehlermeldungsfensterAn("Exception", "Unbekannter Fehler beim Speichern!");
		}
	}
}