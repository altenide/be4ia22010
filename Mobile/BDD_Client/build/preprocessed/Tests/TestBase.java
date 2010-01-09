package Tests;

import DAO_XML.*;
import java.io.FileNotFoundException;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Fonctions de tests du package DAO_XML
 * @author Edith Guilbaud
 */
public class TestBase {

    //Creation d'un parseur, d'un objet ReponsePossibleDAO, extraction des différents éléments
    public static void main(String args[]) {

        XMLDAOFactory factory = new XMLDAOFactory();
        TestBase test = new TestBase();

        //test.testExtractReponse(factory);
        //test.testExtractOrdre(factory);
        //test.testExtractMission(factory);

        //test.testFindOrdre(factory);
        test.testFindReponse(factory);





    }

    private void testExtractReponse(XMLDAOFactory factory) {
        try {
            ReponsePossible reponse = null;

            factory.goToStartDocument();

            reponse = factory.getReponsePossibleDAO().extractReponse();
            System.out.println(reponse);

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void testExtractOrdre(XMLDAOFactory factory) {
        try {
            Ordre ordre = null;

            System.out.println("Ordre sans reponses : ");
            factory.goToStartDocument();
            ordre = factory.getOrdreDAO().extractOrdre(false);
            System.out.println(ordre);

            System.out.println("Ordre avec reponses : ");
            factory.goToStartDocument();
            ordre = factory.getOrdreDAO().extractOrdre(true);
            System.out.println(ordre);

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void testExtractMission(XMLDAOFactory factory) {
        try {
            Mission mission = null;

            System.out.println("Mission sans ordres : ");
            factory.goToStartDocument();
            mission = factory.getMissionDAO().extractMission(false, false);
            System.out.println(mission);

            System.out.println("Mission avec ordres, sans reponses : ");
            factory.goToStartDocument();
            mission = factory.getMissionDAO().extractMission(true, false);
            System.out.println(mission);

            System.out.println("Mission avec ordres et reponses : ");
            factory.goToStartDocument();
            mission = factory.getMissionDAO().extractMission(true, true);
            System.out.println(mission);


        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void testFindReponse(XMLDAOFactory factory) {

        ReponsePossible reponse;
        Ordre ordre;

        try {
            factory.goToStartDocument();
            ordre = factory.getMissionDAO().extractMission(true, true).findOrdre(1);
            reponse = ordre.findReponse("Y a un mur");
            System.out.println(reponse);

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void testFindOrdre(XMLDAOFactory factory) {

        Ordre ordre;
        
        try {
            System.out.println("test sans reponses :");
            factory.goToStartDocument();
            ordre = factory.getMissionDAO().extractMission(true, false).findOrdre(1);
            System.out.println(ordre);

            System.out.println("test avec reponses :");
            factory.goToStartDocument();
            ordre = factory.getMissionDAO().extractMission(true, true).findOrdre(1);
            System.out.println(ordre);
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
