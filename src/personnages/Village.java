package personnages;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("obelix", 8);
		village.ajouterVillagois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillageois();
		asterix.sePresenter();
		obelix.sePresenter();
	}

	
	public Village(String nom, Gaulois chef, int habitantsMax) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[habitantsMax];
	}

	public Gaulois getChef() {
		return chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterVillagois(Gaulois gaulois) {
		if (nbVillageois == villageois.length) {
			Gaulois[] nouveauVillageois = new Gaulois[villageois.length + 1];

			for (int i = 0; i < villageois.length; i++) {
				nouveauVillageois[i] = villageois[i];
			}

			villageois = nouveauVillageois;
		}
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}

	public Gaulois trouverVillageois(int numeroGaulois) {
		if (numeroGaulois >= villageois.length || numeroGaulois < 0 || villageois[numeroGaulois - 1] == null) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
		return villageois[numeroGaulois - 1];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village \"Village des Irréductibles\" du chef " + this.chef
				+ " vivent les légendaires gaulois :");
		for (Gaulois gaulois : this.villageois) {
			Gaulois val = gaulois;
			if (val != null)
				System.out.println("- " + val);
		}
	}

}
