package DAO_XML;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.kxml2.kdom.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/**
 * Classe de manipulation des ordres dans le fichier XML
 * @author Edith Guilbaud
 */
public class OrdreDAO {

    private XmlPullParser parser;
     private String path = "", fichier="";

    protected OrdreDAO(XmlPullParser parser, String path, String file) {
        this.parser = parser;
        this.path = path;
        fichier = file;
    }

    /**
     * Extrait le premier ordre trouve par le parseur
     * @param reponses true si on veut egalement extraire les reponses correspondantes
     * @return l'ordre
     */
    public Ordre extractOrdre(boolean reponses) throws XmlPullParserException, IOException {

        Ordre ordre;
        String name = " ", contenuOrdre, etat, fichierAudio = null;
        int idOrdre, eventType;
        boolean ordreFinal;

        eventType = parser.getEventType();



        if (eventType == parser.START_TAG) {
            name = parser.getName();
        }

        //On cherche la 1ere balise Ordre
        while (!name.equals("ordre")) {
            eventType = parser.next();
            //si balise d'ouverture, on récupère son nom
            if (eventType == parser.START_TAG) {
                name = parser.getName();
            }
        }

        //On extrait :
        contenuOrdre = parser.getAttributeValue(0);//le contenu de l'ordre
        etat = parser.getAttributeValue(1);//son etat
        ordreFinal = Boolean.getBoolean(parser.getAttributeValue(2));//son bool indicateur de fin
        //l'éventuel fichier audio de l'ordre et l'id
        if (parser.getAttributeCount() == 5) {
            fichierAudio = parser.getAttributeValue(3);
            idOrdre = Integer.parseInt(parser.getAttributeValue(4));
        } else {
            idOrdre = Integer.parseInt(parser.getAttributeValue(3));
        }

        //creation d'un ordre avec ces propriétés
        ordre = new Ordre(idOrdre, contenuOrdre, etat, ordreFinal);
        ordre.addFichierAudio(fichierAudio);

        //Si demande, on extrait les reponses
        if (reponses == true) {

            //on regarde si il y a des réponses au moins !
            if (!parser.isEmptyElementTag()) {
                eventType = parser.next();
                eventType = parser.next();

                
                if (parser.getEventType() == parser.START_TAG && parser.getName().equals("reponsePossible")) {
                    name = parser.getName();
                    ordre.initReponses();
                }

                //si c'est le cas on les récupère tant qu'il y en a
                while (name.equals("reponsePossible")) {

                    ReponsePossibleDAO reponseDAO = new ReponsePossibleDAO(parser, path, fichier);
                    ordre.addReponse(reponseDAO.extractReponse());
                    eventType = parser.next();
                    eventType = parser.next();
                    name = parser.getName();

                }



                //on se place sur la balise de fin de l'ordre
                eventType = parser.getEventType();

                if (eventType == parser.END_TAG) {
                    name = parser.getName();
                }
                while (eventType != parser.END_TAG || !name.equals("ordre")) {    //On cherche la 1ere balise de fin d'ordre
                    eventType = parser.next();

                    //si balise de fermeture, on récupère son nom
                    if (eventType == parser.END_TAG) {
                        name = parser.getName();
                    }
                }
            }
            else {
                
            }
        } //Si on ne voulait pas les reponses
        else {
            //on se place sur la balise de fin de l'ordre
            eventType = parser.getEventType();
            name = " ";

            //si la balise est une balise de fin, on recupere son nom
            if (eventType == parser.END_TAG) {
                name = parser.getName();
            };
            while (eventType != parser.END_TAG || !name.equals("ordre")) {    //On cherche la 1ere balise de fin d'ordre
                eventType = parser.next();

                //si balise de fermeture, on récupère son nom
                if (eventType == parser.END_TAG) {
                    name = parser.getName();
                }
            }

        }

        return ordre;
    }

