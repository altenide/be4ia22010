/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serveurtcp;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Administrateur
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
