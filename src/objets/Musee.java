package objets;

import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee aAjouter = new Trophee()
		trophees[nbTrophee] = equipement;
		nbTrophee+=1;
	}
}
