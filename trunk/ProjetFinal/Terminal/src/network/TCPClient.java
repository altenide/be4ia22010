package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import ctrl.Controleur;

/**
 * Classe de gestion des connexions reseau avec le serveur
 * @author Aurelien Mariage
 */
public class TCPClient extends Thread {

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

    /**
     * Connecte le terminal au serveur (tcp)
     */
    public void connect() {
        try {
            soc = new Socket(host, port);
            os = new BufferedOutputStream(soc.getOutputStream());
            is = new BufferedInputStream(soc.getInputStream());
        } catch (IOException ex) {
            ctrl.showInfo("Probleme de connexion");
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

            //System.out.println("Reception: sReaded = '" + new String(sReaded).trim() + "' msg = '" + msg + "'");

            String[] infos = msg.split(";:!");

            if (infos[0].equals("repLogin")) {
                Boolean repLog = Boolean.valueOf(infos[1]);
                //System.out.println("Reponse identification: "+repLog);
                if (repLog == Boolean.valueOf(true)) {
                    ctrl.loginOK();
                    demanderMission(infos[2].trim());
                }
            }


            if (ctrl != null) {
                ctrl.refreshMsg(msg);
            }
        }
    }

    /**
     * Envoie une demande de mission au serveur
     * @param login login de l'utilisateur demandant une mission
     */
    public void demanderMission(String login) {
        //System.out.println("demanderMission : "+login);
        String msg = "demandeMission;:!" + login;
        send(msg);
    }

    /**
     * Envoie un message au serveur
     * @param msg message a envoyer au serveur
     */
    public void send(String msg) {
        try {
            os.write(msg.getBytes());
            os.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Recoit un message (tcp)
     * @return le message recupere
     */
    public String receive() {
        String msg;

        try {
            is.read(sReaded);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        msg = new String(sReaded).trim();
        //System.out.println("Reception: sReaded = '" + new String(sReaded).trim() + "' msg = '" + msg + "'");

        return msg;
    }

    /**
     * Met en place le lien avec le controleur du terminal
     * @param ctrl
     */
    public void setControleur(Controleur ctrl) {
        this.ctrl = ctrl;
    }
}
