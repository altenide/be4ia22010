/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_XML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author Edith
 */
public class ReponsePossibleDAO {

    private XmlPullParser parser;

    protected ReponsePossibleDAO(XmlPullParser parser) {
        this.parser = parser;
    }


    
    public ReponsePossible extractReponse() throws XmlPullParserException, IOException {

        ReponsePossible reponse;
        String name = "";
        int id, idOrdreSuivant;
        String contenu;


System.out.println("//////EXTRACT REPONSE////////");
        int eventType = parser.getEventType();
        //si balise d'ouverture, on récupère son nom
        if (eventType == parser.START_TAG) {
            name = parser.getName();
        }

        //On cherche la 1ere balise reponsePossible
        while (!name.equals("reponsePossible")) {
            eventType = parser.next();
            //si balise d'ouverture, on récupère son nom
            if (eventType == parser.START_TAG) {
                name = parser.getName();
            }
        }

        //On extrait le contenu de la reponse
        contenu = parser.getAttributeValue(0);
        //on extrait l'id de l'odre suivant
        idOrdreSuivant = Integer.parseInt(parser.getAttributeValue(1));
        //on extrait l'id de la reponse
        id = Integer.parseInt(parser.getAttributeValue(2));
        

        parser.next(); //on se place sur la balise </ReponsePossible>

        //on construit la reponse a partir de ces donnees
        reponse = new ReponsePossible(id, contenu, idOrdreSuivant);
System.out.println("//////FIN EXTRACT REPONSE////////");
        return reponse;

    }



     /**
     * Place le parseur au début du doc XML
     * necessaire avant tout appel exterieur a une methode extract
     */
    public void goToStartDocument() {
        try {
            parser.setInput(new FileReader("XMLDatabase.xml"));
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }




   
}
