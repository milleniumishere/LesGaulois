package objets;

import personnages.Gaulois;

public class Musee {
    private Trophee[] trophee;
    private int nbTrophees;

    public Musee() {
        trophee = new Trophee[200];
        nbTrophees = 0;
    }

    public void donnerTrophee(Gaulois gaulois, Equipement equipement){
        trophee[nbTrophees] = new Trophee(equipement, gaulois);
        nbTrophees++;
    }

    public String extraireInstructionsOCaml() {
        StringBuilder ocaml = new StringBuilder();
        ocaml.append("let musee = [\n");

        for (int i = 0; i < nbTrophees; i++) {
            ocaml.append("\"" + trophee[i].donnerNom() + "\", \"" 
                         + trophee[i].getEquipement().getNom() + "\"");

            if (i < nbTrophees - 1) {
                ocaml.append(";\n");
            } else {
                ocaml.append("\n");
            }
        }

        ocaml.append("]");
        return ocaml.toString();
    }
}
