package fabrik;

import java.io.IOException;

public class ConcreteCreator extends Creator {

	public ConcreteCreator() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		product = new ConcreteProduct();
	}

	public Product factoryMethod() {
		// TODO Auto-generated method stub
		return product;
	}
}
