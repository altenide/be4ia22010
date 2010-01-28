package GestionMobile;

import DAO_XML.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Classe de manipulation du fichier XML
 * @author Edith
 */
public class FichierXML {

    /**
     * Chemin et nom du fichier XML
     */
    String path, fichier;

    public FichierXML(String path) {
        super();
        this.path = path;
    }

    /**
     * Rentre le nom du fichier XML
     * @param fichier nom du fichier
     */
    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    /**
     * Cherche l'intitule (texte) d'un ordre
     * @param idOrdre identifiant de l'ordre dont on veut recuperer le texte
     * @return le texte de l'ordre voulu
     */
    public String intituleOrdre(int idOrdre) {

        Ordre ordre = null;
        XMLDAOFactory factory = new XMLDAOFactory(path, fichier);
        factory.setPath(path);


        MissionDAO mDao = factory.getMissionDAO();
        try {
            mDao.goToStartDocument();
            Mission mission = mDao.extractMission(true, true);
            ordre = mission.findOrdre(idOrdre);

            if (ordre == null) {
                System.out.println(idOrdre + " ici");
            }

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ordre.getContenu();

    }

    /**
     * Cherche les reponses possibles a un ordre
     * @param idOrdre identifiant de l'ordre dont on veut etudier les reponses
     * @return un vecteur de String avec tous les textes des reponses possibles a l'ordre
     */
    public Vector choixPossible(int idOrdre) {

        Ordre ordre = null;
        ReponsePossible repP;

        Vector reponses = new Vector();
        XMLDAOFactory factory = new XMLDAOFactory(path, fichier);
        factory.setPath(path);

        MissionDAO mDao = factory.getMissionDAO();
        try {
            mDao.goToStartDocument();
            Mission mission = mDao.extractMission(true, true);
            ordre = mission.findOrdre(idOrdre);

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        int i = 0;
        int x = 0;

        Vector tabReponses = ordre.getReponses();
        if (tabReponses != null) {
            while (i < tabReponses.size()) {
                repP = (ReponsePossible) tabReponses.get(i);
                reponses.add(repP.getReponse());
                i++;
            }
        } else {
            reponses = null;
        }

        return reponses;
    }

    /**
     * Recupere l'ordre en cours de la mission
     * @return l'indentifiant de l'ordre courant
     */
    public int getIdOrdreCourant() {

        Mission mission = null;

        try {
            XMLDAOFactory factory = new XMLDAOFactory(path, fichier);
            factory.setPath(path);
            MissionDAO mDao = factory.getMissionDAO();
            mDao.goToStartDocument();
            mission = mDao.extractMission(false, false);

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return mission.getIdOrdreCourant();

    }

    /**
     * Recupere le nom du fichier audio correspondant a l'ordre
     * @param idOrdre identifiant de l'ordre considere
     * @return le nom du fichier audio associe
     */
    public String getFichierAudio(int idOrdre) {
        Mission mission;
        Ordre ordre = null;

        try {
            XMLDAOFactory factory = new XMLDAOFactory(path, fichier);
            factory.setPath(path);
            MissionDAO mDao = factory.getMissionDAO();
            mDao.goToStartDocument();
            mission = mDao.extractMission(true, false);

            ordre = mission.findOrdre(idOrdre);

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return ordre.getFichierAudio();
    }
}
