/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionMobile;

import DAO_XML.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author Edith
 */
public class FichierXML {

    String path, fichier;

    public FichierXML(String path) {
        super();
        this.path = path;
    }

    public void setFichier(String fichier){
    	this.fichier = fichier;
    }
    
    //renvoie l'intule d'un ordre
    public String intituleOrdre(int idOrdre) {

        Ordre ordre = null;
        XMLDAOFactory factory = new XMLDAOFactory(path, fichier);
        factory.setPath(path);


        MissionDAO mDao = factory.getMissionDAO();
        try {
            mDao.goToStartDocument();
            Mission mission = mDao.extractMission(true, true);
            ordre = mission.findOrdre(idOrdre);

            if (ordre == null) System.out.println(idOrdre+" ici");
            
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ordre.getContenu();

    }

    //renvoie un vecteur (de String) avec tous les choix possibles d'un ordre
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
