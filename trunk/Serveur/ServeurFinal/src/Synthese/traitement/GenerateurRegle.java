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
import java.util.regex.*;
import Synthese.util.ConfigFile;
/** Un g�n�rateur de R�gles, �crites au format PERL dans un fichier texte.
 */
public class GenerateurRegle {

    // le buffer qui est lu
    private BufferedReader br;
    // une hashtable qui contient les classes lexicales
    private Hashtable ensembles;
    // le num�ro de ligne courante dans le fichier
    private  int noLigne ; 
    // pour savoir s'il reste encore des r�gles
    private boolean vide;

    /** Construction standart d'un g�n�rateur de r�gles � partir d'un fichier.
     * @param path le chemin d'acc�s au fichier utilis� (encodage <code>ISO-8859-1</code>)
     */
    public GenerateurRegle(String path) {
	try {
	    // pour avoir le jeu de caract�res ISO
	    FileInputStream fos = new FileInputStream(path);
	    br = new BufferedReader(new InputStreamReader(fos,ConfigFile.rechercher("ENCODAGE_FICHIER") )); 
	    //br = new BufferedReader(new FileReader(new File(path)));
	    ensembles = new Hashtable();
	    noLigne = 0;
	    vide = false;
	    initEnsembles();
	}
	catch (FileNotFoundException e) {
	    System.out.println("SI_VOX WARNING [GenerateurRegle] :  Erreur lors du chargement du fichier de regles");
	}
	catch (AnalyseException e) {
	    System.out.println("SI_VOX WARNING [GenerateurRegle] : Une erreur d'analyse est survenue !");
	    System.out.println(e);
	}
	catch (UnsupportedEncodingException e) {
	    System.out.println("SI_VOX WARNING [GenerateurRegle] : Encodage inconnu");
	}
    }

    /** Pour savoir s'il reste encore des r�gles � lire dans le fichier
     * @return true si on n'a plus de r�gles � lire, false sinon.
     */
    public boolean vide() {
	return vide;
    }

    /** Femreture en lecture du fichier de r�gles.
     */
    public void close() {
	try {
	    br.close();
	}
	catch (Exception e) {
	    System.out.println("SI_VOX WARNING [GenerateurRegle.close] : Erreur lors de la fermeture du fichier de r�gles !");
	} 
    }

    /** Analyse d'une ligne du fichier (chargement dans le tampon et transformation)
     * @param br le lecteur bufferis� servant � faire la lecture du fichier.
     * @return une instance de <code>StringTokenizer</code> associ� aux caract�res <code>'\t','n'</code> et <code>'\r'</code>
     */
    public StringTokenizer tokensLine(BufferedReader br) throws AnalyseException {
	String linein = "";
	try {
	    while (linein!=null && (linein.equals("") || comment(linein))) {
		linein = br.readLine();
		noLigne++;
	    }
	}
	catch (IOException e) {
	    erreur(1);
	}
	if (linein == null) 
	    erreur(9);
	return new StringTokenizer(linein," \t\n\r");
    }


    /** Pour initialiser les classes de lettres (initialisation du g�n�rateur)
     * <p> <b>Remarque</b> : Modifie par effet de bord la table de hachage globale des ensembles de lettres </p>
     */
    public void initEnsembles() throws AnalyseException {
	StringTokenizer line = tokensLine(br);
	if (line.hasMoreTokens()) {
	    String first = line.nextToken();
	    if (classes(first)) 
		initClasses();
	    else 
		if (! rules(first)) 
		    erreur(2);
	}
	else 
	    erreur(1);
    }

    /** Pour cr�er l'ensemble des classes
     */
    private void initClasses() throws AnalyseException {
	String first = "";
	do {
	    StringTokenizer line = tokensLine(br);
	    if (line.hasMoreTokens()) {
		first = line.nextToken();
		if (classs(first)) 
		    initOneClass(line);
		else if (! rules(first)) 
		    erreur(2);
	    } 
	} while (!rules(first));
    }

    /** Pour cr�er une classe unique
     * Pr�condition : 
     *        On arrive ici APRES avoir reconnu le tag de classe dans line
     * @param line le <code>StringTokenizer</code> que l'on veut analyser
     */
    private void initOneClass(StringTokenizer line) throws AnalyseException{
	String name = "";
	String value = "";
	if (line.hasMoreTokens()) {
	    name = line.nextToken();
	    // on v�rifie que l'identificateur est en majuscules
	    if (!majuscules(name)) 
		erreur(3);
	    if (ensembles.containsKey(name))
		erreur(4);
	}
	else 
	    erreur(5);

	if (line.hasMoreTokens()) {
	    value = line.nextToken();
	    if (comment(value)) 
		erreur(6);
	    value = analyseExpReg(value);
	}
	else erreur(6);
	// ici on a un nom et une expression de classe corrects
	ensembles.put(name,value);
    }

