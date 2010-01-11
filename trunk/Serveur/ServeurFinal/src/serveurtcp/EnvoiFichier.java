/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serveurtcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Administrateur
 */
public class EnvoiFichier {

    private Socket soc;

    public EnvoiFichier(String host, int port){
        try{
            soc = new Socket(host, port);
            System.out.println("Connecte au serveur\nAttente d'envoi de fichier");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendFile(String fichier){
        try{
            System.out.println("Debut du transfert du fichier "+fichier);
            File f = new File(fichier);
            
            BufferedInputStream inFichier = new BufferedInputStream(new FileInputStream(fichier));
            
            OutputStream outFichier = new BufferedOutputStream(soc.getOutputStream());

            String info = f.getName()+";:!"+inFichier.available()+";:!";

            outFichier.write(info.getBytes(), 0, info.getBytes().length);
            outFichier.flush();

            byte[] octets = new byte[1024];
            int num, nbOctLu;
            nbOctLu = 0;
            while ((num = inFichier.read(octets, 0, 1024)) != -1) {
                outFichier.write(octets, 0, num);
                outFichier.flush();
                nbOctLu+=num;
            }

            System.out.println("Transfert de "+fichier+" termine, nbOctLu : "+nbOctLu);
            inFichier.close();
            outFichier.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args){
        EnvoiFichier c = new EnvoiFichier("localhost", 4242);
    }
}
