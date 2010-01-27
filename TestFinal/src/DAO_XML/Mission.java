package DAO_XML;

import java.util.Vector;

/**
 * Classe représentant une mission
 * @author Edith Guilbaud
 */
public class Mission {

    /**
     * Entier identifiant de maniere unique la mission
     */
    private int idMission;
    /**
     * Etat de la mission, 
     * valeurs possibles : "Disponible", "EnCours" ou "Termine"
     */
    private String etat;
    /**
     * Identifiant de l'ordre en cours de traitement
     * (identifiant du premier ordre a executer si la mission n'a pas encore debute)
     */
    private int idOrdreCourant;
    /**
     * Operateur a qui est destinee la mission
     */
    private String destinataire;
    /**
     * Statut de publicationd de la mission sur le serveur
     */
    private boolean publie;
    /**
     * Date de creation de la mission
     */
    private String date;
    /**
     * Liste des ordres composants la mission (vecteur d'Ordre)
     */
    private Vector ordres;

    /**
     * Constructeur d'une mission
     * @param idMission identifiant de la mission
     * @param etat  etat de la mission
     * @param idOrdreCourant identifiant de l'ordre en cours
     * @param destinataire nom de l'operateur a qui elle est destinee
     * @param publie statut de publication
     * @param date date de creation
     */
    public Mission(int idMission, String etat, int idOrdreCourant, String destinataire, boolean publie, String date) {
        this.idMission = idMission;
        this.etat = etat;
        this.idOrdreCourant = idOrdreCourant;
        this.destinataire = destinataire;
        this.publie = publie;
        this.date = date;
        ordres = null; // a initialiser ensuite pour ajouter des ordres
    }

    /**
     * Recupere l'ordre en cours d'une mission
     * @return l'identifiant de l'ordre courant
     */
    public int getIdOrdreCourant() {
        return idOrdreCourant;
    }

    /**
     * Initialise la liste des ordres associes a la mission
     */
    public void initOrdres() {
        ordres = new Vector();
    }

    /**
     * Ajoute un ordre a la mission.
     * Appel a initOrdres() necessaire avant l'ajout du premier ordre
     * @param o Ordre a ajouter
     */
    public void addOrdre(Ordre o) {
        ordres.add(o);
    }

    /**
     * Cherche et extrait un ordre particulier
     * @param id identifiant de l'ordre à récupérer
     * @return l'ordre voulu si trouvé, null si non
     */
    public Ordre findOrdre(int id) {

        Ordre ordre = null;
        int cpt = 0;
        boolean found = false;

        while (cpt != ordres.size()) {
            ordre = (Ordre) ordres.get(cpt);
            cpt++;

            if (ordre.getIdOrdre() == id) {
                found = true;
                break;
            }

        }

        if (found == false) {
            ordre = null;
        }

        return ordre;
    }

    /**
     * Redefinition de toString utilisee pour tests et debugs
     * @return les valeurs des attributs de la mission
     */
    public String toString() {
        return "Mission : " + idMission + " , " + etat + " , " + idOrdreCourant + " , " + destinataire + " , " + publie + " , " + date + " , " + ordres;
    }
}
