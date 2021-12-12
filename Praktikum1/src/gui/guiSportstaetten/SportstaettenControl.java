package gui.guiSportstaetten;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import pattern.Observer;

public class SportstaettenControl implements Observer {

	private FreizeitbaederModel freizeitbaederModel;
	private SportstaettenView sportstaettenView;

	public SportstaettenControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, freizeitbaederModel, primaryStage);

		freizeitbaederModel.addObserver(this);

	}

	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();

	}

}