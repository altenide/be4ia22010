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

import gui.IHM;

/**
 *
 * @author Administrateur
 */
public class TCPClient extends Thread {

    private IHM main;

    private int port;
    private String host;
    private Socket soc;
    private OutputStream os;
    private InputStream is;
    private byte[] sReaded;

    public TCPClient(int port, String host, IHM m) {
        this.port = port;
        this.host = host;
        main = m;

        sReaded = new byte[512];

        try {
            soc = new Socket(host, port);
            os = new BufferedOutputStream(soc.getOutputStream());
            is = new BufferedInputStream(soc.getInputStream());
        } catch (IOException ex) {
            main.showInfo("Problème de connexion");
            ex.printStackTrace();
        }
    }

    public TCPClient(int port, String host) {
        this.port = port;
        this.host = host;
        main = null;

        sReaded = new byte[512];

        try {
            soc = new Socket(host, port);
            os = new BufferedOutputStream(soc.getOutputStream());
            is = new BufferedInputStream(soc.getInputStream());
        } catch (IOException ex) {
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

            if (main != null)
                main.refreshMsg(msg);
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
}
