package DAO_XML;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.kxml2.kdom.*;
import org.xmlpull.v1.*;

/**
 * Classe de manipulation de la mission dans le fichier XML
 * @author Edith Guilbaud
 */
public class MissionDAO {

    /**
     * parser utilise
     */
    private XmlPullParser parser;
    /**
     * chemin et nom du fichier XML manipule
     */
    private String path = "", fichier = "";

    /**
     * Constructeur (utilise uniquement par XMLDAOFactory)
     * @param parser
     * @param path
     * @param fichier
     */
    protected MissionDAO(XmlPullParser parser, String path, String fichier) {
        this.parser = parser;
        this.path = path;
        this.fichier = fichier;
    }

    /**
     * Extrait la mission presente dans le fichier XML
     * @param ordres indique si on veut extraire les ordres avec (true si oui, false si non)
     * @param reponses indique si, en plus des ordres, on veut egalement les reponses possibles (true si oui, false si non, ne peut valoir true si ordres=false)
     * @return la mission extraite
     * @throws XmlPullParserException
     * @throws FileNotFoundException
     * @throws IOException
     */
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

            mission.initOrdres();
            int cpt = 0;
            //tant qu'il y a des ordres a recuperer
            while (name.equals("ordre")) {
                //on instantie de quoi recuperer l'ordre
                OrdreDAO ordreDao = new OrdreDAO(parser, path, fichier);
                //on extrait l'ordre, avec ou sans réponses
                mission.addOrdre(ordreDao.extractOrdre(reponses));//on ressort sur la balise de fin d'ordre

                eventType = parser.getEventType();
                if (eventType == parser.END_TAG) {
                    //on passe au tag suivant
                    eventType = parser.next();
                    eventType = parser.next();
                } //mais si l'ordre etait vide (pas de reponses dans le fichier), un de + !
                else {
                    eventType = parser.next();
                    eventType = parser.next();
                    eventType = parser.next();
                }


                if (eventType == parser.END_TAG && parser.getName().equals("mission")) {
                    break;
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
            }
        }


        return mission;
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

    /**
     * Met a jour la valeur de l'ordre courant de la mission dans le fichier XML
     * @param id nouvelle valeur que doit prendre l'identifiant de l'ordre courant dans le fichier
     */
    public void MiseAJourOrdreCourant(int id) {
        String name = "";

        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
            factory.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            factory.setNamespaceAware(true);

            Node node = new Node();

            this.goToStartDocument();

            //on cherche la première balise <Mission>
            int eventType = parser.getEventType();

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


            node.parse(parser);
            Element element = new Element();
            element = (Element) node.getElement(0);
            element.setAttribute("", "idOrdreCoutant", String.valueOf(id));


            //On reecrit le nouveau fichier
            XmlSerializer serializer = factory.newSerializer();
            FileOutputStream file = new FileOutputStream(path + "XMLDatabase.xml");
            serializer.setOutput(new PrintWriter(file));


            // Creation manuelle de l'en-tête :
            //<?xml version="1.0" encoding="ASCII"?>
            //<ordre:DocumentRoot xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:ordre="http://www.example.org/Ordre">
            serializer.startDocument("ASCII", null);
            serializer.text("\n");
            serializer.startTag(null, "ordre:DocumentRoot");
            serializer.attribute(null, "xmi:version", "2.0");
            serializer.attribute(null, "xmlns:xmi", "http://www.omg.org/XMI");
            serializer.attribute(null, "xmlns:ordre", "http://www.example.org/Ordre");
            serializer.text("\n");

            element.write(serializer);
            serializer.text("\n");

            serializer.endTag(null, "ordre:DocumentRoot");

            serializer.endDocument();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Met a jour la valeur de l'etat de la mission dans le fichier XML
     * @param etat nouvelle valeur que doit prendre l'etat de la mission dans le fichier
     */
    public void MiseAJourEtat(String etat) {
        String name = "";

        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
            factory.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            factory.setNamespaceAware(true);

            Node node = new Node();

            this.goToStartDocument();


            //on cherche la première balise <Mission>
            int eventType = parser.getEventType();

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


            node.parse(parser);
            Element element = new Element();
            element = (Element) node.getElement(0);
            element.setAttribute("", "etat", etat);


            //On reecrit le nouveau fichier
            XmlSerializer serializer = factory.newSerializer();
            FileOutputStream file = new FileOutputStream(path + "XMLDatabase.xml");
            serializer.setOutput(new PrintWriter(file));

            // Creation manuelle de l'en-tête :
            //<?xml version="1.0" encoding="ASCII"?>
            //<ordre:DocumentRoot xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:ordre="http://www.example.org/Ordre">

            serializer.startDocument("ASCII", null);
            serializer.text("\n");
            serializer.startTag(null, "ordre:DocumentRoot");
            serializer.attribute(null, "xmi:version", "2.0");
            serializer.attribute(null, "xmlns:xmi", "http://www.omg.org/XMI");
            serializer.attribute(null, "xmlns:ordre", "http://www.example.org/Ordre");
            serializer.text("\n");

            element.write(serializer);
            serializer.text("\n");

            serializer.endTag(null, "ordre:DocumentRoot");

            serializer.endDocument();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        }

    }
}
