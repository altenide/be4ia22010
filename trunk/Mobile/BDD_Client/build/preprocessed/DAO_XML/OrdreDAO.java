package DAO_XML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Classe de manipulation des ordres dans le fichier XML
 * @author Edith Guilbaud
 */
public class OrdreDAO {

    XmlPullParser parser;

    public OrdreDAO(XmlPullParser parser) {
        this.parser = parser;
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
System.out.println("//////EXTRACT ORDRE////////");

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
System.out.println("Debut Recherche d'ordre");
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
System.out.println("Nouvel ordre cree");

        //Si demande, on extrait les reponses
        if (reponses == true) {
System.out.println("Petit passage par là");
            //on regarde si il y a des réponses au moins !
            if (!parser.isEmptyElementTag()) {
System.out.println("PAS LA NORMALEMENT");
                eventType = parser.next();
                eventType = parser.next();

                //SECTION DE TESTS PR DEBUG ////////////////////
                if (eventType == parser.END_TAG) {
                    System.out.println("reponse :end tag");
                }
                if (eventType == parser.START_TAG) {
                    System.out.println("reponse :start tag");
                }
                if (eventType == parser.TEXT) {
                    System.out.println("reponse :text");
                    System.out.println("debut txt/" + parser.getText() + "/end txt");
                }

                ///////////////////////////////////////////////


                if (parser.getEventType() == parser.START_TAG && parser.getName().equals("reponsePossible")) {
                    name = parser.getName();
                    System.out.println("NOM RECUPERE");
                    ordre.initReponses();
                }

                //si c'est le cas on les récupère tant qu'il y en a
                while (name.equals("reponsePossible")) {

                    System.out.println("UNE REPONSE AJOUTEE");
                    ReponsePossibleDAO reponseDAO = new ReponsePossibleDAO(parser);
                    ordre.addReponse(reponseDAO.extractReponse());
                    eventType = parser.next();
                    eventType = parser.next();
                    name = parser.getName();

                }



                //on se place sur la balise de fin de l'ordre
                eventType = parser.getEventType();

                if (eventType == parser.END_TAG) {
                    System.out.println("Reponse:nom change");
                    name = parser.getName();
                }
                System.out.println("nom de la balise apres recup reponse :" + name);
                while (eventType != parser.END_TAG || !name.equals("ordre")) {    //On cherche la 1ere balise de fin d'ordre
                    System.out.println("dans le while");
                    eventType = parser.next();

                    //si balise de fermeture, on récupère son nom
                    if (eventType == parser.END_TAG) {
                        name = parser.getName();
                        System.out.println("nom de la balise de fin :" + name);
                    }
                }
            }
            else{
                System.out.println("Y AVAIT PAS DE REPONSES!");
                //SECTION DE TEST /////////////////
                System.out.println("nom prochain tag:" + name);
                if (eventType == parser.END_TAG) {
                    System.out.println("ordre seul, balise fin :end tag");
                }
                if (eventType == parser.START_TAG) {
                    System.out.println("ordre seul, balise fin :start tag2");
                }
                if (eventType == parser.TEXT) {
                    System.out.println("ordre seul, balise fin :text2");
                }
                String val = parser.getAttributeValue(0);
                System.out.println("ordre seul, balise fin : attribut:" + val);
                ////////////////////////////////
            }
        }



System.out.println("//////FIN EXTRACT ORDRE////////");
        return ordre;
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
     * Cherche et extrait un ordre particulier
     * @param id identifiant de l'ordre à récupérer
     * @param reponses true si on veut egalement extraire les reponses correspondantes
     * @return l'ordre voulu si trouvé, null si non
     */
    public Ordre findOrdre(int id, boolean reponses) {

        Ordre ordre = null;
        boolean found = false;


        try {
            this.goToStartDocument();
            ordre = this.extractOrdre(reponses);
            parser.next();
            parser.next();

            int eventType = parser.getEventType();

            //tant qu'on a pas trouvé l'ordre voulu et qu'il y en a encore...
            while (ordre.getIdOrdre() != id && found == true) {

                //si on est sur un tag de début d'ordre
                if (eventType == parser.START_TAG && parser.getName().equals("ordre")) {
                    ordre = this.extractOrdre(reponses); //on extrait l'ordre
                    found = true; //on en a trouve un
                } else {
                    found = false;// si on a pas trouve d'ordre, on est au bout du fichier
                }

            }

            //si on n'a pas trouve l'ordre
            if (found == false) {
                ordre = null; // on renvoie null
            }

        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        
        return ordre;
    }
    /* public boolean create(Ordre obj) {
    }

    public boolean update(Ordre obj) {
    }

    public boolean delete(Ordre obj) {
    }*/
}
