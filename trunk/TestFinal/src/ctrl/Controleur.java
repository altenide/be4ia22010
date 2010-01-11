package ctrl;

import gui.IHM;
import network.TCPClient;

public class Controleur {

	private IHM ihm;
	private TCPClient tcpC; 
	
	public Controleur(){
		
	}
	
	public void setIHM(IHM ihm){
		this.ihm = ihm;
	}
	
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
