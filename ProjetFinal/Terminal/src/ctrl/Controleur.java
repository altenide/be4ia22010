package ctrl;

import java.util.Vector;

import audio.LectureAudio;

import GestionMobile.FichierXML;
import GestionMobile.Workflow;
import gui.IHM;
import network.TCPClient;

/**
 * Classe contrôleur du terminal
 */
public class Controleur {

    /**
     * Interface graphique
     */
    private IHM ihm;
    /**
     * Gestion reseau
     */
    private TCPClient tcpC;
    /**
     * Acces a la base de donnees XML
     */
    private FichierXML xml;
    /**
     * Gestion du workflow
     */
    private Workflow worflow;
    /**
     * Lecture Audio
     */
    private LectureAudio player;


    
    public Controleur() {
    }


    //////////////////////////Partie pour la base de donnee client//////////////

    /**
     * Recupere le module de gestion du fichier XML
     * @return 
     */
    public FichierXML getXml() {
        return xml;
    }

    /**
     * Affectation du module de gestion XML
     * @param xml
     */
    public void setXml(FichierXML xml) {
        this.xml = xml;
    }

    /**
     * Affectation du module d'interface graphique
     * @param ihm
     */
    public void setIHM(IHM ihm) {
        this.ihm = ihm;
    }

    /**
     * Recupere l'intilule d'un ordre
     * @param id identifiant de l'ordre a examiner
     * @return le texte de l'ordre
     */
    public String Ordre(int id) {
        String ordre;
        ordre = xml.intituleOrdre(id);
        return ordre;
    }

    /**
     * Recupere les reponses possibles d'un ordre
     * @param id identidfiant de l'ordre a examiner
     * @return la liste des reponses possibles
     */
    public Vector ReponsePossible(int id) {
        Vector reponse;
        reponse = xml.choixPossible(id);
        return reponse;
    }

    /**
     * Recupere le numero de l'ordre suivant
     * @param idCourant identifiant de l'ordre auquel on reponds
     * @param reponse reponse donnee
     * @return l'identifiant de l'ordre suivant
     */
    public int OrdreSuivant(int idCourant, String reponse) {
        int ordresuivant;
        ordresuivant = worflow.validationOrdre(idCourant, reponse);
        return ordresuivant;

    }

    /**
     * Recupere le nom du fichier audio correspondant a un ordre
     * @param id identifiant de l'ordre dont on cherche le fichier audio
     * @return le nom du fichier audio correspondant
     */
    public String GetFichierAudio(int id) {
        return xml.getFichierAudio(id) + ".wav";
    }

    /**
     * Recupere l'identifiant de l'ordre en cours de traitement dans la mission,
     * correspond au premier ordre a executer si la mission n'a pas debute
     * @return
     */
    public int GetIdOrdreCourant() {
        return xml.getIdOrdreCourant();
    }
    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////lecteur fichier audio//////////////////

    /**
     * Lis le fichier audio specifie
     * @param fichier nom (avec chemin) du fichier audio a lire
     */
    public void lireAudio(String fichier) {
        player.lire(fichier);

    }

    /**
     * Affectation du module de gestion du fichier audio
     * @param player
     */
    public void setPlayer(LectureAudio player) {
        this.player = player;
    }
    //////////////////////////////////////////////////////////////////////

    /**
     * Affectation du module de gestion reseau
     * @param tcpC
     */
    public void setTCPClient(TCPClient tcpC) {
        this.tcpC = tcpC;
    }

    /**
     * Affiche l'information voulue sur l'interface graphique
     * @param msg message a afficher
     */
    public void showInfo(String msg) {
        ihm.showInfo(msg);
    }

    /**
     * Raffraichis l'affichage d'un message sur l'interface graphique
     * @param msg message a raffraichir
     */
    public void refreshMsg(String msg) {
        ihm.refreshMsg(msg);
    }

    /**
     * Envoie une demande de log au serveur
     * @param login
     * @param mdp
     */
    public void envoyerLog(String login, String mdp) {
        tcpC.send("login;:!" + login + ";:!mdp;:!" + mdp);
    }

    /**
     * Envoie une confirmation de log a l'interface graphique
     */
    public void loginOK() {
        ihm.disableLogin();
    }

    /**
     * Affectation du module de gestion du worflow
     * @param worflow
     */
    public void setWorflow(Workflow worflow) {
        this.worflow = worflow;
    }

    /**
     * Attribution du nom du fichier XML où se situe la mission
     * @param fichier
     */
    public void setFichier(String fichier) {
        worflow.setFichier(fichier);
        xml.setFichier(fichier);
    }

    /**
     * Affiche un ordre sur l'interface graphique
     */
    public void afficherOrdre() {
        ihm.affichageOrdre();
    }
}
