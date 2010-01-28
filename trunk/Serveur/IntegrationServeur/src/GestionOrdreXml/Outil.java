package GestionOrdreXml;

import Ordre.ordre.*;

public class Outil {
	
	//contenu="Aller gauche" etat="NonAtteint" ordrefinal="false" fichierAudio="./blabla2 idOrdre="1">
	public OrdreType AddOrdre(MissionType mission,OrdreFactory factory,String contenu,EtatType etat,boolean Ordrefinal,String fichierAudio,int idOrdre)
	{
		OrdreType ordre = factory.createOrdreType();
		ordre.setEtat(etat);
		ordre.setContenu(contenu);
		ordre.setFichierAudio(fichierAudio);
		ordre.setOrdrefinal(Ordrefinal);
		ordre.setIdOrdre(idOrdre);
		mission.getOrdre().add(ordre);
		return ordre;
	}

	//<reponsePossible reponse="Plus" ordreSuivant="3" idReponse="3" /> 
	public ReponsePossibleType AddReponseTo (OrdreFactory factory,OrdreType ordre,String reponseName,int ordreSuivant,int idReponse ){
		ReponsePossibleType reponse = factory.createReponsePossibleType();
		reponse.setIdReponse(idReponse);
		reponse.setOrdreSuivant(ordreSuivant);
		reponse.setReponse(reponseName);
		ordre.getReponsePossible().add(reponse);
		return reponse;

	}

}
