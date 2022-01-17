package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.businessFreizeitbaeder.Freizeitbad;

public class ConcreteTxTproduct extends Product{
    
	public void fuegeZeileHinzu(Freizeitbad freizeitbad) throws IOException {
		// TODO Auto-generated method stub
		aus.write(freizeitbad.gibFreizeitbadZurueck(' '));
        aus.close();
	}
	
	public ConcreteTxTproduct() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		aus = new BufferedWriter(new FileWriter("Freizeitbad.txt"));
	}


}
