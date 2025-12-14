package personnages;

import objets.Equipement;
import objets.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 0;
	private Village village;

	public void setVillage(Village village) {
		this.village = village;
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

//	@Override
//	public String toString() {
//		return nom;
//	}

	public Village getVillage() {
		return village;
	}

	public String getNom() {
		return nom;
	}

	public void sePresenter() {
		Village currentVillage = this.getVillage();
		String texte = ". Je voyage de villages en villages.";
		if (currentVillage != null) {
			if (currentVillage.getChef().getNom() == this.nom) {
				texte = ".  Je suis le chef du village " + currentVillage.getNom();
			} else {
				texte = ". J'habite le village " + currentVillage.getNom();
			}
		}

		System.out.println(prendreParole() + "Bonjour, je m'appelle " + nom + texte);
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
//		int forceCoup = force;
//		if (effetPotion > 0) {
//			forceCoup = forceCoup * effetPotion;
//			effetPotion--;
//		}
//		romain.recevoirCoup(forceCoup / 3);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] tropheesGaulois = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesGaulois != null && i < tropheesGaulois.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesGaulois[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}

	public void faireUneDonation(Musee musee){
        System.out.println(prendreParole() + "Je donne au musee tous mes trophees :");
        for (int i =0; i<nbTrophees; i++){
            System.out.println("- " + trophees[i].getNom());
            musee.donnerTrophee(this,trophees[i]);
        }
        nbTrophees = 0;
    }
}