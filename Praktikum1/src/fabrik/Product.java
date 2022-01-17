package fabrik;

import java.io.BufferedWriter;
import java.io.IOException;

import business.businessFreizeitbaeder.Freizeitbad;

public abstract class Product {

	BufferedWriter aus;

	public abstract void fuegeZeileHinzu(Freizeitbad freizeitbad) throws IOException;

}
