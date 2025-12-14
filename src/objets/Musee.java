package objets;

import personnages.Gaulois;

public class Musee {
    private Trophee[] trophee;
    private int nbTrophees;

    public void donnerTrophee(Gaulois gaulois, Equipement equipement){
        nbTrophees++;
        trophee[nbTrophees] = new Trophee();
    }

    public String extraireInstructionsOCaml() {
        StringBuilder ocaml = new StringBuilder();
        ocaml.append("let musee = [\n");

        for (int i = 0; i < nbTrophees; i++) {
            ocaml.append("\"" + trophee[i].donnerNom() + "\", \"" + trophee[i].getEquipements().getNom() + "\"");

            if (i < nbTrophees - 1) {
                ocaml.append(";\n");
            } else {
                ocaml.append("\n");
            }
        }

        ocaml.append("]");
        String str = ocaml.toString();
        return str;
    }
}

