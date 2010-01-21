package ctrl;

import java.util.Vector;

import audio.LectureAudio;

import GestionMobile.FichierXML;
import GestionMobile.Workflow;
import gui.IHM;
import network.TCPClient;

public class Controleur {

	private IHM ihm;
	private TCPClient tcpC; 
	private FichierXML xml;
	private Workflow worflow;
	private LectureAudio player;
	
	
	public Controleur(){
		
	}
	//////////////////////////Partie pour la base de donn�e client//////////////
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
		ordre=xml.intituleOrdre(id);
		return ordre;
	}
	
	public Vector ReponsePossible (int id){
		Vector reponse;
		reponse=xml.choixPossible(id);
		return reponse;
	}
	
	public int OrdreSuivant ( int idCourant, String reponse){
		int ordresuivant;
		ordresuivant=worflow.validationOrdre(idCourant, reponse);
		return ordresuivant;
		
	}
	
	public String GetFichierAudio ( int id){
		return xml.getFichierAudio(id)+".wav";
	}
	

        public int GetIdOrdreCourant (){
            return xml.getIdOrdreCourant();
        }
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////lecteur fichier audio//////////////////
        public void lireAudio ( String fichier){
        	player.lire(fichier);
        	
        }
        
        
	public void setPlayer(LectureAudio player) {
			this.player = player;
		}
	//////////////////////////////////////////////////////////////////////
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
	
	public void loginOK(){
		ihm.disableLogin();
	}
	
	public void setWorflow(Workflow worflow) {
		this.worflow = worflow;
	}
	
	public void setFichier(String fichier){
		worflow.setFichier(fichier);
		xml.setFichier(fichier);
	}
	
	public void afficherOrdre(){
		ihm.affichageOrdre();
	}
	
}
