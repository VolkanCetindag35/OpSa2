package business;  
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException;

import fabrik.ConcreteCreator;
import fabrik.ConcreteTxTcreator;
import fabrik.Creator;
import fabrik.Product;
import gui.FreizeitbaederView; 

 public class FreizeitbaederModel { 
	 
	private Freizeitbad freizeitbad;
	 /*
    public void schreibeFreizeitbaederInCsvDatei(FreizeitbaederView fbView) throws IOException { 
               BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));        
               aus.write(fbView.getFreizeitbad().gibFreizeitbadZurueck(';'));  
                     aus.close();  
                       } 
    */
	
	
	public void schreibeFreizeitbaederInCsvDatei() throws IOException{
		Creator c = new ConcreteCreator();
		Product writer =  c.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
		
	}
	
	public void schreibeFreizeitbaederInTxTDatei() throws IOException{
		Creator c = new ConcreteTxTcreator();
		Product writer =  c.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}

	
	
    public Freizeitbad getFreizeitbad() {
		return this.freizeitbad;
	}  

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}

}