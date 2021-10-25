package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import gui.FreizeitbaederView;

public class FreizeitbaederModel {
	public void schreibeFreizeitbaederInCsvDatei(FreizeitbaederView fbView) throws IOException // Werfen einer
																								// IOException
	{
		BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
		aus.write(fbView.getFreizeitbad().gibFreizeitbadZurueck(';'));
		aus.close();
	}
}