    /** Pour analyser une expression r�guli�re
     * Postcondition : 
     *         On aura lev� une exception si : 
     *              - La chaine ne correspond pas � une expression r�guli�re de syntaxe correcte
     *              - Il y a des majuscules qui ne correspondent pas � un ident de classe
     * @return la chaine dans laquelle on a substitu� les ident de classe par leurs valeurs
     */

    private String analyseExpReg(String value) throws AnalyseException {
	// v�rifie la syntaxe de l'expression r�guli�re
	try {
	    Pattern p = Pattern.compile(value);
	}
	catch (PatternSyntaxException pe) {
	    erreur(7);
	} 
	// v�rifie que les majuscules correspondent � des identificateurs de classe connus
	String res = "";
	int lg = value.length();
	int i=0;
	    
	while (i < lg) {
	    char cour = value.charAt(i);
	    i++;
	    String ident = "";
	    if (!majuscule(cour)) {
		res += cour;
	    }
	    else {
		ident += cour;
		while (i < lg && majuscule(cour) && !ensembles.containsKey(ident)) {
		    cour = value.charAt(i);
		    i++;
		    if  (majuscule(cour)) 
			ident+=cour;
		}

		// on a un identificateur
		if (ensembles.containsKey(ident)) {
		    res = res + ensembles.get(ident);
		}
		else 
		    erreur(8);
	    }
	}
	return res;
    }
	      

    /** Fabrication d'une nouvelle r�gle � partir d'une ligne du fichier .
     * <p><b>D�finition</b> : Une r�gle est de la forme suivante :
     * <p> <center> <code> pref [[ <racine> ]] suf -> phoneme </code> </center> </p>
     * <p>
     * <ul>
     *   <li> <code>pref</code> et <code>suf</code> sont des expressions r�guli�res syntaxiquement correctes </li>
     *   <li> <code>racine</code> et <code>phoneme</code> sont des chaines de caract�res standarts
     * </ul>
     *</p>
     * @return une nouvelle Regle construite � partir de ce qu'on vient de lire.
     * @throws AnalyseException
     */
    public Regle nouvelleRegle() throws  AnalyseException {
	StringTokenizer line = tokensLine(br);

	if (!line.hasMoreTokens())
	    erreur(9);
	String courant = line.nextToken();

	if (fin(courant)) {
	    vide = true; 
	    return null;
	}
	else {
	    String pref;
	    
	    if (ouvrant(courant))
		pref = "";
	    else {
		pref = analyseExpReg(courant);
		if (!line.hasMoreTokens())
		    erreur(10);
		courant = line.nextToken();
		if (!ouvrant(courant))
		    erreur(10);
	    }
	    String racine = analyseRacine(line);
	    
	    if (!line.hasMoreTokens()) 
		erreur(11);
	    courant = line.nextToken();
	    String suf;
	    if (fleche(courant)) 
		suf = "";
	    else {
		suf = analyseExpReg(courant);
		if (!line.hasMoreTokens()) 
		    erreur(11);
		courant = line.nextToken();
		if (!fleche(courant))
		    erreur(11);
	    }
	    String phoneme = analysePhoneme(line);
	    return new Regle(pref,racine,suf,phoneme);
	}
    }

    /** Pour analyser la racine
     * Pr�condition : 
     *      1. On vient de lire le tag '[['
     * Postcondition :
     *      1. si la chaine est correcte, line commence apr�s le tag ']]'
     * @param line le tokenizer de la ligne que l'on analyse.
     * @return La chaine de caract�res qui repr�sente la racine.
     */
    private String analyseRacine(StringTokenizer line) throws AnalyseException {
	if (!line.hasMoreTokens()) 
	    erreur(12);
	String courant = line.nextToken();
	if (!minuscules(courant)) 
	    erreur(13);
	String racine  = courant;
	if (!line.hasMoreTokens()) 
	    erreur(14);
	courant = line.nextToken();
	if (!fermant(courant)) 
	    erreur(14);
	return racine;
    }

    /** Pour analyser le phon�me
     * Pr�condition : 
     *       1. on vient de lire le tage de transition '->'
     * Postcondition : 
     *       1. si la chaine est correcte, 'line' est vide
     * @param line le tokenizer de la ligne que l'on analyse.
     * @return La chaine de caract�res qui repr�sente la racine.
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

    /** teste si une chaine est enti�rement en majuscule
     * @param s la chaine en question
     * @return true si c'est le cas, false sinon
     */
    private static boolean majuscules(String s) {
	for (int i = 0; i < s.length();i++)
	    if (!majuscule(s.charAt(i))) 
		return false;
	return true;
    }

