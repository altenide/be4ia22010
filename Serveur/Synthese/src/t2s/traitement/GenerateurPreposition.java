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

package Synthese.traitement;

import java.io.*;
import java.util.*;
import Synthese.util.ConfigFile;

/** Classe d'analyse du fichier qui contient la liste des pr�positions.
 * <p> <b> Remarque </b>: selon la pr�position, on fera une pause longue ou courte. </p>
 */
public class GenerateurPreposition {

    /* constantes pour d�finir la dur�e de la pause */

    /** Une pause courte */
    public static final int COURT = 1;
    /** Une pause longue */
    public static final int LONG = 0;
    /** Absence de pause */
    public static final int VIDE = -1;
    
    // le buffer qui est lu
    private BufferedReader br;
    // le num�ro de ligne courante dans le fichier
    private  int noLigne ; 
    // pour savoir si l'on est en train d'analyser une r�gle longue ou courte
    private int duree;
    // pour savoir s'il reste encore des r�gles
    private boolean vide;


    /** Construit un generateur de regle a partir d'un fichier de pr�position (encodage <code>ISO-8859-1</code>)
     * @param path le chemin d'acc�s au fichier de pr�positions
     */
    public GenerateurPreposition(String path) {
	try {
	    // pour avoir le jeu de caract�res ISO
	    FileInputStream fos = new FileInputStream(path);
	    br = new BufferedReader(new InputStreamReader(fos,ConfigFile.rechercher("ENCODAGE_FICHIER"))); 
	    noLigne = 0;
	    vide = false;
	    duree = VIDE;
	}
	catch (FileNotFoundException e) {
	    System.out.println("SI_VOX WARNING [GenerateurPreposition] : Erreur lors du chargement du fichier de regles");
	    System.out.println(e);
	}
	catch (UnsupportedEncodingException e) {
	    System.out.println("SI_VOX WARNING [GenerateurPreposition] : Encodage inconnu");
	    System.out.println(e);
	}
    }

    /** Pour savoir s'il reste encore des r�gles � lire
     * @return false s'il reste encore des r�gles � lire, true sinon.
     */
    public boolean vide() {
	return vide;
    }

    /** Pour fermer en lecture le fichier de pr�position sp�cifi� dans le constructeur.
     */
    public void close() {
	try {
	    br.close();
	}
	catch (Exception e) {
	    System.out.println("SI_VOX WARNING [GenerateurPreposition.close] : Erreur lors de la fermeture du fichier de regles");	    
	}
    }

    /** Pour lire une ligne � notre mani�re dans un lecteur bufferis�
     * @param br le lecteur bufferis� en question
     * @return une instance de <code>StringTokenizer</code>, r�f�renc� par les caract�res <code>'\t', '\n'</code> et <code>'\r'</code>
     */
    public StringTokenizer tokensLine(BufferedReader br) throws AnalyseException {
	String linein = "";
	try {
	    while (linein!=null && (linein.equals("")|| comment(linein))) {
		linein = br.readLine();
		noLigne++;
	    }
	}
	catch (IOException e) {
	    erreur(1);
	}
	if (linein == null) 
	    erreur(4);
	return new StringTokenizer(linein," \t\n\r");
    }



    /** Pour analyser une ligne du fichier, et en produire une instance de R�gle.
     * <p> <b>D�finition</b> : une preposition est de la forme suivante </p>
     * <p> <center> <code>pr�position -> phon�me </code></center> </p>
     * <p>
     * <ul> 
     *   <li> <code>'pr�position'</code> et <code>'phon�me'</code> sont des chaines de caract�res.</li>
     *   <li> <code>'pr�position'</code> est en minuscules et les <code>' '</code> ont �t� remplac�s par <code>'_'</code>.</li>
     * </ul>
     * </p>
     * @return une nouvelle Regle sur une preposition
     * @throws  AnalyseException
     */
    public Regle nouvellePreposition() throws AnalyseException {
	StringTokenizer line = tokensLine(br);

	if (!line.hasMoreTokens()) 
	    erreur(4);
	String courant = line.nextToken();

	if (fin(courant)) {
	    vide = true; 
	    return null;
	}
	else {
	    if (pause(courant)) {
		// on est sur un mot clef pour indiquer la dur�e de la pause
		line = tokensLine(br);
		if (!line.hasMoreTokens()) 
		    erreur(6);
		courant = line.nextToken();
		if (pauseLongue(courant)) 
		    duree = LONG;
		else 
		    duree = COURT;
	    }
	    else if (duree == VIDE) 
		erreur(2);
	    // on est en d�but de r�gle de pr�position
	    // analyse de la pr�position
	    if (!minuscules(courant)) 
		erreur(3);
	    String preposition = courant;
	    if (!line.hasMoreTokens()) 
		erreur(5);
	    courant = line.nextToken();
	    if (!fleche(courant)) 
		erreur(5);
	    // analyse du phon�me
	    String phoneme = analysePhoneme(line);
	    if (phoneme.equals("")) 
		erreur(7);
	    preposition = "_".concat(preposition);
	    if (!preposition.endsWith("qu'")) 
		preposition = preposition.concat("_");
	    String debut =  (duree == COURT) ? " % " : " %% ";
	    phoneme = debut.concat(phoneme);
	    return new Regle(preposition,phoneme);
	}
    }


