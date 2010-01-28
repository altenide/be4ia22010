/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serveurtcp;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Classe permettant de lancer un serveur TCP
 * @author Aurelien
 */
public class TCPServeur extends Thread{
private ServerSocket ss;

    public TCPServeur(int port){
        try {
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

     /**
     * Methode definissant le comportement du thread.
     * Attente sur la socket ouverrte puis redirection du service vers un thread TCPThread
     */
    public void run(){
         try{
             System.out.println("Serveur TCP en attente sur le port 4242");
            while (true){
                TCPThread tmp = new TCPThread(ss.accept());
                System.out.println("Un client est connecte");
                tmp.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
