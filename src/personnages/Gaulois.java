package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 0;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}

	@Override
	public String toString() {
		return nom;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		int forceCoup = force;
		if (effetPotion > 0) {
			forceCoup = forceCoup * effetPotion;
			effetPotion--;
		}
		romain.recevoirCoup(forceCoup / 3);
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
}