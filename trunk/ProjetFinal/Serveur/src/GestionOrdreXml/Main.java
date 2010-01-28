package GestionOrdreXml;

import Ordre.ordre.*;
import Synthese.Synthese;

import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.Map;
import gestionbdd.*;
import java.util.Vector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;

public class Main {

    public static final int ORDRE_DE_FIN = -2;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BDDConnexion.getInstance().Connect("jdbc:derby://localhost:1527/", "pouet", "pouet", "pouet");
        DAOMission acces_mission;
        try {
            DAOUtilisateur acces_utilisateur = (DAOUtilisateur) DAOFactory.getDAOUtilisateur();
            acces_mission = (DAOMission) DAOFactory.getDAOMission();

            acces_utilisateur.create(new Utilisateur("Robert", "azerty", 5));
            Mission m1 = new Mission("Robert");

            /* Création des ordres */
            Ordre o1 = new Ordre(1, 1, "Aller faire les courses", false);
            Ordre o2 = new Ordre(2, 1, "Aller faire le ménage", false);

            o1.addReponse(new Reponse(0, "Courses faites",o1.getIdMission(), 1, 2));
            o1.addReponse(new Reponse(1, "Repeter",o1.getIdMission(), 1, 1));
            o1.addReponse(new Reponse(2, "Impossible",o1.getIdMission(), 1, 0));
            o1.setFilename("o1");

            o2.addReponse(new Reponse(0, "Menage fait",o1.getIdMission(), 2, 2));
            o2.addReponse(new Reponse(1, "Repeter",o1.getIdMission(), 2, 1));
            o2.addReponse(new Reponse(2, "Impossible",o1.getIdMission(), 2, 0));
            o2.setFilename("o2");

            /* Configuration de la mission */
            m1.addOrdre(o1);
            m1.addOrdre(o2);
            m1.setEtat(Mission.etat_mission.EN_COURS);
            m1.setIdMission(1);
            m1.setIdOrdreCourant(1);
            m1.setPublie(true);

            /* Ajout de la mission dans la BDD */
            acces_mission.create(m1);




            // Initialize the model
            Mission mi = acces_mission.findListFromUser("Robert").get(0);
            OrdrePackage.eINSTANCE.eClass();
            // Retrieve the default factory singleton
            OrdreFactory factory = OrdreFactory.eINSTANCE;

            Outil O = new Outil();
            
            DocumentRoot document = factory.createDocumentRoot();
            MissionType mission = factory.createMissionType();
            document.setMission(mission);
            Date d = new Date(2010, 01, 07);
            XMLCalendar calendar = new XMLCalendar(d, (short) 1);
            mission.setDate(calendar);
            mission.setDestinataire(mi.getUtilisateur());
            mission.setEtat(EtatType1.DISPONIBLE);
            mission.setIdMission(mi.getIdMission());
            mission.setIdOrdreCoutant(mi.getIdOrdreCourant());
            mission.setPublie(true);
            OrdreType ordre;
            int idOrdre = 0;
            int idReponse = 0;
            Vector<Ordre> ord = mi.getListOrdres();
            System.out.println("Nombre ordre recu:" + ord.size());
            
            /////////////////////////////////////////////////////////////////////////////////
            Synthese S = new Synthese(mi);
            for (Ordre or : ord) {
                ordre = O.AddOrdre(mission, factory, or.getContenu(), EtatType.NON_ATTEINT, false, or.getFilename(), or.getIdMission());
                for (Reponse r : or.getReponsesPossibles()) {
                    O.AddReponseTo(factory, ordre, r.getReponse(), r.getOrdreSuivant(), r.getIdReponse());
                }
            }
            // As of here we preparing to save the model content

            // Register the XMI resource factory for the .website extension

            Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
            Map<String, Object> m = reg.getExtensionToFactoryMap();
            m.put("ordre", new XMIResourceFactoryImpl());

            // Obtain a new resource set
            ResourceSet resSet = new ResourceSetImpl();

            // Create a resource
            Resource resource = resSet.createResource(URI.createURI("m.ordre"));
            // Get the first model element and cast it to the right type, in my
            // example everything is hierarchical included in this first node
            resource.getContents().add(document);

            // Now save the content.
            try {
                resource.save(Collections.EMPTY_MAP);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }// TODO Auto-generated method stub

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }
}




