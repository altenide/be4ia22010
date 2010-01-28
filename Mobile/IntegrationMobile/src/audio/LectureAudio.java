package audio;

import com.teklogix.sound.WaveSound;

/**
 * Classe de gestion de la lecture d'un fichier audio
 */
public class LectureAudio {

    /**
     * Lis un fichier audio sur le terminal
     * @param fichier chemin du fichier a lire
     */
	public void lire ( String fichier){
	 WaveSound.playWaveFile(fichier);
	}

}
