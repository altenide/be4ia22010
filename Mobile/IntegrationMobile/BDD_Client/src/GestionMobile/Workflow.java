package GestionMobile;

import DAO_XML.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Classe de gestion du workflow sur le mobile
 * @author Edith Guilbaud
 */
public class Workflow {


    
    /**
     * Trouve le prochain ordre a executer
     * @param id identifiant de l'ordre courant
     * @param rep reponse a cet ordre
     * @return l'identifiant du prochain ordre correspondant a cette reponse, -5 pour erreur
     */
    public int prochainOrdre(int id, String rep) {

        int retour = -5;

        try {
            XMLDAOFactory factory = new XMLDAOFactory();
            MissionDAO mDao = factory.getMissionDAO();
            Ordre monOrdre = mDao.extractMission(true, true).findOrdre(id);
            if (monOrdre != null) {
                retour = monOrdre.findReponse(rep).getIdOrdreSuivant();
            } else {
                retour = -5;
            }
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return retour;
    }
}
