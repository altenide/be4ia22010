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

package t2s.prosodie;

import java.util.*;
import t2s.traitement.*;
import java.io.*;

/** Une Classe repr�sentant les  phonemes d'une phrase.
 */
public class ListePhonemes {

    /** le symbole phon�tique de la pause */
    public static final String PAUSE = "_";


    // les phonemes de la phrase
    private Vector phonemes; 
  
    /** Constructeur de liste de phon�mes vide
     */
    public ListePhonemes() {
	phonemes = new Vector();
    }

    /** Constructeur de liste de phon�me pour une phrase donn�es.
     * @param ph la phrase en question
     * @param ponct la ponctuation de cette phrase.
     */
    public ListePhonemes(String ph, int ponct) {
	phonemes = genererPhonemes(ph, ponct);
    }
    
    /** Pour ajouter les phonemes d'une phrase 
     * @param ph la phrase que l'on veut rajouter
     * @param ponct la ponctuation de cette phrase.
     */
    public void ajouterPhonemes(String ph, int ponct) {
	phonemes.addAll(genererPhonemes(ph,ponct));
    }

    /** Pour cr�er le vecteur des phon�mes de la phrase avec la prosodie 
     * @param ph la phrase en question
     * @param ponct la ponctuation de cette phrase.
     * @return un Vector contenant les phon�mes de la phrase.
     */ 
    private static Vector genererPhonemes(String ph, int ponct) {
	Syntagme s  = new Syntagme();
	Vector result = new Vector();
	Vector tempo = new Vector();
	int coupure = ph.indexOf("%");
	while (coupure != -1) {
	    if (coupure != 1) { // on ne traite pas le % en d�but
		s = Syntagme.type(ph,coupure);
		tempo = genererLesPhonemes(ph,coupure-1,s);
		appliquerProsodie(tempo,s); 
		result.addAll(tempo);
	    }
	    // on enl�ve % ou %%
	    ph = elaguer(ph,coupure);
	    coupure = ph.indexOf("%");
	}
	// on traite la fin
	s = Syntagme.typeFin(ponct);
	tempo = genererLesPhonemes(ph,ph.length(), s);
	appliquerProsodie(tempo,s); 
	result.addAll(tempo);
	return result;
    }
    
    /** Pour cr�er le vecteur des phon�mes de la phrase ph jusqu'� l'indice fin avec seulement les dur�es
     * <p><b>Pr�condition</b> : ph[0:fin] ne contient pas % ou %%</p>
     * @param ph la chaine contenant les phon�mes
     * @param fin : l'indice de fin de la chaine � consid�rer
     * @param synt : type de la phrase
     * @return : le vecteur contenant les phon�mes de ph[0:fin]
     */ 
    private static Vector genererLesPhonemes(String ph,  int fin, Syntagme synt) {
	Vector result = new Vector();
	StringTokenizer st = new StringTokenizer(ph.substring(0,fin));
	while (st.hasMoreTokens()) {
	    String s = st.nextToken();
	    result.add(new Phoneme(s));
	}   
	// on allonge le premier et le dernier phon�me du syntagme
	((Phoneme)result.firstElement()).allonge(synt);
	((Phoneme)result.lastElement()).allonge(synt);
	result.add(new Phoneme(PAUSE,synt.dureePause()));
	return result;
    }
    

    /** Pour supprimer '%' ou '%%' du d�but d'une phrase
     * @param ph la phrase en question
     * @param coupure l'endroit de <code>ph</code> que l'on souhaite analyser
     */
    private static String elaguer(String ph, int coupure) {
	if (ph.charAt(coupure+1) == '%') 
	    return ph.substring(coupure+2);
	else 
	    return  ph.substring(coupure+1);
    }	

    /** Pour appliquer un sch�ma de prosodie en fonction du type de Syntagme.
     * <p><b>Postcondition</b> : Le sch�ma de prosodie ad'hoc est appliqu� � <code>pho</code> par <i>side-effect</i></p>
     * @param pho : le vecteur des phon�mes avec les dur�e
     * @param synt : le Syntagme associ�
     */ 
    public static void appliquerProsodie(Vector pho, Syntagme synt) {
	int length = pho.size();
	int i=0;
	int fin = (int)(length*0.5)+1;
	Courbe c = new Courbe(synt,length);
 	while (i<length) {
	    Phoneme p = (Phoneme)pho.elementAt(i);
	    if (!p.estPause()) p.setProsodie(c.nextValue());
	    i++;
	}
    }


    /** Pour obtenir la dur�e de la prononciation de la liste compl�te des phon�mes
     * @return la dur�e ad'hoc
     */
    public int dureePhonemes(){
	int n=0;
	for( int i=0;i<phonemes.size();i++ )
            n+=((Phoneme)phonemes.elementAt(i)).getLongueur();
	return n;
    }

    /** Pour obtenir le nombre de phon�mes pr�sent dans cette liste
     * @return le nombre de phon�mes en questions.
     */
    public int nombrePhonemes(){
	return phonemes.size();
    }

    /** Pour obtenir le nombre de phon�mes pr�sent dans cette liste et n'�tant pas des pauses
     * @return le nombre de phon�mes ad'hoc.
     */
    private static int nombrePhonemesSansPause(Vector pho){
	return nombrePhonemesSansPause(0,pho);
    }

    /** Pour obtenir le nombre de phon�mes pr�sent dans cette liste et n'�tant pas des pauses
     * @return le nombre de phon�mes qui ne sont pas des pauses
     */
    private static int nombrePhonemesSansPause(int j, Vector pho){
	int n=0;
	for( int i=j;i<pho.size();i++ )
            if (!((Phoneme)pho.elementAt(i)).estPause()) n++; 
	return n;
    }
    /** Pour �crire les phon�mes dans un fichier
     * @param name le nom du fichier danslequel on souhaite �crire ces phon�mes
     */
    public void ecrirePhonemes(String name) {
	try {
	    FileWriter fw = new FileWriter(name);
	    fw.write(toString());
	    fw.close();
	}
	catch (Exception e) {
	    System.out.println("SI_VOX WARNING [ListePhonemes.ecrirePhonemes] : Erreur lors de l'�criture du fichier .pho");
	}
    }

    /** Pour afficher la liste de phon�me au format MBROLA
     */
    @Override
    public String toString() {
	String res = "" ;
	for (int i = 0; i < phonemes.size(); i++) {
	    res +=((Phoneme)phonemes.elementAt(i)).toString() ;
	    res +=  "\n";
	}
	return res;
    }


    /** Une m�thode �x�cutable de test
     */
    public static final void main(String[] s) {
	ListePhonemes p = new ListePhonemes("b o~ Z u R % i l",Phrase.VIRGULE);
	System.out.println("main :\n" + p);
	p.ecrirePhonemes("bidon");
    }

}
