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

package Synthese.util;

import java.io.*;

/** une classe pour num�roter les fichiers utilis� par le serveur [0->20->0->...]
 * TO DO : Remplacer cette m�thode par un referencement des IP
 */

public class StaticCounter {

    /** Le compteur en lui m�me (valeur courante, 0 par defaut)
     */
    public static Integer COUNT = new Integer(0);

    /** Le constructeur totalement inutile, il ne fait strictement rien
     */
    public StaticCounter() {}

    /** Pour incrementer de 1 (modulo 20) le num�ro pr�sent dans <code>COUNT></code>
     */
    public Integer compte() {
	COUNT = new Integer((COUNT.intValue() + 1) % 20);
	return COUNT;
    }
}
