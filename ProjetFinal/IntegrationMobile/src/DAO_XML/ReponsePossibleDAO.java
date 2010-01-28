package DAO_XML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Classe de manipulation des reponses possibles dans le fichier XML
 * @author Edith Guilbaud
 */
public class ReponsePossibleDAO {

    /**
     * parser utilise
     */
    private XmlPullParser parser;
    /**
     * chemin et nom du fichier XML manipule
     */
    private String path = "", fichier = "";

    /**
     * Constructeur (utilise uniquement par XMLDAOFactory et OrdreDAO)
     * @param parser
     * @param path
     * @param fichier
     */
    protected ReponsePossibleDAO(XmlPullParser parser, String path, String fichier) {
        this.parser = parser;
        this.path = path;
        this.fichier = fichier;
    }

    /**
     * Extrait la premiere reponse possible d'un ordre
     * @return la reponse extraite
     * @throws XmlPullParserException
     * @throws IOException
     */
    public ReponsePossible extractReponse() throws XmlPullParserException, IOException {

        ReponsePossible reponse;
        String name = "";
        int id, idOrdreSuivant;
        String contenu;


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

        return reponse;

    }

    /**
     * Place le parseur au début du fichier XML
     * necessaire avant tout appel exterieur a une methode extract
     */
    public void goToStartDocument() {
        try {
            parser.setInput(new FileReader(path + fichier));
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
