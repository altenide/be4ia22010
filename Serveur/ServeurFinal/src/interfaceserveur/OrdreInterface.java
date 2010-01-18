/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceserveur;

/**
 *
 * @author mac
 */
public class OrdreInterface {

    private String nom;
    private String texte;
    private String[] reponse;
    private OrdreInterface[] ordreSuivant;

    public OrdreInterface(String nomentre) {
        this.nom = nomentre;
        this.texte = null;
        this.reponse = new String[41];
        this.ordreSuivant = new OrdreInterface[41];
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the texte
     */
    public String getTexte() {
        return texte;
    }

    /**
     * @param texte the texte to set
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     * @return the reponse
     */
    public String[] getReponse() {
        return reponse;
    }

    /**
     * @param reponse the reponse to set
     */
    public void setReponse(String[] reponse) {
        this.reponse = reponse;
    }

    public int positionDerniereReponse() {
        int i=0;
        while (reponse[i] != null)
                    i++;
        return i;

    }

    /**
     * @return the ordreSuivant
     */
    public OrdreInterface[] getOrdreSuivant() {
        return ordreSuivant;
    }

    /**
     * @param ordreSuivant the ordreSuivant to set
     */
    public void setOrdreSuivant(OrdreInterface[] ordreSuivant) {
        this.ordreSuivant = ordreSuivant;
    }

    /**
     * @return the ordreSuivant
     */

}
