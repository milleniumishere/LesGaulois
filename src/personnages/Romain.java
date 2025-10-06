package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert this.isInvariantVerified();
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
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

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int saveFroce = force;
		force = force - forceCoup;
		if (force < 1) {
			parler("J'abandonne !");
			force = 0;
		} else {
			parler("Aie !");
		}
		assert force < saveFroce;
		assert this.isInvariantVerified();
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement);
			} else {
				ajouterEquipement(equipement);
			}
			break;

		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
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
}