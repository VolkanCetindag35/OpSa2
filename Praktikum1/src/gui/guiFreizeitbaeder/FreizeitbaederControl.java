package gui.guiFreizeitbaeder;

import java.io.IOException;
import pattern.*;

import business.FreizeitbaederModel;
import javafx.stage.Stage;

public class FreizeitbaederControl implements Observer{
	private FreizeitbaederView fbView;
	private FreizeitbaederModel fbModel;

	public FreizeitbaederControl(Stage primaryStage) {
		this.fbModel = FreizeitbaederModel.getInstance();
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
   			fbModel.schreibeFreizeitbaederInTxtDatei();
   			fbView.zeigeInformationsfensterAn(
   				"Das Freizeitbad wurde gespeichert!");
   		}
			
			else {
				fbView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			fbView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!",typ);
		} catch (Exception exc) {
			fbView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!",typ);
		}
	}
	
	public void update() {
		fbView.zeigeFreizeitbaederAn();
	}



	
}