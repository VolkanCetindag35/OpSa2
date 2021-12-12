package fabrik;

import java.io.IOException;

public class ConcreteCreator extends Creator{
	public Product factoryMethod() throws IOException {
		return new ConcreteProduct();
	}

}