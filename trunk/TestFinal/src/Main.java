import audio.LectureAudio;
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
		String host = "Dell-Ubuntu";
		String pathDossier = "/home/neo/BE_POO/JAVA/SVN2/trunk/TestFinal/";
		
		ctrl.Controleur ctrl = new Controleur();
		IHM ihm = new IHM();
		FichierXML fichier = new FichierXML(pathDossier);
		TCPClient tcpC = new TCPClient(port, host, ctrl);
		Workflow worflow = new Workflow();		
		//LectureAudio player = new LectureAudio();
		
		ctrl.setIHM(ihm);
		ctrl.setTCPClient(tcpC);
		ctrl.setXml(fichier);
		ctrl.setWorflow(worflow);
		//ctrl.setPlayer(player);
		ihm.setControleur(ctrl);
		
		//ctrl.lireAudio(pathDossier+"Bonjour.wav");
		
		ihm.setVisible(true);
		tcpC.connect();
		tcpC.start();
	}

}
