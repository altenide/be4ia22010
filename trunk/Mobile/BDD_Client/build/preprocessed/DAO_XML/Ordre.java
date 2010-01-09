/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_XML;

import java.util.Vector;

/**
 *
 * @author Edith
 */
public class Ordre {

    private int idOrdre;
    private String contenu;
    private String etat;
    private Vector reponses;
    private boolean ordreFinal;
    private String fichierAudio;

    public Ordre(int idOrdre, String contenu, String etat, boolean ordreFinal) {
        this.idOrdre = idOrdre;
        this.contenu = contenu;
        this.etat = etat;
        this.reponses = null;
        this.ordreFinal = ordreFinal;
        this.fichierAudio = null;

    }

    public String getContenu() {
        return contenu;
    }

    public String getEtat() {
        return etat;
    }

    public String getFichierAudio() {
        return fichierAudio;
    }

    public int getIdOrdre() {
        return idOrdre;
    }

    public boolean isOrdreFinal() {
        return ordreFinal;
    }

    public void addReponse(ReponsePossible rep) {
        reponses.add(rep);
    }

    public void addFichierAudio(String fichier) {
        this.fichierAudio = fichier;
    }

    public void initReponses() {
        reponses = new Vector();
    }

    /**
     * Cherche et extrait une réponse particuliere par son contenu
     * @param rep contenu de la reponse a trouver
     * @return la reponse voulue si trouvée, null si non
     */
    public ReponsePossible findReponse(String rep) {

        ReponsePossible reponse = null;
        int cpt = 0;
        boolean found = false;

        while (cpt != reponses.size()) {
            reponse = (ReponsePossible) reponses.get(cpt);
            cpt++;

            if (reponse.getReponse().equals(rep)) {
                found = true;
                break;
            }

        }

        if (found == false){
            reponse = null;
        }
        return reponse;
    }

    public String toString() {
        return "Ordre : " + idOrdre + ", " + contenu + ", " + etat + ", " + reponses + ", " + ordreFinal + ", " + fichierAudio + "\n";
    }
}
