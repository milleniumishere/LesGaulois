package personnages;

public class Gaulois {
	private String nom;
	private int froce;

	public Gaulois(String nom, int froce) {
		this.nom = nom;
		this.froce = froce;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois "+nom+" : ";
	}
}