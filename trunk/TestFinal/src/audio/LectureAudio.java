package audio;

import com.teklogix.sound.WaveSound;


public class LectureAudio {
	
	public void lire ( String fichier){
	 WaveSound.playWaveFile(fichier);
	}

}
