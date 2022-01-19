package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import business.businessFreizeitbaeder.Freizeitbad;

public class ConcreteTxTproduct extends Product {
	private BufferedWriter bw;

	public ConcreteTxTproduct() {

		try {
			bw = new BufferedWriter(new FileWriter("Freizeitbad.txt", true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fuegeInDateiHinzu(Object object) throws IOException {

		bw.write("Daten des Freizeitbades\n");
		bw.write("Name des Freitzeitbads:" + "\t\t\t\t" + ((Freizeitbad) object).getName() + "\n");
		bw.write("Oeffnungszeit des Freizeitbads:" + "\t\t" + ((Freizeitbad) object).getGeoeffnetVon() + " - "
				+ ((Freizeitbad) object).getGeoeffnetBis() + "\n");
		bw.write("Beckenlaenge des Freizeitbads:" + "\t\t" + ((Freizeitbad) object).getBeckenlaenge() + "\n");
		bw.write("Wassertemperatur des Freizeitbads:" + "\t" + ((Freizeitbad) object).getTemperatur() + "\n");

		bw.write("\n");
	}

	public void schliesseDatei() throws IOException {
		bw.close();
	}

}