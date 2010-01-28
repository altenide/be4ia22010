/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.util.*;

/**
 * Classe représentant un ordre au sein d'une mission
 * @author nfloquet
 */
public class Ordre {

    /* Identifiant de l'ordre */
    private int idOrdre;

    /* Chaine de l'ordre */
    private String contenu;

    /* nom du fichier audio */
    private String filename;

    /* Permet de savoir si c'est le dernier ordre */
    private boolean dernierOrdre;

    /* ??? */
    private boolean etat;

    /* Liste des réponses possibles */
    private Vector<Reponse> reponsesPossibles;

    /* Mission contenant l'ordre */
    private int idMission;


    /**
     * Constructeur principal de la classe Ordre
     * @param idOrdre
     * Identifiant de l'ordre au sein de la mission
     * @param idMission
     * Identifiant de la mission contenant l'ordre
     * @param contenu
     * Contenu textuel de l'ordre
     * @param dernierOrdre
     * Défini si c'est le dernier ordre de la mission
     */
    public Ordre(int idOrdre, int idMission, String contenu, boolean dernierOrdre) {

        this.idMission = idMission;
        this.idOrdre = idOrdre;
        this.contenu = contenu;
        this.filename = null;
        this.dernierOrdre = dernierOrdre;
        this.etat = false;
        this.reponsesPossibles = new Vector<Reponse>();

    }

    /*
     * Getters
     */
    /**
     * Retourne le contenu textuel de l'ordre
     * @return
     * Contenu textuel de l'ordre
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * Retourne s'il s'agit du dernier ordre de la mission ou non
     * @return
     * TRUE si c'est le dernier ordre, FALSE sinon
     */
    public boolean isDernierOrdre() {
        return dernierOrdre;
    }

    /**
     * Retourne l'état de l'ordre
     * @return
     * Etat de l'ordre
     */
    public boolean getEtat() {
        return etat;
    }

    /**
     * Retourne le nom du fichier audio correspondant à l'ordre
     * @return
     * Nom du fichier audio correspondant à l'ordre
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Retourne l'identifiant de l'ordre au sein de la mission
     * @return
     * Identifiant de l'ordre au sein de la mission
     */
    public int getIdOrdre() {
        return idOrdre;
    }

    /**
     * Retourne un vector des réponses possibles pour l'ordre
     * @return
     * Vector des réponses possibles pour l'ordre
     */
    public Vector<Reponse> getReponsesPossibles() {
        return reponsesPossibles;
    }

    /**
     * Retourne l'identifiant de la mission contenant l'ordre
     * @return
     * Identifiant de la mission contenant l'ordre
     */
    public int getIdMission() {
        return idMission;
    }
    

     /*
     * Setters
     */

    /**
     * Défini le contenu textuel de l'ordre
     * @param contenu
     * Contenu textuel de l'ordre
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * Défini s'il s'agit du dernier ordre de la mission ou non
     * @param dernierOrdre
     * TRUE si c'est le dernier ordre, FALSE sinon
     */
    public void setDernierOrdre(boolean dernierOrdre) {
        this.dernierOrdre = dernierOrdre;
    }

    /**
     * Défini l'état de l'ordre
     * @param etat
     * Etat de l'ordre
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     * Défini le nom du fichier audio correspondant à l'ordre
     * @param filename
     * Nom du fichier audio correspondant à l'ordre
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Défini l'identifiant de l'ordre au sein de la mission
     * @param idOrdre
     * Identifiant de l'ordre au sein de la mission
     */
    public void setIdOrdre(int idOrdre) {
        this.idOrdre = idOrdre;
    }

    /**
     * Défini l'identifiant de la mission contenant l'ordre
     * @param idMission
     * Identifiant de l'ordre contenant la mission
     */
    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    /**
     * Défini le vector des réponses possibles à l'ordre
     * @param reponsesPossibles
     * Vector des réponses possibles à l'ordre
     */
    public void setReponsesPossibles(Vector<Reponse> reponsesPossibles) {
        this.reponsesPossibles = reponsesPossibles;
    }




    /*
     * Autres
     */
    /**
     * Ajoute une réponse à la liste des réponses possibles à l'ordre
     * @param rep
     * Une réponse
     */
    public void addReponse(Reponse rep) {
        this.reponsesPossibles.add(rep);
    }

    /**
     * Enlève une réponse de la listedes réponses possibles à l'ordre
     * @param rep
     * Une réponse
     */
    public void delReponse(Reponse rep) {
        this.reponsesPossibles.remove(rep);
    }
}
