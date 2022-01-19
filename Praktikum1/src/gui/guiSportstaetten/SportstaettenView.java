package gui.guiSportstaetten;

import business.businessFreizeitbaeder.Freizeitbad;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;

public class SportstaettenView {

	private FreizeitbaederModel freizeitbaederModel;
	private SportstaettenControl sportstaettenControl;
	private SporthallenModel sporthallenModel;
	private Pane pane = new Pane();
	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitbäder");
	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");

	private TextArea txtAnzeigeFreizeitbaeder = new TextArea();
	private TextArea txtAnzeigeSporthallen = new TextArea();

	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
	private Button btnAnzeigeSportstaetten = new Button("Anzeige");

	private MenuBar a = new MenuBar();
	private Menu b = new Menu("Datei");
	private MenuItem c = new MenuItem("csv-Import");

	public SportstaettenView(SportstaettenControl sportstaettenControl, Stage fensterSportstaetten,
			FreizeitbaederModel freizeitbaederModel, SporthallenModel sporthallenModel) {

		Scene scene = new Scene(this.pane, 560, 340);
		fensterSportstaetten.setScene(scene);
		fensterSportstaetten.setTitle("Anzeige von Sportstätten");
		fensterSportstaetten.show();

		this.freizeitbaederModel = freizeitbaederModel;
		this.sportstaettenControl = sportstaettenControl;
		this.sporthallenModel = sporthallenModel;
		this.initKomponenten();
		this.initListener();
		this.initKomponentenMenue();
		this.initKomponentenSporthallen();

	}

	private void initKomponentenMenue() {
		this.a.getMenus().add(b);
		this.b.getItems().add(c);
		pane.getChildren().add(a);
	}

	private void initKomponentenSporthallen() {

		Font font = new Font("Arial", 20);
		lblAnzeigeSporthallen.setLayoutX(20);
		lblAnzeigeSporthallen.setLayoutY(40);
		lblAnzeigeSporthallen.setFont(font);
		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;");
		pane.getChildren().addAll(lblAnzeigeSporthallen);

		txtAnzeigeSporthallen.setEditable(false);
		txtAnzeigeSporthallen.setLayoutX(20);
		txtAnzeigeSporthallen.setLayoutY(90);
		txtAnzeigeSporthallen.setPrefWidth(220);
		txtAnzeigeSporthallen.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSporthallen);

		btnAnzeigeSportstaetten.setLayoutX(20);
		btnAnzeigeSportstaetten.setLayoutY(290);
		pane.getChildren().addAll(btnAnzeigeSportstaetten);

	}

	private void initKomponenten() {

		Font font = new Font("Arial", 20);
		lblAnzeigeFreizeitbaeder.setLayoutX(310);
		lblAnzeigeFreizeitbaeder.setLayoutY(40);
		lblAnzeigeFreizeitbaeder.setFont(font);
		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
		pane.getChildren().addAll(lblAnzeigeFreizeitbaeder);

		txtAnzeigeFreizeitbaeder.setEditable(false);
		txtAnzeigeFreizeitbaeder.setLayoutX(310);
		txtAnzeigeFreizeitbaeder.setLayoutY(90);
		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFreizeitbaeder);

		btnAnzeigeFreizeitbaeder.setLayoutX(310);
		btnAnzeigeFreizeitbaeder.setLayoutY(290);
		pane.getChildren().addAll(btnAnzeigeFreizeitbaeder);

	}

	private void initListener() {

		btnAnzeigeFreizeitbaeder.setOnAction(e -> zeigeFreizeitbaederAn());
		btnAnzeigeSportstaetten.setOnAction(e -> zeigeSporthallenAn());
		c.setOnAction(e -> leseSporthallenAusDatei("csv"));

	}

	public void zeigeFreizeitbaederAn() {
		if (freizeitbaederModel.getFreizeitbad().size() > 0) {
			StringBuffer text = new StringBuffer();
			for (Freizeitbad x : this.freizeitbaederModel.getFreizeitbad()) {
				text.append(x.gibFreizeitbadZurueck(' ') + "\n");
			}
			this.txtAnzeigeFreizeitbaeder.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	public void zeigeSporthallenAn() {
		if (sporthallenModel.getSporthallen() != null) {
			StringBuffer text = new StringBuffer();
			for (Sporthalle y : this.sporthallenModel.sporthallen) {
				text.append(y.gibSporthalleZurueck(' ') + "\n");
			}
			this.txtAnzeigeSporthallen.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde keine Sporthalle aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String fehlertyp, String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, fehlertyp + "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	void leseSporthallenAusDatei(String typ) {
		sportstaettenControl.leseSporthallenAusDatei(typ);
	}

}
