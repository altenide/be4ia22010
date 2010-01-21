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
    public String getContenu() {
        return contenu;
    }

    public boolean isDernierOrdre() {
        return dernierOrdre;
    }

    public boolean getEtat() {
        return etat;
    }

    public String getFilename() {
        return filename;
    }

    public int getIdOrdre() {
        return idOrdre;
    }

    public Vector<Reponse> getReponsesPossibles() {
        return reponsesPossibles;
    }

    public int getIdMission() {
        return idMission;
    }
    

     /*
     * Setters
     */

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDernierOrdre(boolean dernierOrdre) {
        this.dernierOrdre = dernierOrdre;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setIdOrdre(int idOrdre) {
        this.idOrdre = idOrdre;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public void setReponsesPossibles(Vector<Reponse> reponsesPossibles) {
        this.reponsesPossibles = reponsesPossibles;
    }




    /*
     * Autres
     */
    public void addReponse(Reponse rep) {
        this.reponsesPossibles.add(rep);
    }

    public void delReponse(Reponse rep) {
        this.reponsesPossibles.remove(rep);
    }
}
