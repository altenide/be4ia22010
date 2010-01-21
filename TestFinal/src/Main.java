import audio.LectureAudio;
import GestionMobile.FichierXML;
import GestionMobile.Workflow;
import network.ReceptionFichierServeur;
import network.TCPClient;
import ctrl.Controleur;
import gui.IHM;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int portTCP = 4242, portFichier = 4343;
		String pathAudio = "/Flash Disk/Audio/";//\Flash Disk\Audio
		String host = "Dell-Ubuntu";
		String pathDossier = "/home/neo/BE_POO/JAVA/SVN2/trunk/TestFinal/fichiers_recus/";
		
		ctrl.Controleur ctrl = new Controleur();
		IHM ihm = new IHM(pathAudio);
		FichierXML fichier = new FichierXML(pathDossier);
		TCPClient tcpC = new TCPClient(portTCP, host, ctrl);
		Workflow worflow = new Workflow(pathDossier);		
		LectureAudio player = new LectureAudio();
		ReceptionFichierServeur rfs = new ReceptionFichierServeur(portFichier, ctrl, pathDossier);		
		ctrl.setIHM(ihm);
		ctrl.setTCPClient(tcpC);
		ctrl.setXml(fichier);
		ctrl.setWorflow(worflow);
		ctrl.setPlayer(player);
		ihm.setControleur(ctrl);
		

		
		ihm.setVisible(true);
		
		// demarrage des services réseau
		rfs.start();
		tcpC.connect();
		tcpC.start();		
	}

}