    /**
     * Place le parseur au début du doc XML 
     * necessaire avant tout appel exterieur a une methode extract
     */
    public void goToStartDocument() {
        try {
            parser.setInput(new FileReader(path+fichier));
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void miseAJourEtat(int idOrdre, String etat) {
        try {
            String name = " ";
            boolean found = false;

            //////////////////////////////////////////
            //on se place sur la 1ère balise <ordre>//
            //////////////////////////////////////////
            this.goToStartDocument();
            int eventType = parser.getEventType();
            if (eventType == parser.START_TAG) {
                name = parser.getName();
            }
            //On cherche la 1ere balise Ordre
            while (!name.equals("ordre")) {
                eventType = parser.next();
                //si balise d'ouverture, on récupère son nom
                if (eventType == parser.START_TAG) {
                    name = parser.getName();
                }
            }//Ici on est donc sur la balise d'ouverture du 1er ordre

            ////////////////////////////
            //on cherche l'ordre voulu//
            ////////////////////////////
            int count = -1;
            //Tant qu'on n'a pas trouve l'ordre voulu
            while (found == false) {
                //on repere l'index de l'ordre
                count = count + 2;

                //on teste son id
                int valId = Integer.parseInt(parser.getAttributeValue(4));
                if (valId == idOrdre) {
                    found = true; //si c'est le bon, on s'arrête

                } else {//sinon on va voir le prochain !
                    name = " ";
                    eventType = parser.getEventType();
                    //si on est sur une balise d'ouverture, on recupere son nom
                    /*if (eventType == parser.START_TAG) {
                    name = parser.getName();
                    }*/
                    //sinon on avance encore
                    //else{
                    eventType = parser.next();
                    //}
                    //et on cherche la prochaine balise d'ouverture d'ordre
                    while (eventType != parser.END_DOCUMENT && !name.equals("ordre")) {
                        eventType = parser.next();

                        //si balise d'ouverture, on récupère son nom
                        if (eventType == parser.START_TAG) {
                            name = parser.getName();
                        }
                    }
                    //si on est a la fin du document, on arrete
                    if (eventType == parser.END_DOCUMENT) {
                        break;
                    }

                }//System.out.println("On est arrive la");
            }

            ///////////////////////////////
            //si l'ordre est bien present//
            ///////////////////////////////
            if (found == true) {

                /////////////////////////////////////////////////
                //on en fait un element, et on modifie son etat//
                /////////////////////////////////////////////////
                Node node = new Node();
                node.parse(parser);
                Element ordre = new Element();
                ordre = (Element) node.getElement(0);
                ordre.setAttribute("", "etat", etat);

                ////////////////////////////////////
                //on recupere ensuite la mission ://
                ////////////////////////////////////
                this.goToStartDocument();
                node = new Node();

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
                node.parse(parser);
                Element mission = new Element();
                mission = node.getElement(0);

                ////////////////////////////////////////////////////////
                //on remplace l'ancien ordre par le nouveau mis a jour//
                ////////////////////////////////////////////////////////
                int type = mission.getType(count);
                mission.removeChild(count);
                mission.addChild(count,type,ordre);


                /////////////////////////////////
                //On reecrit le nouveau fichier//
                /////////////////////////////////
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
                factory.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
                factory.setNamespaceAware(true);
                XmlSerializer serializer = factory.newSerializer();
                FileOutputStream file = new FileOutputStream(path+fichier);
                serializer.setOutput(new PrintWriter(file));


                //<?xml version="1.0" encoding="ASCII"?>
                //<ordre:DocumentRoot xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:ordre="http://www.example.org/Ordre">

                serializer.startDocument("ASCII", null);
                serializer.text("\n");
                serializer.startTag(null, "ordre:DocumentRoot");
                serializer.attribute(null, "xmi:version", "2.0");
                serializer.attribute(null, "xmlns:xmi", "http://www.omg.org/XMI");
                serializer.attribute(null, "xmlns:ordre", "http://www.example.org/Ordre");
                serializer.text("\n");

                mission.write(serializer);
                serializer.text("\n");

                serializer.endTag(null, "ordre:DocumentRoot");

                serializer.endDocument();

            }


        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
