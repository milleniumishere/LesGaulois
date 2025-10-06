package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 0;
	private Village village;

	public void setVillage(Village village) {
		this.village = village;
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	@Override
	public String toString() {
		return nom;
	}

	public Village getVillage() {
		return village;
	}

	public String getNom() {
		return nom;
	}

	public void sePresenter() {
		Village village = this.getVillage();
		String texte = ". Je voyage de villages en villages.";
		if (village != null) {
			if (village.getChef().getNom() == nom) {
				texte = ".  Je suis le chef du village " + village.getNom();
			} else {
				texte = ". J'habite le village " + village.getNom();
			}
		}

		System.out.println(prendreParole() + "Bonjour, je m'appelle " + nom + texte);
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
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

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}
}