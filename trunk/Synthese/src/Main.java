/* Test de la synthèse vocale
 Pour la paramétrer, modifier le fichier donnees/si_vox.conf */

import t2s.son.LecteurTexte;

public class Main {

    public static void main(String[] args) {

        /* .wav de 360 Ko */
        String ordre = new String(
                "Écoutez attentivement ces instructions."
                + "Ceci est un test d'ordres dans le but d'avoir"
                + "une idée de la taille du fichier son généré."
                + "Vérifiez maintenant, attention, 3, 2, 1, go !");

        LecteurTexte lt = new LecteurTexte(ordre);
        lt.playAll(); // produit les fichiers .pho et .wav et lit le son */
        /*lt.setTexte("Un autre texte à lire"); // pour changer le texte du lecteur
        lt.muet(); // produit les fichiers .pho et .wav */
        System.out.println(LecteurTexte.getPathWav());

    }
}
