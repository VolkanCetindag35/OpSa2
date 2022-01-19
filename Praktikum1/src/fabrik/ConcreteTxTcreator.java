package fabrik;

import java.io.IOException;

public class ConcreteTxTcreator extends Creator {

	public Product factoryMethod(String typ) throws IOException {
		return new ConcreteTxTproduct();
	}
	

}