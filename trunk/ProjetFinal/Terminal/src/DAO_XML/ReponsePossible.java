package DAO_XML;

/**
 * Classe representant une reponse possible a un ordre
 * @author Edith Guilbaud
 */
public class ReponsePossible {

    /**
     * Entier identifiant la reponse
     */
    private int idReponse;
    /**
     * Texte de la reponse
     */
    private String Reponse;
    /**
     * Identifiant de l'ordre suivant a executer suite a cette reponse
     */
    private int idOrdreSuivant;

    /**
     * Constructeur d'une reponse
     * @param idReponse Identifiant de la reponse
     * @param Reponse Texte de la reponse
     * @param idOrdreSuivant Identifiant de l'ordre suivant a executer
     */
    public ReponsePossible(int idReponse, String Reponse, int idOrdreSuivant) {
        this.idReponse = idReponse;
        this.Reponse = Reponse;
        this.idOrdreSuivant = idOrdreSuivant;
    }

    /**
     * Recupere l'identifiant de l'ordre qui suit cette reponse
     * @return l'identifiant de l'ordre
     */
    public int getIdOrdreSuivant() {
        return idOrdreSuivant;
    }

    /**
     * Recupere l'identifiant de la reponse
     * @return l'indentifiant
     */
    public int getIdReponse() {
        return idReponse;
    }

    /**
     * Recupere le contenu textuel de la reponse
     * @return le texte de la reponse
     */
    public String getReponse() {
        return Reponse;
    }

    /**
     * Redefinition de toString utilisee pour tests et debugs
     * @return les attributs de la reponse
     */
    public String toString() {
        return "Reponse : id =" + idReponse + " , contenu =" + Reponse + " , suivant =" + idOrdreSuivant + "\n";
    }
}
