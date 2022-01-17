package business.businessFreizeitbaeder;

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

public final class FreizeitbaederModel implements Observable {

	private ArrayList<Observer> observers = new ArrayList<Observer>();

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

	private Freizeitbad freizeitbad;
	private static FreizeitbaederModel theInstance = null;

	private FreizeitbaederModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static FreizeitbaederModel getTheInstance() {
		if (theInstance == null)
			theInstance = new FreizeitbaederModel();

		return theInstance;
	}

	public Freizeitbad getFreizeitbad() {
		return this.freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;

		notifyObservers();
	}

	public void schreibeFreizeitbadInCsvDatei() throws IOException {
		Creator writerCreator = new ConcreteCreator();
		Product writer = writerCreator.factoryMethod();
		writer.fuegeZeileHinzu(this.freizeitbad);
	}

	public void schreibeFreizeitbadInTxtDatei() throws IOException {
		// TODO Auto-generated method stub
		Creator writerCreator = new ConcreteTxTcreator();
		Product writer = writerCreator.factoryMethod();
		writer.fuegeZeileHinzu(this.freizeitbad);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub

	}

}
