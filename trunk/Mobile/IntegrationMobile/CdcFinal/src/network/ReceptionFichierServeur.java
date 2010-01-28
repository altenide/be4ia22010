/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Administrateur
 */
public class ReceptionFichierServeur extends Thread {

    private ServerSocket ss;
    private testreseau.Main main;

    /**
     * Constructeur de la classe ReceptionFichierServeur
     * @param port Port d'ecoute du serveur
     * @param m La fenetre du programme
     */
    public ReceptionFichierServeur(int port, testreseau.Main m) {
        try {
            main = m;
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ReceptionFichierServeur(int port) {
        try {
            main = null;
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Méthode définissant le comportement du Thread.
     */
    public void run() {
        try {
            System.out.println("Serveur de fichier en attente");
            while (true) {
                // lorsqu'un client se connecte, on crée un objet ReceptionFichierClientThread afin de rendre le serveur MultiClient
                ReceptionFichierClientThread tmp = new ReceptionFichierClientThread(ss.accept(), main);
                System.out.println("Un client est connecte au serveur de fichier");
                tmp.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
