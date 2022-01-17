package ownUtil;

public abstract class PlausiException extends Exception {

	private static final long serialVersionUID = 1L;

	protected String type;
	protected String feldname;

	public PlausiException(String type, String feldname) {
		this.feldname = feldname;
		this.type = type;
	}

	public String getMessageForUser() {
		return "Bitte korrigieren Sie den " + this.type.toLowerCase() + "en Eingabefehler im Feld " + this.feldname
				+ ".";
	}

	public String getType() {
		return type;
	}
}
