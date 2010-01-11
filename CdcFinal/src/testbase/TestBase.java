/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testBase;

import DAO_XML.Mission;
import DAO_XML.Ordre;
import DAO_XML.ReponsePossible;
import DAO_XML.XMLDAOFactory;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author Edith
 */
public class TestBase {



    //Creation d'un parseur, d'un objet ReponsePossibleDAO, extraction d'une réponse
    public static void main(String args[]) {

        System.out.println("start");
        //ReponsePossible reponse = null;
        //Ordre ordre = null;
        Mission mission = null;

        XMLDAOFactory factory = new XMLDAOFactory();
        try {
            //reponse = factory.getReponsePossibleDAO().extractReponse();
            //ordre = factory.getOrdreDAO().extractOrdre(true);
            mission = factory.getMissionDAO().extractMission(true, true);
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //System.out.println(reponse);
        System.out.println(mission);
        


    }
}
