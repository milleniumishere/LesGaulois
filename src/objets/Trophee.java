package objets;

import personnages.Gaulois;

public class Trophee {
	private Gaulois gaulois;
	private Equipement equipements;

	public Trophee() {
		super();

	}

	public Gaulois getGaulois() {
		return gaulois;
	}

	public Equipement getEquipements() {
		return equipements;
	}

	public String donnerNom() {
		return gaulois.getNom();
	}

}
