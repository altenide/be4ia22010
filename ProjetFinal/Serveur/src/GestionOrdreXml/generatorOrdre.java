/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author forgefeu81
 */
public class generatorOrdre {

    public void genererOrdreFromUser(String user) {
        //BDDConnexion.getInstance().Connect("jdbc:derby://localhost:1527/", "pouet", "pouet", "pouet");
        DAOMission acces_mission;
        try {
            DAOUtilisateur acces_utilisateur = (DAOUtilisateur) DAOFactory.getDAOUtilisateur();
            acces_mission = (DAOMission) DAOFactory.getDAOMission();

            Mission mi = acces_mission.findListFromUser(user).firstElement();
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
            
            for (Ordre or : ord) {
                Synthese s = new Synthese(or);
                ordre = O.AddOrdre(mission, factory, or.getContenu(), EtatType.NON_ATTEINT, false, or.getFilename(), or.getIdOrdre());
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
            Resource resource = (Resource) resSet.createResource(URI.createURI("m.ordre"));
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


