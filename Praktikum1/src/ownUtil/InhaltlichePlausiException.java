package ownUtil;

public class InhaltlichePlausiException extends PlausiException {

	private static final long serialVersionUID = 1L;

	public InhaltlichePlausiException(String feldname) {
		super("Inhaltlich", feldname);
	}

	public String getMessageForUser() {
		return "Bitte korrigieren Sie den inhaltlichen " + "Eingabefehler im Feld " + this.feldname + ".";
	}
}