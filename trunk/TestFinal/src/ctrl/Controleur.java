package ctrl;

import java.util.Vector;

import GestionMobile.FichierXML;
import gui.IHM;
import network.TCPClient;

public class Controleur {

	private IHM ihm;
	private TCPClient tcpC; 
	private FichierXML xml;
	
	public Controleur(){
		
	}
	//////////////////////////Partie pour la base de donnée client//////////////
	public FichierXML getXml() {
		return xml;
	}

	public void setXml(FichierXML xml) {
		this.xml = xml;
	}

	public void setIHM(IHM ihm){
		this.ihm = ihm;
	}
	
	public String Ordre (int id){
		String ordre;
		ordre=xml.IntitulerOrdre(id);
		return ordre;
	}
	
	public Vector ReponsePossible (int id){
		Vector reponse;
		reponse=xml.ChoixPossible(id);
		return reponse;
	}
	/////////////////////////////////////////////////////////////////////
	
	public void setTCPClient(TCPClient tcpC){
		this.tcpC = tcpC;
	}
	
	public void showInfo(String msg){
		ihm.showInfo(msg);
	}
	
	public void refreshMsg(String msg){
		ihm.refreshMsg(msg);
	}	
	
	public void envoyerLog(String login, String mdp){
		tcpC.send("login;:!"+login+";:!mdp;:!"+mdp);
	}
	
}
