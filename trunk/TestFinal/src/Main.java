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
		String host = "Dell";
		
		ctrl.Controleur ctrl = new Controleur();
		IHM ihm = new IHM();
		TCPClient tcpC = new TCPClient(port, host, ctrl);
				
		ctrl.setIHM(ihm);
		ctrl.setTCPClient(tcpC);
		
		ihm.setControleur(ctrl);
		
		ihm.setVisible(true);
		tcpC.connect();
		tcpC.start();
	}

}
