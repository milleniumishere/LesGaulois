package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert this.isInvariantVerified();
	}

	private boolean isInvariantVerified() {
		return this.force > 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		int oldForce = force;
		force -= forceCoup;
		if (force == oldForce) {
			parler("AHAH je n'ai rien senti !");
		}
		if (force != 0) {
			if(nbEquipement>0) equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			vainqueur=false;
		}
		return equipementEjecte;
	}

//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup > 0;
//		int saveFroce = force;
//		force = force - forceCoup;
//		if (force < 1) {
//			parler("J'abandonne !");
//			force = 0;
//		} else {
//			parler("Aie !");
//		}
//		assert force < saveFroce;
//		assert this.isInvariantVerified();
//	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement > 0 && equipements[0] != null) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {

				if (equipements[i].equals(Equipement.BOUCLIER)) {
					System.out.println("Equipement bouclier");
					resistanceEquipement += 8;
				} else if (equipements[i].equals(Equipement.CASQUE)) {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}

			texte += resistanceEquipement + "!";
		}

		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0)
			forceCoup = 0;
		return forceCoup;
	}

	public int getForce() {
		return force;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		nbEquipement=0;
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		String role = "Le soldat ";
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println(role + nom + " possede deja un " + equipement);
			} else {
				ajouterEquipement(equipement);
			}
			break;

		case 2:
			System.out.println(role + nom + "est déjà bien protégé !");
			break;

		default:
			System.out.println("Erreur : nombre d'équipements invalide (" + nbEquipement + ")");
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec " + equipement);
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}

	public boolean isVainqueur() {
		return vainqueur;
	}
}