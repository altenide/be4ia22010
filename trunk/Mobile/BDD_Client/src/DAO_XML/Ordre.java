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

    public String toString() {
        return "Ordre : "+idOrdre+", "+contenu+", "+etat+", "+reponses+", "+ordreFinal+", "+fichierAudio+"\n";
    }

    public void initReponses()
    {
        reponses = new Vector();
    }




}
