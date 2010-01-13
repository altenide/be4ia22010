/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_XML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;


/**
 *
 * @author Edith
 */
public class XMLDAOFactory {

    private XmlPullParser parser;
    private MissionDAO missionDAO;
    private OrdreDAO ordreDAO;
    private ReponsePossibleDAO reponsePossibleDAO;
    private String path= "";//"My Documents/GrpA2/";

    public XMLDAOFactory() {

        //créé un parseur et l'affecte à l'attribut
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
            factory.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();

            parser.setInput(new FileReader(path+"XMLDatabase.xml"));
            //U:/NetBeansProjects/BE_POO/src/fichier/XMLDatabase.xml
            //"C:/Documents and Settings/Edith/Mes documents/NetBeansProjects/BE_BDD_Client/src/fichier/XMLDatabase.xml"

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        }

        //Créé les différentes classes DAO : 
        missionDAO = new MissionDAO(parser, path);
        ordreDAO = new OrdreDAO(parser, path);
        reponsePossibleDAO = new ReponsePossibleDAO(parser, path);

    }

    public XmlPullParser getParser() {
        return parser;
    }

    public MissionDAO getMissionDAO() {
    return missionDAO;
    }

    public OrdreDAO getOrdreDAO() {
    return ordreDAO;
    }
    public ReponsePossibleDAO getReponsePossibleDAO() {
        return reponsePossibleDAO;
    }

    //Place le parseur au début du doc XML - necessaire avant tout appel exterieur a une methode extract
    public void goToStartDocument() {
        try {
            parser.setInput(new FileReader(path+"XMLDatabase.xml"));
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
