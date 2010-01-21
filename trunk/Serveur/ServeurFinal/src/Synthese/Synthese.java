package Synthese;

/* Synthèse vocale
Pour la paramétrer, modifier le fichier donnees/si_vox.conf */
import Synthese.son.LecteurTexte;
import gestionbdd.Mission;
import gestionbdd.Ordre;

public class Synthese {

    private String pathName;
    private LecteurTexte lt;

    // dossier où sont enregistrés les fichiers son (par rapport à la racine du projet)
    private static String path = new String ("donnees/pho_wav/");

    /** Constructeur qui synthétise un son
     * Le fichier son est créé, mais pas joué.
     * @param l'ordre à synthétiser
     */
    public Synthese(Ordre ordre) {

        // Chemin des fichiers créés (sans extension) relativement à la racine du projet
        this.pathName = path + ordre.getFilename();

        // Nouveau lecteur de texte
        this.lt = new LecteurTexte(ordreAudio(ordre), pathName);

        this.synt();
    }

    /** Constructeur qui synthétise un son
     * Le fichier son est créé et joué si voulu
     * @param ordre l'ordre à synthétiser
     * @param withSound true si on veut jouer le son, false sinon
     */
    public Synthese(Ordre ordre, Boolean withSound) {

        // Chemin des fichiers créés (sans extension) relativement à la racine du projet
        this.pathName = path + ordre.getFilename();

        // Nouveau lecteur de texte
        this.lt = new LecteurTexte(ordreAudio(ordre), pathName);

        if (withSound) {
            this.syntAndPlay();
        } else {
            this.synt();
        }
    }

    /** Constructeur qui synthétise tous les ordres d'une mission
     * Les fichiers son sont créés, mais pas joués
     * @param mission la mission dont on veut synthétiser les ordres
     */
    public Synthese(Mission mission) {

        if (mission.getListOrdres().size() != 0) {

            this.pathName = path + mission.getListOrdres().get(0).getFilename();
            this.lt = new LecteurTexte(ordreAudio(mission.getListOrdres().get(0)), pathName);

            this.synt();

            int i = 1;

            while (i < mission.getListOrdres().size()) {

                this.pathName = path + mission.getListOrdres().get(i).getFilename();
                this.lt = new LecteurTexte(ordreAudio(mission.getListOrdres().get(i)), pathName);

                this.synt();

                i++;
            }
        }
    }

    /** Constructeur qui synthétise tous les ordres d'une mission
     * Les fichiers son sont créés et joués si voulu
     * @param mission la mission dont on veut synthétiser les ordres
     * @param withSound true si on veut jouer les sons, false sinon
     */
    public Synthese(Mission mission, Boolean withSound) {

        if (mission.getListOrdres().size() != 0) {

            this.pathName = path + mission.getListOrdres().get(0).getFilename();
            this.lt = new LecteurTexte(ordreAudio(mission.getListOrdres().get(0)), pathName);

            if (withSound) {
                this.syntAndPlay();
            } else {
                this.synt();
            }

            int i = 1;

            while (i < mission.getListOrdres().size()) {

                this.pathName = path + mission.getListOrdres().get(i).getFilename();
                this.lt = new LecteurTexte(ordreAudio(mission.getListOrdres().get(i)), pathName);

                if (withSound) {
                    this.syntAndPlay();
                } else {
                    this.synt();
                }

                i++;
            }
        }
    }

    /** Construction de la chaine contenant les réponses possibles
     *
     * @return la chaine complete devant être synthétisée
     */
    private String ordreAudio(Ordre ordre) {
        String reponsesPossibles = new String();
        for (int i = 0; i < ordre.getReponsesPossibles().size(); i++) {
            reponsesPossibles += " . " + ordre.getReponsesPossibles().get(i).getReponse();
        }
        reponsesPossibles += " .";

        return (ordre.getContenu() + reponsesPossibles);
    }

    /** produire les fichiers .pho et .wav sans lire le son
     *
     */
    public void synt() {
        lt.muet();
        // Suppression du fichier .pho
        lt.delete(lt.getPath() + ".pho");
    }

    /** produire les fichiers .pho et .wav, et lire le son
     *
     */
    public void syntAndPlay() {
        lt.playAll();
        // Suppression du fichier .pho
        lt.delete(lt.getPath() + ".pho");
    }

    /** Retourne le chemin vers le fichier son depuis la racine du projet
     *
     * @return le chemin vers le fichier son depuis la racine du projet
     */
    public String getPath() {
        return (lt.getPath() + ".wav");
    }

    /** Changer le texte d'un ordre
     * écrase le fichier son de l'ordre précédent
     * @param ordre le nouvel ordre à passer
     */
    public void newOrdre(Ordre ordre) {
        lt.setTexte(ordreAudio(ordre));
    }
}
