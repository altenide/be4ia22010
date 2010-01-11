package testOrdre;

import Ordre.ordre.Outil;
import Ordre.ordre.*;
import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;

public class Main {
	public static final int ORDRE_DE_FIN = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialize the model
		OrdrePackage.eINSTANCE.eClass();
		// Retrieve the default factory singleton
		OrdreFactory factory = OrdreFactory.eINSTANCE;

		Outil O = new Outil();
		
		DocumentRoot document = factory.createDocumentRoot();
		MissionType mission = factory.createMissionType();
		document.setMission(mission);
		Date d = new Date(2010, 01, 07);
		XMLCalendar calendar = new XMLCalendar(d, (short)1);
		mission.setDate(calendar);
		mission.setDestinataire("Edith Guilbaud");
		mission.setEtat(EtatType1.DISPONIBLE);
		mission.setIdMission(21378);
		mission.setIdOrdreCoutant(-1);
		mission.setPublie(true);
		OrdreType ordre;
		int idOrdre =0;
		int idReponse =0;
		/////////////////////////////////////////////////////////////////////////////////
		ordre =O.AddOrdre(mission, factory, "'Aller tout doit", EtatType.NON_ATTEINT, false, "./audioOrdreid0", idOrdre);
		idOrdre++;
		O.AddReponseTo(factory, ordre,"Oui", 1, idReponse++);
		O.AddReponseTo(factory, ordre,"Non", 1, idReponse++);
		O.AddReponseTo(factory, ordre,"Y a un mur", 1, idReponse++);
		O.AddReponseTo(factory, ordre,"Fin", ORDRE_DE_FIN, idReponse++);
		idReponse=0;
		/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
		ordre =O.AddOrdre(mission, factory, "'Aller tout gauche", EtatType.NON_ATTEINT, false, "./audioOrdreid"+Integer.toString(idOrdre), idOrdre);
		idOrdre++;
		O.AddReponseTo(factory, ordre,"Oui", 2, idReponse++);
		O.AddReponseTo(factory, ordre,"Non", 2, idReponse++);
		O.AddReponseTo(factory, ordre,"Y a un mur", ORDRE_DE_FIN, idReponse++);
		O.AddReponseTo(factory, ordre,"Fin", ORDRE_DE_FIN, idReponse++);
		idReponse=0;
		/////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////
		ordre =O.AddOrdre(mission, factory, "FinMission", EtatType.NON_ATTEINT, false, "./audioFinOrdre"+Integer.toString(ORDRE_DE_FIN), ORDRE_DE_FIN);
		/////////////////////////////////////////////////////////////////////////////////

		// As of here we preparing to save the model content

		// Register the XMI resource factory for the .website extension

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("ordre", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Create a resource
		Resource resource = resSet.createResource(URI
				.createURI("m.ordre"));
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

	}

	


}



