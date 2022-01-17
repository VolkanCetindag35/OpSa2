package ownUtil;

public class FormalePlausiException extends PlausiException {

	private static final long serialVersionUID = 1L;

	public FormalePlausiException(String feldname) {
		super("Formal", feldname);
	}

	public String getMessageForUser() {
		return "Bitte korrigieren Sie den formalen " + "Eingabefehler im Feld " + this.feldname + ".";
	}
}