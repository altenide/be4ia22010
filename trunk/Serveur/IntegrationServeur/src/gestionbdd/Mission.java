/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.util.*;

/**
 *La classe représentant une mission coté serveur.
 * @author nfloquet
 */
public class Mission {
    
    /**
     *  Enumeration des états possibles pour la mission
     */
    public enum etat_mission {

        /**
         *  La mission n'a pas encore été commencé par l'utilisateur
         */
        EN_ATTENTE,
        /**
         *La Mission est en cours de réalisation
         */
        EN_COURS,
        /**
         * La mission est terminée
         */
        TERMINEE
    };

    /* Identifiant de la mission */
    private int idMission;

    /* Liste des ordres de la mission */
    private Vector<Ordre> listOrdres;

    /* Etat de la mission */
    private etat_mission etat;

    /* Identifiant de l'ordre en cour d'execution */
    private int idOrdreCourant;

    /* Nom de l'utilsateur devant executer la tache*/
    private String utilisateur;

    /* statut de publication */
    private boolean publie;

    /**
     *  Constructeur prenant en paramètre l'identifiant de l'utilisateur associé
     * @param utilisateur
     *               Identifiant de l'utilisateur associé à la mission
     */
    public Mission(String utilisateur) {

        this.idMission = 0;
        this.etat = etat_mission.EN_ATTENTE;
        this.idOrdreCourant = 0;
        this.utilisateur = utilisateur;
        this.publie = false;
        this.listOrdres = new Vector<Ordre>();

    }

    /**
     *  Constructeur par défaut
     */
    public Mission() {

        this.idMission = 0;
        this.etat = etat_mission.EN_ATTENTE;
        this.idOrdreCourant = 0;
        this.utilisateur = "Anonyme";
        this.publie = false;
        this.listOrdres = new Vector<Ordre>();

    }

    /*
     * Getters
     */

    /**
     *  Retourne l'état actuel de la mission
     * @return Etat de la mission
     */
    public etat_mission getEtat() {
        return etat;
    }

    /**
     *  Retourne l'identifiant de la mission
     * @return Identidiant de la mission
     */
    public int getIdMission() {
        return idMission;
    }

    /**
     *  Retourne l'identifiant de l'ordre courant
     * @return Identifiant de l'ordre courant
     */
    public int getIdOrdreCourant() {
        return idOrdreCourant;
    }

    /**
     * Retourne un vector des ordres qui composente la mission
     * @return Vector des ordres de la mission
     * @see Ordre
     */
    public Vector<Ordre> getListOrdres() {
        return listOrdres;
    }

    /**
     * Retourne l'état de publication de la mission
     * @return TRUE si la mission est publiée, FALSE sinon
     */
    public boolean isPublie() {
        return publie;
    }

    /**
     * Retourne l'identifiant de l'utilisateur associé à la mission
     * @return Le login de l'utillisateur associé à la mission
     */
    public String getUtilisateur() {
        return utilisateur;
    }

    /*
     * Setters
     */

    /**
     * Défini l'état actuel de la mission
     * @param etat
     *  Etat à donner à la mission
     */
    public void setEtat(etat_mission etat) {
        this.etat = etat;
    }

    /**
     *Défini l'identifiant de la mission
     * @param idMission
     *  Identifiant de la mission
     */
    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    /**
     *Défini l'identifiant de l'ordre courant
     * @param idOrdreCourant
     * identifiant de l'ordre courant
     */
    public void setIdOrdreCourant(int idOrdreCourant) {
        this.idOrdreCourant = idOrdreCourant;
    }

    /**
     *Défini l'état de publication
     * @param publie
     * Etat de publication
     */
    public void setPublie(boolean publie) {
        this.publie = publie;
    }

    /**
     *Défini l'utilisateur associé à la mission
     * @param utilisateur
     * identifiant de l'utilisateur
     */
    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     *Défini la liste des ordres de la mission
     * @param listOrdres
     * Liste d'ordres
     * @see Ordre
     */
    public void setListOrdres(Vector<Ordre> listOrdres) {
        this.listOrdres = listOrdres;
    }

    

    /*
     * Autres
     */
    /**
     * Ajoute un ordre à la liste des ordres de la mission
     * @param ordre
     * Un ordre
     * @see Ordre
     */
    public void addOrdre(Ordre ordre) {
        this.listOrdres.add(ordre);
    }
    /**
     *Supprime un ordre de la list des ordres de la mission
     * @param ordre
     * Un ordre
     * @see Ordre
     */
    public void delOrdre(Ordre ordre) {
        this.listOrdres.remove(ordre);
    }

}
