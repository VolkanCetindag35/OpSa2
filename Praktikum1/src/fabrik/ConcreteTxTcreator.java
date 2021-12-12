package fabrik;

import java.io.IOException;

public class ConcreteTxTcreator extends Creator {

	@Override
	public Product factoryMethod() throws IOException {
		return new ConcreteTxTproduct();
	}
	

}
