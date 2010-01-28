/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serveurtcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * Classe permettant de recevoir un fichier
 * @author Aurélien
 */
public class ReceptionFichierClientThread extends Thread{

    private Socket soc;
    private int num;

    public ReceptionFichierClientThread(Socket soc){
        this.soc=soc;
    }

    /**
     * Methode definissant le comportement du thread. Recuperation d'un fichier envoyé par le reseau puis stockage dans le repertoire fichiers_recus.
     */
    public void run(){
        try{
            byte[] octets = new byte[1024];

            new File("./fichiers_recus").mkdirs();

            BufferedInputStream in = new BufferedInputStream(soc.getInputStream());
            String filename="./fichiers_recus/tmp";

            if ((num = in.read(octets, 0, 1024)) != -1){
                String tab[] = new String(octets).split(";:!");
                filename = "./fichiers_recus/"+tab[0];
            }
            
            OutputStream outFichier = new BufferedOutputStream(new FileOutputStream(filename));
            
            while ((num = in.read(octets, 0, 1024)) != -1) {
                //System.out.println("Reçoit: "+new String(octets).trim());
                outFichier.write(octets, 0, num);
                outFichier.flush();
            }
            System.out.println("Fin de reception");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
