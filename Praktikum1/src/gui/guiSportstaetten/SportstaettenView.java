package gui.guiSportstaetten;

import business.*;
//import gui.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class SportstaettenView {

	// private SportstaettenControl sportstaettenControl;
	private FreizeitbaederModel freizeitbaederModel;
	private Pane pane = new Pane();
	private Label lblAnzeige = new Label("Anzeige Freizeitbäder");
	private TextArea txtAnzeige = new TextArea();
	private Button btnAnzeige = new Button("Anzeige");

	public SportstaettenView(SportstaettenControl sportstaettenControl, FreizeitbaederModel freizeitbaederModel,
			Stage primaryStage) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Sportstätten");
		primaryStage.show();

		// this.sportstaettenControl= sportstaettenControl; //1
		this.freizeitbaederModel = freizeitbaederModel;
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {

		Font font = new Font("Arial", 20);
		lblAnzeige.setLayoutX(310);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		pane.getChildren().addAll(lblAnzeige);

		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(310);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(220);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);

		btnAnzeige.setLayoutX(310);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnAnzeige);

	}

	private void initListener() {
/*		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				zeigeFreizeitbaederAn();
			}
		});
*/
		btnAnzeige.setOnAction(
				e->zeigeFreizeitbaederAn()
		);
		
		
	}

	void zeigeFreizeitbaederAn() {
		/*
		if (this.freizeitbaederModel.getFreizeitbad() != null) {
			txtAnzeige.setText(this.freizeitbaederModel.getFreizeitbad().gibFreizeitbadZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
		*/
		if (freizeitbaederModel.getFreizeitbad().size() > 0) {
			StringBuffer text = new StringBuffer();
			// Ergaenzen: for each – Schleife ueber ArrayList
			for(Freizeitbad fzb : this.freizeitbaederModel.getFreizeitbad())
			{
				text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");
			}
			this.txtAnzeige.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String fehlertyp, String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, fehlertyp + "Fehler", meldung).zeigeMeldungsfensterAn();
	}

}