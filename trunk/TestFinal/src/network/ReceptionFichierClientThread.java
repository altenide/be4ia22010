package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

/**
 * Classe permettant de recevoir un fichier par le réseau. Cette classe a
 * son propre Thread afin de ne pas bloqué le reste de l'application pendant
 * la réception d'un fichier
 * @author Aurelien Mariage
 */
public class ReceptionFichierClientThread extends Thread {

    private Socket soc;
    private int num, nbOctLu;
    private gui.IHM main;
    private ctrl.Controleur ctrl;
    private String path;

    /**
     * Classe permettant de recevoir un fichier par le réseau. Cette classe a
     * son propre Thread afin de ne pas bloqué le reste de l'application pendant
     * la réception d'un fichier
     * @param soc La socket sur laquelle les inforamtions sont transmises
     * @param m La fenêtre de l'application (permet d'afficher des messages)
     */
    public ReceptionFichierClientThread(Socket soc, gui.IHM m, ctrl.Controleur ctrl, String path) {
        main = m;
        this.ctrl = ctrl;
        this.soc = soc;
        nbOctLu = 0;
        this.path = path;
    }

    /**
     * Méthode définissant le comportement du Thread.
     */
    public void run() {
        try {
            byte[] octets = new byte[1024];

            // creation d'un repertoire où seront stockés les fichiers reçus
            new File("./fichiers_recus").mkdirs();

            BufferedInputStream in = new BufferedInputStream(soc.getInputStream());
            // choix d'un nom par défaut du fichier
            String filename = "tmp";

            String tab[] = null;

            int nbOctetsAttendu = 0;

            if ((num = in.read(octets, 0, octets.length)) != -1) {
                //récupération du nom du fichier
                tab = split(new String(octets), ";:!");
                filename = tab[0];
                nbOctetsAttendu = Integer.parseInt(tab[1]);
            }

            System.out.println("nbOctetsAttendu : " + nbOctetsAttendu);

            // création de la copie locale du fichier transmit
            OutputStream outFichier = new BufferedOutputStream(new FileOutputStream(path + filename));

            // ecriture des premieres données
            outFichier.write(tab[2].getBytes(), 0, tab[2].getBytes().length);
            outFichier.flush();

            // incrémentation de la valeur du nombre d'octets lus/reçus
            nbOctLu += tab[2].trim().getBytes().length;

            // lecture des données sur la socket puis ecriture dans le fichier
            while ((num = in.read(octets, 0, octets.length)) != -1) {
                System.out.println("Octets : ");
                System.out.println(octets.toString());
                outFichier.write(octets, 0, num);
                outFichier.flush();
                nbOctLu += num;
            }

            outFichier.write(octets, 0, nbOctetsAttendu - nbOctLu);
            outFichier.flush();
            nbOctLu += nbOctetsAttendu - nbOctLu;

            // Affichage d'un message dans la fenetre de l'application
            if (main != null) {
                main.showInfo("Fin de reception du fichier, nbOctLu : " + nbOctLu);
            }
            // Affichage d'un message dans la console du terminal
            System.out.println("Fin de reception du fichier, nbOctLu : " + nbOctLu);

            outFichier.close();

            // definition du nom de fichier xml a utiliser
            if (filename.endsWith(".xml")) {
                ctrl.setFichier(filename);
                ctrl.afficherOrdre();
            }

        } catch (Exception e) {
            if (main != null) {
                main.showInfo("Pb lors de la reception du fichier");
            }
            e.printStackTrace();
        }
    }

    /**
     * Méthode permettant de découper une chaine de caracteres en fonction d'un
     * symbole donné
     * @param original la chaine a découper
     * @param separateur le symbole séparateur
     * @return un tableau de chaines de caracteres
     */
    private String[] split(String original, String separateur) {
        Vector nodes = new Vector();

        int index = original.indexOf(separateur);
        while (index >= 0) {
            nodes.addElement(original.substring(0, index));
            original = original.substring(index + separateur.length());
            index = original.indexOf(separateur);
        }
        nodes.addElement(original);

        String[] result = new String[nodes.size()];
        if (nodes.size() > 0) {
            for (int loop = 0; loop < nodes.size(); loop++) {
                result[loop] = (String) nodes.elementAt(loop);
                //System.out.println("split - " + loop + " : " + result[loop]);
            }
        }
        return result;
    }
}
