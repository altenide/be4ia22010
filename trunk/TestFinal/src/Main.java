import GestionMobile.FichierXML;
import GestionMobile.Workflow;
import network.TCPClient;
import ctrl.Controleur;
import gui.IHM;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int port = 4242;
		String host = "forgefeu81-PC";
		
		ctrl.Controleur ctrl = new Controleur();
		IHM ihm = new IHM();
		FichierXML fichier = new FichierXML();
		TCPClient tcpC = new TCPClient(port, host, ctrl);
		Workflow worflow = new Workflow();		
		ctrl.setIHM(ihm);
		ctrl.setTCPClient(tcpC);
		ctrl.setXml(fichier);
		ctrl.setWorflow(worflow);
		ihm.setControleur(ctrl);
		
		ihm.setVisible(true);
		//tcpC.connect();
		//tcpC.start();
	}

}