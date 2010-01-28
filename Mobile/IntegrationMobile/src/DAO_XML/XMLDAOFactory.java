package DAO_XML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * Factory des classes DAO de manipulation du document XML
 * @author Edith Guilbaud
 */
public class XMLDAOFactory {

    private XmlPullParser parser;
    private MissionDAO missionDAO;
    private OrdreDAO ordreDAO;
    private ReponsePossibleDAO reponsePossibleDAO;
    private String path = "", fichier = "";

    public XMLDAOFactory(String path, String file) {

        //créé un parseur et l'affecte à l'attribut
        try {

            fichier = file;
            this.path = path;

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
            factory.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();

            parser.setInput(new FileReader(path + fichier));
            //U:/NetBeansProjects/BE_POO/src/fichier/XMLDatabase.xml
            //"C:/Documents and Settings/Edith/Mes documents/NetBeansProjects/BE_BDD_Client/src/fichier/XMLDatabase.xml"

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        }

        //Créé les différentes classes DAO : 
        missionDAO = new MissionDAO(parser, path, fichier);
        ordreDAO = new OrdreDAO(parser, path, fichier);
        reponsePossibleDAO = new ReponsePossibleDAO(parser, path, fichier);

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

    public void setPath(String path) {
        this.path = path;
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
