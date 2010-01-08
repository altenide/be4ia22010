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

    XmlPullParser parser;

    public ReponsePossibleDAO(XmlPullParser parser) {
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
            parser.setInput(new FileReader("C:/Documents and Settings/Edith/Mes documents/NetBeansProjects/BE_BDD_Client/src/fichier/XMLDatabase.xml"));
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }



    /**
     * Cherche et extrait une réponse particuliere par son contenu
     * @param rep contenu de la reponse a trouver
     * @return la reponse voulue si trouvée, null si non
     */
    public ReponsePossible findReponse(String rep){


        ReponsePossible reponse = null;
        boolean found = false;


        try {
            this.goToStartDocument();
            reponse = this.extractReponse();
            parser.next();
            parser.next();

            int eventType = parser.getEventType();

            //tant qu'on a pas trouvé l'ordre voulu et qu'il y en a encore...
            while (!reponse.getReponse().equals(rep)&& found == true) {

                //si on est sur un tag de début d'ordre
                if (eventType == parser.START_TAG && parser.getName().equals("reponsePossible")) {
                    reponse = this.extractReponse(); //on extrait l'ordre
                    found = true; //on en a trouve un
                } else {
                    found = false;// si on a pas trouve d'ordre, on est au bout du fichier
                }

            }

            //si on n'a pas trouve l'ordre
            if (found == false) {
                reponse = null; // on renvoie null
            }

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return reponse;
    }
    


    /*public boolean create(ReponsePossible obj) {
    }

    public boolean update(ReponsePossible obj) {
    }

    public boolean delete(ReponsePossible obj) {
    }*/
}
