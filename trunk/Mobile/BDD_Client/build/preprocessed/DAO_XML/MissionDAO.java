/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_XML;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author Edith
 */
public class MissionDAO {

    XmlPullParser parser;

    public MissionDAO(XmlPullParser parser) {
        this.parser = parser;
    }

    public Mission extractMission(boolean ordres, boolean reponses) throws XmlPullParserException, FileNotFoundException, IOException {

        Mission mission;
        int id, ordreCourant;
        String etat, destinataire, date;
        boolean publie, found;

        String name = " ";
        int eventType;


        //on cherche la première balise <Mission>
        eventType = parser.getEventType();

        if (eventType == parser.START_TAG) {
            name = parser.getName();
        }

        while (!name.equals("mission") && parser.getEventType() != parser.END_DOCUMENT) {
            eventType = parser.next();
            //si balise d'ouverture, on récupère son nom
            if (eventType == parser.START_TAG) {
                name = parser.getName();
            }
        }

        //On récupère les éléments de la mission
        etat = parser.getAttributeValue(0); //etat de la mission
        ordreCourant = Integer.parseInt(parser.getAttributeValue(1)); //id de l'ordre courant
        destinataire = parser.getAttributeValue(2); //destinataire de la mission
        publie = Boolean.getBoolean(parser.getAttributeValue(3)); //status de publication
        date = parser.getAttributeValue(4); //date d'entree de la mission
        id = Integer.parseInt(parser.getAttributeValue(5)); //l'identifiant de la mission

        //On genere une mission avec ces donnees
        mission = new Mission(id, etat, ordreCourant, destinataire, publie, date);

        parser.next();
        parser.next();

        //si on veut également à l'interieur les ordres associes
        if (ordres == true) {

            name = parser.getName();
            System.out.println("nomBaliseDEntree1erordre :" + name); //TEST DEBUG

            mission.initOrdres();
            int cpt = 0;
            //tant qu'il y a des ordres a recuperer
            while (name.equals("ordre")) {
                cpt++;
                System.out.println(cpt);
                //on instantie de quoi recuperer l'ordre
                OrdreDAO ordreDao = new OrdreDAO(parser);
                //on extrait l'ordre, avec ou sans réponses
                mission.addOrdre(ordreDao.extractOrdre(reponses));//on ressort sur la balise de fin d'ordre
System.out.println("=> ORDRE AJOUTE");

                eventType = parser.getEventType();
                if (eventType == parser.END_TAG){
                    //on passe au tag suivant
                    eventType = parser.next();
                    eventType = parser.next();
                }
                //mais si l'ordre etait vide (pas de reponses), un de + !
                else {
                    eventType = parser.next();
                    eventType = parser.next();
                    eventType = parser.next();
                }

                


                if (cpt ==3){
//SECTION DE TEST /////////////////
                System.out.println("nom prochain tag:" + name);
                if (eventType == parser.END_TAG) {
                    System.out.println("end tag7");
                }
                if (eventType == parser.START_TAG) {
                    System.out.println("start tag7");
                }
                if (eventType == parser.TEXT) {
                    System.out.println("text7");
                }
                //String val = parser.getAttributeValue(0);
                //System.out.println("attribut prochain tag :" + val);
                ////////////////////////////////
                }

                if (eventType==parser.END_TAG && parser.getName().equals("mission")) {
                    System.out.println("ON DEGAGE !!");break;
                }

                //on recupere le nom du prochain tag de debut
                found = false;
                while (found == false) {
                    if (eventType == parser.START_TAG) {

                        name = parser.getName();
                        found = true;
                    } else {
                        eventType = parser.next();
                    }
                }

                //SECTION DE TEST /////////////////
                System.out.println("nom prochain tag:" + name);
                if (eventType == parser.END_TAG) {
                    System.out.println("end tag2");
                }
                if (eventType == parser.START_TAG) {
                    System.out.println("start tag2");
                }
                if (eventType == parser.TEXT) {
                    System.out.println("text2");
                }
                //String val = parser.getAttributeValue(0);
                //System.out.println("attribut prochain tag :" + val);
                ////////////////////////////////
            }
        }


        return mission;
    }

    /*public boolean create(Mission obj) {
    }

    public boolean update(Mission obj) {
    }

    public boolean delete(Mission obj) {
    }*/
}
