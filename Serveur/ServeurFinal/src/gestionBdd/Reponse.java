/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

/**
 *
 * @author nfloquet
 */
public class Reponse {
    int idReponse;

    /* Contenu de la réponse */
    private String reponse;

    /* Ordre actuel */
    private int ordreActuel;

    /* Ordre suivant correspondant à la réponse */
    private int ordreSuivant;

    public Reponse(int idReponse, String reponse, int ordreActuel, int ordreSuivant) {
        this.idReponse = idReponse;
        this.reponse = reponse;
        this.ordreActuel = ordreActuel;
        this.ordreSuivant = ordreSuivant;
    }


    /*
     * Getters
     */
    public int getIdReponse() {
        return idReponse;
    }

    public int getOrdreActuel() {
        return ordreActuel;
    }

    public int getOrdreSuivant() {
        return ordreSuivant;
    }

    public String getReponse() {
        return reponse;
    }

    /*
     * Setters
     */
    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public void setOrdreActuel(int ordreActuel) {
        this.ordreActuel = ordreActuel;
    }

    public void setOrdreSuivant(int ordreSuivant) {
        this.ordreSuivant = ordreSuivant;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

}
