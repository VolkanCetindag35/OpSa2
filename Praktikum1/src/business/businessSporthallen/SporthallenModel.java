package business.businessSporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import observer.Observer;
import ownUtil.PlausiException;

public class SporthallenModel {
    private static SporthallenModel instance = null;
    public ArrayList<Sporthalle> sporthallen = new ArrayList<Sporthalle>();

    public void leseSporthallenAusCsvDatei() throws IOException, PlausiException {
        BufferedReader ein = new BufferedReader(new FileReader("Sporthalle.csv"));
        ArrayList<Sporthalle> ergebnis = new ArrayList<>();
        String zeileStr = ein.readLine();
        while (zeileStr != null) {
            System.out.print(zeileStr);
            String[] zeile = zeileStr.split(";");
            ergebnis.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
            zeileStr = ein.readLine();
        }
        ein.close();
        this.sporthallen = ergebnis;
    }

	private SporthallenModel() {
        super();
    }



    public static SporthallenModel getInstance() {
        if (instance == null)
            instance = new SporthallenModel();
        return instance;
    }

    public ArrayList<Sporthalle> getSporthallen(){
        return this.sporthallen;
    }
}

	
	
	
