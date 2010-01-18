/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import ctrl.Controleur;

import gui.IHM;

/**
 *
 * @author Administrateur
 */
public class TCPClient extends Thread {

    //private IHM main;
    private Controleur ctrl = null; 

    private int port;
    private String host;
    private Socket soc;
    private OutputStream os;
    private InputStream is;
    private byte[] sReaded;

    public TCPClient(int port, String host, Controleur m) {
        this.port = port;
        this.host = host;
        ctrl = m;

        sReaded = new byte[512];
    }

    public TCPClient(int port, String host) {
        this.port = port;
        this.host = host;
        
        sReaded = new byte[512];
    }

    public void connect(){
    	try {
            soc = new Socket(host, port);
            os = new BufferedOutputStream(soc.getOutputStream());
            is = new BufferedInputStream(soc.getInputStream());
        } catch (IOException ex) {
            ctrl.showInfo("Probl�me de connexion");
            ex.printStackTrace();
        }
    }
    
    public void run() {
        String msg;

        while (true) {
            try {
                is.read(sReaded);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            msg = new String(sReaded).trim();
            
            System.out.println("Reception: sReaded = '" + new String(sReaded).trim() + "' msg = '" + msg + "'");
            
            String []infos = msg.split(";:!");
            
            if (infos[0].equals("repLogin")){            	
            	Boolean repLog = new Boolean(infos[1]);
            	System.out.println("Reponse identification: "+repLog);            	
            }
            
            
            if (ctrl != null)
                ctrl.refreshMsg(msg);
        }
        //System.out.println("sortie de la boucle de reception");
    }

    public void send(String msg) {
        try {
            os.write(msg.getBytes());
            os.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String receive() {
        String msg;

        try {
            is.read(sReaded);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        msg = new String(sReaded).trim();
        System.out.println("Reception: sReaded = '" + new String(sReaded).trim() + "' msg = '" + msg + "'");

        return msg;
    }
    
	public void setControleur(Controleur ctrl){
		this.ctrl = ctrl;
	}
}
