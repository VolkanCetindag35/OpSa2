package business.businessFreizeitbaeder;

import ownUtil.*;

public class Freizeitbad {

	// Name des Freizeitbads
	private String name;
	// Oeffnungszeiten
	private float geoeffnetVon;
	private float geoeffnetBis;
	// Laenge des laengsten Beckens
	private int beckenlaenge;
	// Wassertemperatur des laengsten Beckens
	private int temperatur;

	public Freizeitbad(String name, String geoeffnetVon, String geoeffnetBis, String beckenlaenge, String temperatur)
			throws PlausiException {
		String feldname = pruefeFormal(name, geoeffnetVon, geoeffnetBis, beckenlaenge, temperatur);
		if (feldname == null) {
			this.name = name;
			this.geoeffnetVon = Float.parseFloat(geoeffnetVon);
			this.geoeffnetBis = Float.parseFloat(geoeffnetBis);
			this.beckenlaenge = Integer.parseInt(beckenlaenge);
			this.temperatur = Integer.parseInt(temperatur);
			feldname = pruefeInhaltlich();
			if (feldname != null) {
				throw new InhaltlichePlausiException(feldname);
			}
		} else {
			throw new FormalePlausiException(feldname);
		}
	}

	private String pruefeFormal(String name, String geoeffnetVon, String geoeffnetBis, String beckenlaenge,
			String temperatur) {
		String erg = null;
		if (name == null || "".equals(name)) {
			return "Name";
		} else {
			try {
				Float.parseFloat(geoeffnetVon);
			} catch (NumberFormatException exc) {
				return "Ge�ffnet von";
			}
			try {
				Float.parseFloat(geoeffnetBis);
			} catch (NumberFormatException exc) {
				return "Ge�ffnet bis";
			}
			try {
				Integer.parseInt(beckenlaenge);
			} catch (NumberFormatException exc) {
				return "Beckenl�nge";
			}
			try {
				Integer.parseInt(temperatur);
			} catch (NumberFormatException exc) {
				return "Temperatur";
			}
		}
		return erg;
	}

	private String pruefeInhaltlich() {
		String erg = null;
		if (this.geoeffnetVon < 0 || this.geoeffnetVon >= 24) {
			return "Ge�ffnet von";
		}
		if (this.geoeffnetBis < 0 || this.geoeffnetBis >= 24 || this.geoeffnetBis <= this.geoeffnetVon) {
			return "Ge�ffnet bis";
		}
		if (this.beckenlaenge <= 0) {
			return "Beckenl�nge";
		}
		if (this.temperatur <= 0 || this.temperatur >= 100) {
			return "Temperatur";
		}
		return erg;
	}

	public String gibFreizeitbadZurueck(char trenner) {

		String bad = "";

		if (trenner == (' ')) {
			bad = bad + "Daten des Freizeitbades: ";
		}

		bad = bad + this.getName() + trenner + this.getGeoeffnetVon() + trenner + this.getGeoeffnetBis() + trenner
				+ this.getBeckenlaenge() + trenner + this.getTemperatur();

		return bad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGeoeffnetVon() {
		return geoeffnetVon;
	}

	public void setGeoeffnetVon(float geoeffnetVon) {
		this.geoeffnetVon = geoeffnetVon;
	}

	public float getGeoeffnetBis() {
		return geoeffnetBis;
	}

	public void setGeoeffnetBis(float geoeffnetBis) {
		this.geoeffnetBis = geoeffnetBis;
	}

	public int getBeckenlaenge() {
		return beckenlaenge;
	}

	public void setBeckenlaenge(int beckenlaenge) {
		this.beckenlaenge = beckenlaenge;
	}

	public int getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(int temperatur) {
		this.temperatur = temperatur;
	}

}