package fabrik;

import java.io.IOException;

public class ConcreteTxTcreator extends Creator {

	public ConcreteTxTcreator() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		product = new ConcreteTxTproduct();
	}

	public Product factoryMethod() {
		// TODO Auto-generated method stub
		return product;
	}

}
