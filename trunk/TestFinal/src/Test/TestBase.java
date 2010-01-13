package Test;

import DAO_XML.*;
import GestionMobile.FichierXML;

import java.io.FileNotFoundException;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Fonctions de tests du package DAO_XML
 * @author Edith Guilbaud
 */
public class TestBase {

    
    public static void main(String args[]) {

        XMLDAOFactory factory = new XMLDAOFactory();
        TestBase test = new TestBase();

        test.testExtractReponse(factory);
        //test.testExtractOrdre(factory);
        //test.testExtractMission(factory);

        //test.testFindOrdre(factory);
        //test.testFindReponse(factory);

        //test.testMiseAJourOrdreCourant(factory);
        //test.testMiseAJourEtatMission(factory);
        //test.testMiseAJourEtatOrdre(factory);





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

    public void testMiseAJourOrdreCourant(XMLDAOFactory factory) {
        try {
            MissionDAO mDao = factory.getMissionDAO();
            mDao.MiseAJourOrdreCourant(7);
            factory.goToStartDocument();
            Mission newMission = mDao.extractMission(false, false);

            System.out.println("Valeur theorique du nouvel ordre courant de la mission : 7");
            System.out.println("Attributs de la mission :");
            System.out.println(newMission);
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public void testMiseAJourEtatMission(XMLDAOFactory factory) {
        try {
            MissionDAO mDao = factory.getMissionDAO();
            mDao.MiseAJourEtat("MisAJour!");
            factory.goToStartDocument();
            Mission newMission = mDao.extractMission(false, false);

            System.out.println("Valeur theorique du nouvel etat de la mission : MisAJour!");
            System.out.println("Attributs de la mission :");
            System.out.println(newMission);
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public void testMiseAJourEtatOrdre(XMLDAOFactory factory) {
        try {
            OrdreDAO oDao = factory.getOrdreDAO();
            oDao.miseAJourEtat(1, "Modifie!!");
            factory.goToStartDocument();
            Mission newMission = factory.getMissionDAO().extractMission(true, false);

            System.out.println("Valeur theorique du nouvel etat de l'ordre id=1 de la mission : Modifie!!");
            System.out.println("Detailss de la mission :");
            System.out.println(newMission);
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