    /** Teste si une chaine est compos�e de lettre accept�e comme racine
     * D�finition : 
     *       accpet�e comme faisant partie de la racine = lettre minuscule, ' ou _
     * @param s la chaine de caract�re � analyser
     * @return true si c'est bon, false sinon.
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

    /** Teste si un caract�re est en majuscule
     * @param c le caract�re en question
     * @return true si c'est bon, false sinon
     */
    private static boolean majuscule(char c) {
	return Character.isUpperCase(c);
    }


    /** Teste si une chaine est un commentaire
     * D�finition : 
     *       commentaire = ligne commen�ant par #
     * @param s la chaine � tester
     * @return true si c'est un commentaire, false sinon
     */
    private boolean comment(String s) {
	if (s.length() != 0) {
	    int i;
	    for (i=0; i < s.length() && s.charAt(i)==' '; i++) {} // On d�gage les espaces en d�but de chaine
	    if (i < s.length()) 
		return s.charAt(i)=='#';
	}
	return false;
    }

    /** Teste si une chaine est le tag de fin de fichier
     * D�finition : 
     *       tag de fin de fichier = mot cl� 'END'
     * @param s la chaine � tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean fin(String s) {
	return s.equals("END");
    }

    /** Teste si une chaine est le tag d'ouverture de racine 
     * D�finition : 
     *       tag d'ouverture de racine = mot cl�  '[['
     * @param s la chaine � tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean ouvrant(String s){
	return s.equals("[[");
    }

    /** Teste si une chaine est le tag de fermeture de racine
     * D�finition : 
     *       tag de fermeture de racine = mot cl� ']]'
     * @param s la chaine � tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean fermant(String s){
	return s.equals("]]");
    }

    /** Teste si une chaine est le tag de transition
     * D�finition : 
     *       tag de transition = mot cl� '->'
     * @param s la chaine � tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean fleche(String s) {
	return s.equals("->");
    }

    /** Teste si une chaine est le tag de d�but de d�finition des classes
     * D�finition : 
     *       tag de d�finition des classes = mot cl� 'CLASSES'
     * @param s la chaine � tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean classes(String s) {
	return s.equals("CLASSES");
    }

    /** teste si une chaine est le tag de classe
     * D�finition : 
     *       tag de classe = mot cl� 'CLASS'
     * @param s la chaine � tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean classs(String s) {
	return s.equals("CLASS");
    }

    /** teste si une chaine est le tag de r�gles
     * D�finition : 
     *       tag de r�gles = mot cl� 'RULES'
     * @param s la chaine � tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean rules(String s) {
	return s.equals("RULES");
    }
    

    /** M�thode pour transmettre les exceptions selon le type d'erreur
     * @param i l'entier correspondant au code d'erreur rencontr�e
     */
    private void erreur(int i) throws AnalyseException {
	switch (i) {
	case 1 : 
	    throw new AnalyseException("Fin fichier de regles",noLigne);
	case 2 : 
	    throw new AnalyseException("Manque mot clef CLASSES ou RULES", noLigne);
	case 3 : 
	    throw new AnalyseException("Les mots clefs doivent etre en majuscules", noLigne);
	case 4 : 
	    throw new AnalyseException("Identificateur d�j� utilis�", noLigne);
	case 5 : 
	    throw new AnalyseException("Manque nom de classe", noLigne);
	case 6 : 
	    throw new AnalyseException("Manque d�finition de classe", noLigne);
	case 7 : 
	    throw new AnalyseException("Mauvaise syntaxe d'expression r�guli�re : ", noLigne);
	case 8 : 
	    throw new AnalyseException("Majuscules interdites en dehors des identificateurs d'ensembles", noLigne);
	case 9 : 
	    throw new AnalyseException("Tag END attendu",noLigne);
	case 10 : 
	    throw new AnalyseException("Tag [[ attendu",noLigne);
	case 11 : 
	    throw new AnalyseException("Tag -> attendu",noLigne);
	case 12 : 
	    throw new AnalyseException("Racine de r�gle attendue",noLigne);
	case 13 : 
	    throw new AnalyseException("La racine de r�gle doit etre en minuscules",noLigne);
	case 14 : 
	    throw new AnalyseException("Tag ]] attendu",noLigne);
	}
    }

}
