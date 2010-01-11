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
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Administrateur
 */
public class TCPThread extends Thread {

    private Socket soc;
    private int num, portFichier;
    private String echo;

    public TCPThread(Socket soc) {
        this.soc = soc;

        portFichier = 4343;
        EnvoiFichier e = new EnvoiFichier(soc.getInetAddress().getHostName(), portFichier);
        e.sendFile("./toto.txt");
        //e.sendFile("./build.xml");
        //e.sendFile("./bjr.wav");
        //e.sendFile("./phrase.wav");
    }

    public void run() {
        try {
            byte[] octets = new byte[1024];

            BufferedInputStream in = new BufferedInputStream(soc.getInputStream());
            OutputStream outFichier = new BufferedOutputStream(soc.getOutputStream());

            while (true) {
                num = in.read(octets, 0, 1024);
                System.out.println("Fin de reception");
                System.out.println("Reçu: " + new String(octets).trim());

                echo = "(echo) - " + new String(octets).trim();

                outFichier.write(echo.getBytes(), 0, echo.getBytes().length);
                outFichier.flush();
                System.out.println("Msg envoyé: " + echo);
            }

        } catch (SocketException se) {
            System.out.println("Connexion resetee par le client: " + se);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String fichier){
        try{
            System.out.println("Debut du transfert");
            File f = new File(fichier);
            BufferedInputStream inFichier = new BufferedInputStream(new FileInputStream(fichier));            
            OutputStream outFichier = new BufferedOutputStream(soc.getOutputStream());
          
            outFichier.write((f.getName()+";:!").getBytes(), 0, f.getName().getBytes().length+3);
            outFichier.flush();

            byte[] octets = new byte[1024];
            int num;
            while ((num = inFichier.read(octets, 0, 1024)) != -1) {
                outFichier.write(octets, 0, num);
                outFichier.flush();
            }

            System.out.println("Transfert termine");
            soc.close();         
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
