package gui.guiSportstaetten;

import java.io.IOException;

import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
import javafx.stage.Stage;
import ownUtil.PlausiException;
import pattern.Observer;

public class SportstaettenControl implements Observer {

	private SportstaettenView sportstaettenView;
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;

	public SportstaettenControl(Stage fensterSportstaetten) {
		// TODO Auto-generated constructor stub
		this.freizeitbaederModel = freizeitbaederModel.getTheInstance();
		this.sporthallenModel = sporthallenModel.getTheInstance();
		this.sportstaettenView = new SportstaettenView(this, fensterSportstaetten, freizeitbaederModel,
				sporthallenModel);

		freizeitbaederModel.addObserver(this);
	}

	public void update() {
		// TODO Auto-generated method stub
		sportstaettenView.zeigeFreizeitbadAn();
	}

	public Sporthalle leseSporthalleAusCsvDatei() {
		Sporthalle ergebnis = null;
		try {
			ergebnis = sporthallenModel.leseSporthalleAusCsvDatei();
		} catch (IOException exc) {
			sportstaettenView.zeigeFehlermeldungAn("IOException beim Lesen!");
		} catch (Exception exc) {
			sportstaettenView.zeigeFehlermeldungAn("Unbekannter Fehler beim Lesen!");
		}
		return ergebnis;
	}

}