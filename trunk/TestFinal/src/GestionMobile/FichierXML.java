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
	String path;
	
	
 

	public FichierXML(String path) {
		super();
		this.path = path;
	}

	//renvoie l'intule d'un ordre
    public String intituleOrdre(int idOrdre) {

        Ordre ordre = null;
        XMLDAOFactory factory = new XMLDAOFactory();
        factory.setPath(path);


        MissionDAO mDao = factory.getMissionDAO();
        try {
            Mission mission = mDao.extractMission(true, true);
            ordre = mission.findOrdre(idOrdre);

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
        XMLDAOFactory factory = new XMLDAOFactory();
        factory.setPath(path);

        MissionDAO mDao = factory.getMissionDAO();
        try {
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
            XMLDAOFactory factory = new XMLDAOFactory();
            factory.setPath(path);
            MissionDAO mDao = factory.getMissionDAO();
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
}
