package business.businessSporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import ownUtil.PlausiException;
import pattern.Observer;

public class SporthallenModel {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private static SporthallenModel spModel;
	private Sporthalle sporthalle;

	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	public void deleteObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update();
		}

	}

	private SporthallenModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static SporthallenModel getTheInstance() {
		if (spModel == null)
			spModel = new SporthallenModel();

		return spModel;
	}

	public Sporthalle getSporthalle() {
		return this.sporthalle;
	}

	public void setSporthalle(Sporthalle sporthalle) {
		this.sporthalle = sporthalle;

		notifyObservers();
	}

	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub

	}

	public Sporthalle leseSporthalleAusCsvDatei() throws IOException, Exception {
		BufferedReader ein = new BufferedReader(new FileReader("Sporthalle.csv"));
		String[] zeile = ein.readLine().split(";");
		Sporthalle ergebnis = new Sporthalle(zeile[0], zeile[1], zeile[2]);
		ein.close();
		return ergebnis;
	}
}