    /** Analyse et renvoie le phoneme associ� � la ligne courante
     * Pr�condition : 
     *        on vient de lire la chaine '->'
     * Postcondition : 
     *        Si la chaine est correcte, line est vide
     * @param line le StringTokenizer de la ligne courante
     * @return une String contenant la liste des phon�me de la pr�position
     */
    private String analysePhoneme(StringTokenizer line) throws AnalyseException {
	String pho = "";
	String courant ="";
	while (line.hasMoreTokens() && ! comment(courant )) {
	    courant = line.nextToken();
	    if (!comment(courant)) 
		pho = pho + " " + courant;
	}
	return pho;
    }


    /**
     * M�thodes pour identifier les unit�s lexicales
     */

    /** Teste si une chaine est  accept�e comme pr�position
     * D�finition : 
     *       Chaine accept�e = contient des lettres minuscules, ' ou _
     * @return true si c'est bon, false sinon
     */
    private static boolean minuscules(String s) {
	for (int i = 0; i < s.length();i++) {
	    char c = s.charAt(i);
	    if (c != '\'' && c !='_' && c != '~' && c != '�'  )
		if (!Character.isLowerCase(c)) 
		    return false;
	}
	return true;
    }

 
    /** Teste si une chaine est un commentaire
     * D�finition : 
     *       commentaire = ligne commen�ant par #
     * @param s la chaine de caract�re repr�sentant la ligne � analyser
     */
    private boolean comment(String s) {
	if (s.length() != 0) {
	    int i;
	    for (i=0; i < s.length() && s.charAt(i)==' '; i++) {} // Pour avancer dans la chaine tant qu'on rencontre des espaces
	    if (i < s.length()) 
		return s.charAt(i)=='#';
	}
	return false;
    }

    /** Teste si une chaine est le tag de fin de fichier
     * D�finition : 
     *       tag de fin de fichier = mot� cl� END
     * @return true si on est la fin, false sinon
     */
    private boolean fin(String s) {
	return s.equals("END");
    }

 
    /** Teste si une chaine est le tag de transition.
     * D�finition : 
     *       tag de transition : La fl�che '->'
     * @param s la chaine � analyser
     * @return true si c'est le bon tag, false sinon
     */
    private boolean fleche(String s) {
	return s.equals("->");
    }


    /** Teste si une chaine est le tag de pause courte.
     * D�finition : 
     *       tag de pause courte = mot cl� "PAUSE_COURTE"
     * @param s la chaine � analyser
     * @return true si c'est le bon tag, false sinon
     */
    private boolean pauseCourte(String s) {
	return s.equals("PAUSE_COURTE");
    }

    /** Teste si une chaine est le tag de pause longue
     * D�finition : 
     *       tag de pause longue = mot cl� "PAUSE_LONGUE"
     * @param s la chaine � analyser
     * @return true si c'est le bon tag, false sinon
     */
    private boolean pauseLongue(String s) {
	return s.equals("PAUSE_LONGUE");
    }

    /** teste si une chaine est un tag de pause (courte ou longue)
     * @param s la chaine � analyser
     * @return true si c'est un tag de pause, false sinon
     */
    private boolean pause(String s) {
	return pauseCourte(s) || pauseLongue(s);
    }

    /** M�thode pour transmettre les exceptions
     */
    private void erreur(int i) throws AnalyseException {
	switch (i) {
	case 1 : 
	    throw new AnalyseException("Fin fichier de regles",noLigne);
	case 2 : 
	    throw new AnalyseException("Manque mot clef PAUSE_COURTE ou PAUSE_LONGUE", noLigne);
	case 3 : 
	    throw new AnalyseException("Les pr�positions doivent etre en minuscules, les espaces doivent etre remplac�s par des _", noLigne);
	case 4 : 
	    throw new AnalyseException("tag END attendu",noLigne);
	case 5 : 
	    throw new AnalyseException("tag '->' attendu",noLigne);
	case 6 : 
	    throw new AnalyseException("Pr�position attendue",noLigne);
	case 7 : 
	    throw new AnalyseException("Phon�mes de la pr�position attendue",noLigne);
	}
    }

    /** Une m�thode �x�cutable pour les tests directs de cette classe.
     */

    public static void main(String[] s) {
	GenerateurPreposition p = new GenerateurPreposition("donnees/rules/preposition.txt");
	try {
	    Regle r = p.nouvellePreposition();
	    while (!p.vide()) {
		System.out.println("regle : " + r);
		r = p.nouvellePreposition();
	    }
	} catch (AnalyseException e) {
	    System.out.println(e);
	}
    }
}
