/*         
 * SI VOX Copyright (C) 2004 - 2005
 *
 * Author :
 *   ESSI2 school project (2004) : Affouard, Lemonnier, Fournols ,Lizzul
 *   Tutor                (2004) : H�l�ne Collavizza   [ helen@essi.fr    ] 
 *                                 Jean-Paul Stromboni [ strombon@essi.fr ]
 *
 * Contributor :
 *   (2004) : Louis Parisot [ parisot@essi.fr ]
 *   (2005) : S�bastien Mosser  [ mosser@essi.fr ]
 *
 * Institute : 
 *    Polytechnich school, University of Nice - Sophia Antipolis (FRANCE)
 *
 * This program is free software. It uses mbrola speech synthesizers system.
 * 
 * You can redistribute it and/or modify it under the terms of the MBROLA 
 * Licenses  { http://tcts.fpms.ac.be/synthesis/mbrola.html }.
 *
 */

package Synthese.son;

import java.applet.*;
import java.net.URL;

/** Classe permettant de jouer un fichier au format <code>waw</code>
 */

public class JukeBox    {

    private String fileName;  //nom du fichier � lire

    /** Construit un JuxeBox pour un fichier donn�
     * @param s le chemin d'acc�s au fichier
     */
    public JukeBox(String s) {
	fileName = s;
    }

    /** Pour lire le fichier contenu dans le JuxeBox
     */
    public void playSound(){
	AudioClip ac = null;
	try{
	    ac = Applet.newAudioClip(new URL("file:"  + fileName));
	}
	catch (Exception e){
	    e.printStackTrace();
	}
	if (ac != null) {
	    try {
		ac.stop();
		ac.play();
	    }
	    catch (Exception ex) {
		ex.printStackTrace();
	    }
	}
    }
}
