/* Test de la synthèse vocale
Pour la paramétrer, modifier le fichier donnees/si_vox.conf */

import t2s.son.LecteurTexte;

public class Main {

    public static void main(String[] args) {

        // Chaine devant être lue
        String ordre = new String(
                "Aller tout droit" + " . "
                + "Réponses possibles."
                + "Oui" + " . "
                + "Non" + " . "
                + "Y a un mur" + " . "
                + "Fin" + " .");

        // Chemin des fichiers créés (sans extension) relativement à la racine du projet
        String pathName = "donnees/pho_wav/audioOrdreid0";

        // Nouveau lecteur de texte
        LecteurTexte lt = new LecteurTexte(ordre, pathName);

        // produire les fichiers .pho et .wav, et lire le son
        lt.playAll();

        // afficher le chemin du fichier son créé relatif à la racine du projet
        System.out.println(lt.getPath() + ".wav");

        // Suppression du fichier .pho
        lt.delete(lt.getPath() + ".pho");

        // changer le texte du lecteur
        //lt.setTexte("Un autre texte à lire");

        // produire les fichiers .pho et .wav sans lire le son
        //lt.muet();

    }
}
