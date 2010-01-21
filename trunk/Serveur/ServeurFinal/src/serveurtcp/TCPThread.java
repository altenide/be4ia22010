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
        //EnvoiFichier e = new EnvoiFichier(soc.getInetAddress().getHostName(), portFichier);
        //e.sendFile("./toto.txt");
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

                // remise a 0 du buffer
                for(int i = 0; i<octets.length; i++){
                    octets[i]=0;
                }

                num = in.read(octets, 0, 1024);
                
                String msg = new String(octets).trim();
                //System.out.println("Reçu: " +msg);

                String infos[] = msg.split(";:!");

                if (infos[0].equals("login")){
                    String login = infos[1].trim();
                    String mdp = infos[3].trim();

                    //TODO: verification dans la base de données utilisateurs
                    if(login.equals("toto") && mdp.equals("aze")){
                        boolean flag = true;
                        String msgToSend = "repLogin;:!"+flag+";:!"+login;
                        outFichier.write(msgToSend.getBytes(), 0, msgToSend.getBytes().length);
                        outFichier.flush();
                        System.out.println("Msg envoyé en reponse a la demande d'identification: " + msgToSend);
                    }
                    else{
                        boolean flag = false;
                        String msgToSend = "repLogin;:!"+flag;
                        outFichier.write(msgToSend.getBytes(), 0, msgToSend.getBytes().length);
                        outFichier.flush();
                        System.out.println("Msg envoyé en reponse a la demande d'identification: " + msgToSend);
                    }
                }
                
                // traitement pour recupérérer une mission attribuée à une personne
                if (infos[0].equals("demandeMission")){
                    System.out.println("demandeMission pour "+infos[1].trim());

                    //TODO : interroger la bdd de missions

                    //envoi du fichier xml contenant la mission
                    EnvoiFichier e = new EnvoiFichier(soc.getInetAddress().getHostName(), portFichier);
                    e.sendFile("./missionTest.xml");

                    String listeFichiers[] = new String[4];
                    listeFichiers[0] = "audioOrdreId0";
                    listeFichiers[1] = "audioOrdreId0";
                    listeFichiers[2] = "audioOrdreId0";
                    listeFichiers[3] = "audioOrdreId0";

                    envoyerFichiersAudio(listeFichiers);
                }
            }

        } catch (SocketException se) {
            System.out.println("Connexion resetee par le client: " + se);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void envoyerFichiersAudio(String []cheminsFichiers){
        
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
