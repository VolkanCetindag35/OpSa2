package gui.guiSportstaetten;

import javafx.stage.Stage;
import observer.Observer;
import java.io.IOException;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.SporthallenModel;
import ownUtil.PlausiException;

public class SportstaettenControl implements Observer {

	private FreizeitbaederModel freizeitbaederModel;
	private SportstaettenView sportstaettenView;
	private SporthallenModel sporthallenModel;

	public SportstaettenControl(Stage fensterSportstaetten) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sporthallenModel = SporthallenModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, fensterSportstaetten, freizeitbaederModel,
				sporthallenModel);
		freizeitbaederModel.addObserver(this);
	}

	void leseSporthallenAusDatei(String typ) {
		try {
			if (typ.equals("csv")) {
				sporthallenModel.leseSporthallenAusCsvDatei();
				this.sportstaettenView
						.zeigeInformationsfensterAn("Die Daten aus Sporthallen.csv wurden erfolgreich importiert.");
			} else {
				this.sportstaettenView.zeigeInformationsfensterAn("Die Datei existiert nicht.");
			}
		} catch (IOException | PlausiException e) {
			this.sportstaettenView.zeigeFehlermeldungsfensterAn("Fehler nicht bekannt",
					"Beim Importieren des ist ein Unbekannter Fehler aufgetaucht");
			e.printStackTrace();
		}
	}

	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();
	}

}