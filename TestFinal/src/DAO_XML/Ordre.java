package DAO_XML;

import java.util.Vector;

/**
 * Classe représentant un ordre
 * @author Edith Guilbaud
 */
public class Ordre {

    /**
     * Entier permettant d'identifier un ordre dans une mission, 
     * -2 s'il s'agit de l'ordre de fin de mission
     */
    private int idOrdre;
    /**
     * Texte de l'ordre
     */
    private String contenu;
    /**
     * Etat de l'ordre,
     * valeurs possibles : "Disponible", "EnCours" ou "Termine"
     */
    private String etat;
    /**
     * Reponses possibles a l'ordre (sous forme de Vecteur de ReponsePossible)
     */
    private Vector reponses;
    /**
     * Booleen valant true si l'ordre est l'ordre de fin de mission, false sinon
     */
    private boolean ordreFinal;
    /**
     * Nom du fichier audio genere par synthese vocale de l'ordre
     */
    private String fichierAudio;

    /**
     * Constructeur d'un ordre
     * @param idOrdre identifiant de l'ordre
     * @param contenu texte du contenu de l'ordre
     * @param etat etat de l'ordre
     * @param ordreFinal indique s'il s'agit de l'ordre final de la mission
     */
    public Ordre(int idOrdre, String contenu, String etat, boolean ordreFinal) {
        this.idOrdre = idOrdre;
        this.contenu = contenu;
        this.etat = etat;
        this.reponses = null;
        this.ordreFinal = ordreFinal;
        this.fichierAudio = null; // a initialiser ensuite pour ajouter des reponses possibles

    }

    /**
     * Recupere le texte de l'ordre
     * @return le contenu
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * Recupere l'etat de l'odre
     * @return l'etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * Recupere le nom du fichier audio associe a l'ordre
     * @return le nom du fichier
     */
    public String getFichierAudio() {
        return fichierAudio;
    }

    /**
     * Recupere l'identifiant de l'ordre
     * @return l'identifiant de l'ordre (entier)
     */
    public int getIdOrdre() {
        return idOrdre;
    }

    /**
     * Recupere les reponses possibles associees a l'ordre
     * @return un vecteur contenant les reponses possibles
     */
    public Vector getReponses() {
        return reponses;
    }

    /**
     * Indique si l'ordre est l'ordre de fin de mission ou pas
     * @return true si c'est le cas, false sinon
     */
    public boolean isOrdreFinal() {
        return ordreFinal;
    }

    /**
     * Ajoute une reponse possible a l'ordre.
     * Appel a initReponses() necessaire avant l'ajout de la premiere reponse
     * @param rep ReponsePossible a ajouter
     */
    public void addReponse(ReponsePossible rep) {
        reponses.add(rep);
    }

    /**
     * Ajoute le nom du fichier audio correspondant a l'ordre
     * @param fichier nom du fichier audio a associer a l'ordre
     */
    public void addFichierAudio(String fichier) {
        this.fichierAudio = fichier;
    }

    /**
     * Initialise la liste des reponses possibles a l'ordre
     */
    public void initReponses() {
        reponses = new Vector();
    }

    /**
     * Cherche et extrait une réponse particuliere par son contenu
     * @param rep contenu de la reponse a trouver
     * @return la reponse voulue si trouvée, null si non
     */
    public ReponsePossible findReponse(String rep) {

        ReponsePossible reponse = null;
        int cpt = 0;
        boolean found = false;

        while (cpt != reponses.size()) {
            reponse = (ReponsePossible) reponses.get(cpt);
            cpt++;

            if (reponse.getReponse().equals(rep)) {
                found = true;
                break;
            }

        }

        if (found == false) {
            reponse = null;
        }
        return reponse;
    }

    /**
     * Redefinition de toString utilisee pour tests et debugs
     * @return les attributs de l'ordre
     */
    public String toString() {
        return "Ordre : " + idOrdre + ", " + contenu + ", " + etat + ", " + reponses + ", " + ordreFinal + ", " + fichierAudio + "\n";
    }
}
