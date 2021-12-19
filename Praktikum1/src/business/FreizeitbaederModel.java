package business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Observable;

import fabrik.ConcreteCreator;
import fabrik.ConcreteTxTcreator;
import fabrik.Creator;
import fabrik.Product;
import pattern.Observable;
//import pattern.ConcreteObservable;
import pattern.Observer;

public class FreizeitbaederModel implements Observable {

	//private Freizeitbad freizeitbad;
	private ArrayList<Freizeitbad>freizeitbad= new ArrayList<>();
	private ArrayList<Observer> observers = new ArrayList<>();
	/*
	 * public void schreibeFreizeitbaederInCsvDatei(FreizeitbaederView fbView)
	 * throws IOException { BufferedWriter aus = new BufferedWriter(new
	 * FileWriter("Freizeitbaeder.csv", true));
	 * aus.write(fbView.getFreizeitbad().gibFreizeitbadZurueck(';')); aus.close(); }
	 */

	private static FreizeitbaederModel freizeitbaederModel = null;

	private FreizeitbaederModel() {
	}

	public static FreizeitbaederModel getInstance() {
		if (freizeitbaederModel == null)
			freizeitbaederModel = new FreizeitbaederModel();

		return freizeitbaederModel;
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator c = new ConcreteCreator();
		Product writer = c.factoryMethod();
		//writer.fuegeInDateiHinzu(this.freizeitbad);
		for( Freizeitbad fzb: freizeitbad) {
			writer.fuegeInDateiHinzu(fzb);
		}
		writer.schliesseDatei();
		writer.schliesseDatei();

	}

	public void schreibeFreizeitbaederInTxtDatei() throws IOException {
		Creator c = new ConcreteTxTcreator();
		Product writer = c.factoryMethod();
		//writer.fuegeInDateiHinzu(this.freizeitbad);
		for( Freizeitbad fzb: freizeitbad) {
			writer.fuegeInDateiHinzu(fzb);
		}
		writer.schliesseDatei();
	}

	public ArrayList<Freizeitbad> getFreizeitbad() {
		return this.freizeitbad;
	}

	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad.add(freizeitbad);
		this.notifyObservers();
	}

	public void addObserver(Observer obs) {

		this.observers.add(obs);
	}

	public void removeObserver(Observer obs) {

		observers.remove(obs);

	}

	public void notifyObservers() {
		for (Observer o : observers) {
			o.update();

		}

	}
}
