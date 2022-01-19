package fabrik;

import java.io.IOException;

public class ConcreteCreator extends Creator {
	public Product factoryMethod(String typ) throws IOException {

		return new ConcreteProduct();
	}

}