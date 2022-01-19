package business.businessFreizeitbaeder;

import java.io.*;
import java.util.ArrayList;
import fabrik.ConcreteCreator;
import fabrik.ConcreteTxTcreator;
import fabrik.Creator;
import fabrik.Product;
import observer.Observable;
import observer.Observer;

public class FreizeitbaederModel implements Observable {

	private ArrayList<Freizeitbad> freizeitbad = new ArrayList<>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	private static final FreizeitbaederModel freizeitbaederModel = new FreizeitbaederModel();

	private FreizeitbaederModel() {

	}

	public static FreizeitbaederModel getInstance() {

		return freizeitbaederModel;
	}

	public ArrayList<Freizeitbad> getFreizeitbad() {
		return this.freizeitbad;
	}

	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad.add(freizeitbad);
		this.notifyObservers();
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator c = new ConcreteCreator();
		Product writer = c.factoryMethod(null);
		for (Freizeitbad x : freizeitbad) {
			writer.fuegeInDateiHinzu(x);
		}
		writer.schliesseDatei();
	}

	public void schreibeFreizeitbaederInTxtDatei() throws IOException {
		Creator c = new ConcreteTxTcreator();
		Product writer = c.factoryMethod(null);
		for (Freizeitbad x : freizeitbad) {
			writer.fuegeInDateiHinzu(x);
		}

		writer.schliesseDatei();

	}

	public void addObserver(Observer obs) {
		this.observers.add(obs);
		;
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