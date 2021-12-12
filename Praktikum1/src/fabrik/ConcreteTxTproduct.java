package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxTproduct extends Product{
    private BufferedWriter bw;

    public ConcreteTxTproduct() {
    	
        try {
            bw = new BufferedWriter(new FileWriter("Freizeitbad.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException {
      
        bw.write( "Daten des Freizeitbades\n");
        bw.write("Name des Freitzeitbads:" + "\t\t\t\t" + ((Freizeitbad) freizeitbad).getName() + "\n");
        bw.write("Oeffnungszeit des Freizeitbads:" + "\t\t" + ((Freizeitbad) freizeitbad).getGeoeffnetVon() + " - " + ((Freizeitbad) freizeitbad).getGeoeffnetBis() + "\n");
        bw.write("Beckenlaenge des Freizeitbads:" + "\t\t" + ((Freizeitbad) freizeitbad).getBeckenlaenge() + "\n");
        bw.write("Wassertemperatur des Freizeitbads:" + "\t" + ((Freizeitbad) freizeitbad).getTemperatur() + "\n");
        
       
        bw.write("\n");
    }

   
    public void schliesseDatei() throws IOException {
        bw.close();
    }

}
