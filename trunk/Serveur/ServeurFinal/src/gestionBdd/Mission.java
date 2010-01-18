/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.util.*;

/**
 *
 * @author nfloquet
 */
public class Mission {
    
    public enum etat_mission{ EN_ATTENTE, EN_COURS, TERMINEE };

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

    public Mission(String utilisateur) {

        this.idMission = 0;
        this.etat = etat_mission.EN_ATTENTE;
        this.idOrdreCourant = 0;
        this.utilisateur = utilisateur;
        this.publie = false;

    }

    /*
     * Getters
     */

    public etat_mission getEtat() {
        return etat;
    }

    public int getIdMission() {
        return idMission;
    }

    public int getIdOrdreCourant() {
        return idOrdreCourant;
    }

    public Vector<Ordre> getListOrdres() {
        return listOrdres;
    }

    public boolean isPublie() {
        return publie;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    /*
     * Setters
     */

    public void setEtat(etat_mission etat) {
        this.etat = etat;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public void setIdOrdreCourant(int idOrdreCourant) {
        this.idOrdreCourant = idOrdreCourant;
    }

    public void setPublie(boolean publie) {
        this.publie = publie;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setListOrdres(Vector<Ordre> listOrdres) {
        this.listOrdres = listOrdres;
    }

    

    /*
     * Autres
     */
    public void addOrdre(Ordre ordre) {
        this.listOrdres.add(ordre);
    }
    public void delOrdre(Ordre ordre) {
        this.listOrdres.remove(ordre);
    }

}
