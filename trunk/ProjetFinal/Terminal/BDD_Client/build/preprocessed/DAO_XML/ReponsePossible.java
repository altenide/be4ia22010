/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO_XML;

/**
 *
 * @author Edith
 */
public class ReponsePossible {

    private int idReponse;
    private String Reponse;
    private int idOrdreSuivant;

    public ReponsePossible(int idReponse, String Reponse, int idOrdreSuivant) {
        this.idReponse = idReponse;
        this.Reponse = Reponse;
        this.idOrdreSuivant = idOrdreSuivant;
    }

    public int getIdOrdreSuivant() {
        return idOrdreSuivant;
    }

    public int getIdReponse() {
        return idReponse;
    }

    public String getReponse() {
        return Reponse;
    }

    



    public String toString(){
        return "Reponse : id ="+idReponse+" , contenu ="+Reponse+" , suivant ="+idOrdreSuivant+"\n";
    }

}
