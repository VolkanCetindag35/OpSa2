package gui.guiSportstaetten;

import java.io.IOException;

import business.businessFreizeitbaeder.Freizeitbad;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
//import gui.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class SportstaettenView {

	// Hier ergaenzen
	private FreizeitbaederModel freizeitbaederModel;
	private SportstaettenControl sportstaettenControl;
	private SporthallenModel sporthallenModel;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitbäder");
	private TextArea txtAnzeigeFreizeitbaeder = new TextArea();
	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");

	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
	private TextArea txtAnzeigeSporthallen = new TextArea();
	private Button btnAnzeigeSporthallen = new Button("Csv-Import und Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public SportstaettenView(SportstaettenControl sportstaettenControl, Stage fensterSportstaetten,
			FreizeitbaederModel freizeitbaederModel, SporthallenModel sporthallenModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		fensterSportstaetten.setScene(scene);
		fensterSportstaetten.setTitle("Anzeige von Sportstätten");
		fensterSportstaetten.show();
		// Hier ergaenzen
		this.sportstaettenControl = sportstaettenControl;
		this.freizeitbaederModel = freizeitbaederModel;
		this.sporthallenModel = sporthallenModel;

		this.initKomponentenFreizeitbaeder();
		this.initKomponentenSporthallen();
		this.initListenerFreizeitbaeder();
		this.initListenerSporthallen();
	}

	private void initKomponentenFreizeitbaeder() {
		// Label
		lblAnzeigeFreizeitbaeder.setLayoutX(310);
		lblAnzeigeFreizeitbaeder.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblAnzeigeFreizeitbaeder.setFont(font);
		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeFreizeitbaeder);
		// Textbereich
		txtAnzeigeFreizeitbaeder.setEditable(false);
		txtAnzeigeFreizeitbaeder.setLayoutX(310);
		txtAnzeigeFreizeitbaeder.setLayoutY(90);
		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFreizeitbaeder);
		// Button
		btnAnzeigeFreizeitbaeder.setLayoutX(310);
		btnAnzeigeFreizeitbaeder.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFreizeitbaeder);

	}

	private void initKomponentenSporthallen() {
		// Label
		lblAnzeigeSporthallen.setLayoutX(10);
		lblAnzeigeSporthallen.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblAnzeigeSporthallen.setFont(font);
		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeSporthallen);
		// Textbereich
		txtAnzeigeSporthallen.setEditable(false);
		txtAnzeigeSporthallen.setLayoutX(10);
		txtAnzeigeSporthallen.setLayoutY(90);
		txtAnzeigeSporthallen.setPrefWidth(220);
		txtAnzeigeSporthallen.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSporthallen);
		// Button
		btnAnzeigeSporthallen.setLayoutX(10);
		btnAnzeigeSporthallen.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSporthallen);

	}

	private void initListenerFreizeitbaeder() {
		btnAnzeigeFreizeitbaeder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFreizeitbadAn();
			}
		});
	}

	private void initListenerSporthallen() {
		btnAnzeigeSporthallen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeSporthalleAn();
			}
		});
	}

	protected void zeigeSporthalleAn() {
		// TODO Auto-generated method stub
		try {
			sporthallenModel.setSporthalle(sporthallenModel.leseSporthalleAusCsvDatei());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sporthallenModel.getSporthalle() != null) {
			txtAnzeigeSporthallen.setText(sporthallenModel.getSporthalle().gibSporthalleZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde keine Sporthalle aufgenommen!");
		}

	}

	public void zeigeFreizeitbadAn() {
		if (freizeitbaederModel.getFreizeitbad() != null) {
			txtAnzeigeFreizeitbaeder.setText(freizeitbaederModel.getFreizeitbad().gibFreizeitbadZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungAn(String meldung) {
		new MeldungsfensterAnzeiger(meldung).zeigeMeldungsfensterAn();
	}

}
