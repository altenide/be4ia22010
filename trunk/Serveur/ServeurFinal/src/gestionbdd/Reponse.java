/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

/**
 * Classe représentant une réponse possible pour un ordre donné
 * @author nfloquet
 */
public class Reponse {
    int idReponse;

    /* Contenu de la réponse */
    private String reponse;

    /* ID de la mission */
    private int idmission;


    /* Ordre actuel */
    private int ordreActuel;

    /* Ordre suivant correspondant à la réponse */
    private int ordreSuivant;

    /**
     * Constructeur de la classe Reponse
     * @param idReponse
     * identifiant de la réponse au sein de l'ordre
     * @param reponse
     * Contenu textuel de la réponse
     * @param ordreActuel
     * Identifiant de l'odre actuel
     * @param ordreSuivant
     * Identifiant de l'ordre suivant
     */
    public Reponse(int idReponse, String reponse,int idmission, int ordreActuel, int ordreSuivant) {
        this.idReponse = idReponse;
        this.reponse = reponse;
        this.idmission = idmission;
        this.ordreActuel = ordreActuel;
        this.ordreSuivant = ordreSuivant;
    }


    /*
     * Getters
     */
    /**
     * Retourne l'identifiant de la réponse
     * @return
     * Identifiant de la réponse au sein de l'ordre
     */
    public int getIdReponse() {
        return idReponse;
    }

    /**
     * Retourne l'identifiant de l'ordre actuel
     * @return
     */
    public int getOrdreActuel() {
        return ordreActuel;
    }

    public int getIdmission() {
        return idmission;
    }

    /**
     * Retourne l'identifiant  de l'ordre suivant
     * @return
     */
    public int getOrdreSuivant() {
        return ordreSuivant;
    }

    /**
     * Retourne le contenu textuel de la réponse
     * @return
     * Contenu textuel de la réponse
     */
    public String getReponse() {
        return reponse;
    }

    /*
     * Setters
     */
    /**
     * Défini l'identifiant de la réponse au sein de l'ordre
     * @param idReponse
     * Identifiant de la réponse au sein de l'ordre
     */
    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public void setIdmission(int idmission) {
        this.idmission = idmission;
    }

    /**
     * Défini l'identifiant de l'ordre actuel
     * @param ordreActuel
     * Identifiant de l'ordre actuel
     */
    public void setOrdreActuel(int ordreActuel) {
        this.ordreActuel = ordreActuel;
    }

    /**
     * Défini l'identifiant de l'ordre suivant
     * @param ordreSuivant
     * Identifiant de l'ordre suivant
     */
    public void setOrdreSuivant(int ordreSuivant) {
        this.ordreSuivant = ordreSuivant;
    }

    /**
     * Défini le contenu textuel de la réponse
     * @param reponse
     * Contenu textuel de la réponse
     */
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

}
