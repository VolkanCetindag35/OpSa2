package fabrik;

import java.io.IOException;
import business.businessFreizeitbaeder.Freizeitbad;

public abstract class Product {
	public abstract void fuegeInDateiHinzu(Object object) throws IOException;

	public abstract void schliesseDatei() throws IOException;
}