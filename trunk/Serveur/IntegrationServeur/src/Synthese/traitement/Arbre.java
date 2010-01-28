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
import Synthese.util.*;



/** Un arbre <i>(pr�fixe)</i> des r�gles pour retrouver les phon�mes correspondant � des groupes de lettres.
 */
public class Arbre {

    private Arbre frere;        // le frere de l'arbre
    private Arbre fils;         // le fils de l'arbre
    private String lettre;      // la lettre
    private ListeRegles regles; // la liste des r�gles de l'arbre

    /**
     * Constructeurs
     */
    
    /** Constructeur d'arbre � partir d'un repertoire contenant des fichiers de r�gles.
     * <p> <b>Organisation du repertoire de r�gles</b> : </p>
     * <p>
     *   <ul>
     *     <li> fichier <code>preposition.txt</code> contenant les pr�positions (pour couper les phrases)</li>
     *     <li> fichier <code>regle.txt</code> contenant les r�gles de prononciation </li>
     *     <li> fichier <code>exception.txt</code> contenant les exceptions de prononciations </li>
     *     <li> fichier <code>acronymes.txt</code> contenant les acronymes de la langue fran�aise </li>
     *   </ul>
     * </p>
     * @param path le chemin d'acc�s au fichiers de r�gles
     */
    public Arbre(String path) throws AnalyseException {
	this();
	// charge les pr�positions qui permettent de couper les phrases
	GenerateurPreposition prop = new GenerateurPreposition(path + ConfigFile.rechercher("PREPOSITIONS"));
	Regle p = prop.nouvellePreposition();

	while (!prop.vide()) {
	    this.ajouter(p);
	    p = prop.nouvellePreposition();
	}
	prop.close();

	// charge les r�gles de traduction, les exceptions et les abbr�viations
	creerLexique(path + ConfigFile.rechercher("REGLES"));
	creerLexique(path + ConfigFile.rechercher("EXCEPTIONS"));
	creerLexique(path + ConfigFile.rechercher("ACCRONYMES"));
    }
    
    /** Constructeur d'arbre vide.
     * <p><b>D�finition</b> : Un arbre vide contient uniquement la lettre 'a'</p>
     */
    private Arbre() {
	frere = null;
	fils = null;
	lettre = "a";
	regles = new ListeRegles();
    }

    /** Construction d'arbre par copie
     * @param a l'arbre por�fixe que l'on souhaite copier dans this.
     */
    private Arbre(Arbre a) {
	this.frere = a.frere;
	this.fils = a.fils;
	this.lettre = a.lettre;
	this.regles = a.regles;
    }
    
    /**
     * M�thodes publiques 
     */
    
    /** Pour trouver les phon�mes associ� � une phrase
     * @param phrase la phrase que l'on veut transformer en phon�mes
     * @return la liste des phonemes qui va bien ^_^.
     */
    public String trouverPhoneme(String phrase) {
	Indice i = new Indice();
	String res = "";
	String tmp = "";
    	while (i.val() < phrase.length()) {
	    tmp =  trouverPhoneme(phrase, i);
	    if (!vide(tmp)) {
		res += tmp;
	    }
	    else {
		// on n'a pas su traiter l'indice courant; on le saute
		i.inc();
	    }
	}
	return res;
    }

    /** M�thode d'affichage standart (affichage en largeur).
     * <p><b>Pr�condition</b> : L'arbre n'est pas vide.</p>
     * @return une chaine de caract�re repr�sentant l'arbre
     */ 
    public String toString() {
	// affichage en largeur
	FileArbre f = new FileArbre();
	f.ajouter(this);
	String s = "";
	while (!f.vide()) {
	    Arbre a = f.retirer();
	    s += a.getRegles().toString() + "\n";
	    Arbre cour = a.getFrere();
	    while (cour != null) {
		f.ajouter(cour);
		cour = cour.getFrere();
	    }
	    if (a.getFils()!=null) f.ajouter(a.getFils());
	}
	return s;
    }

    /**
     * M�thodes priv�es 
     */

    /** M�thode de remplissage de l'arbre
     * @param s le fichier � analyser
     */
    private void creerLexique(String s) throws AnalyseException {
	GenerateurRegle ana = new GenerateurRegle(s);
	Regle a = ana.nouvelleRegle();
	while (!ana.vide()) {
	    this.ajouter(a);
	    a = ana.nouvelleRegle();
	}
	ana.close();
    }

    /** Pour obtenir le fr�re de l'arbre
     * @return l'arbre fr�re
     */
    private Arbre getFrere() {
	return this.frere;
    }

    /** Pour obtenir le fils de l'arbre
     * @return l'arbre fils
     */
    private Arbre getFils() {
	return this.fils;
    }

    /** Pour obtenir la lettre pr�sente � la racine
     * @return la lettre en question
     */
    private String getLettre() {
	return this.lettre;
    }

    /** Pour obtenir la liste de r�gles de l'arbre
     * @return une instance de <code>ListeRegles</code> ad'hoc.
     */
    private ListeRegles getRegles() {
	return this.regles;
    }

    /** Pour modifier le fr�re d'un arbre
     * @param l la lettre pr�sente � la racine de nouveau fr�re
     */
    private void ajouterFrere(String l) {
	Arbre ar = new Arbre();
	ar.lettre = l;
	this.frere = ar;
    }

    /** Pour modifier le fils d'un arbre
     * @param l la lettre pr�sente � la racine de nouveau fils
     */
    private void ajouterFils(String l) {
	Arbre ar = new Arbre();
	ar.lettre = l;
	this.fils = ar;
    }

    /** Pour ajouter en t�te de l'arbre
     * @param l la 
     */
    private void ajouterDebut(String l) {
	Arbre f = new Arbre(this);
	this.frere = f;
	this.fils = null;
	this.lettre = l;
	this.regles = new ListeRegles();
    }

    /** Pour savoir si un arbre est vide
     * @return true si c'est le cas, false sinon.
     */
    private boolean estVide() {
	return getLettre().equals("");
    }

    /** Ajouter une regle a la liste de regles de <code>this</code>.
     * @param regle la r�gle que l'on veut ajouter
     */
    private void ajouter(Regle regle) {
	ajouter(regle.getRacine(), regle);
    }

    /** ajoute une regle a la liste de regles, par rapport � une chaine de caract�re.
     * @param mot la chaine de caract�re 'racine'.
     * @param regle la r�gle a ajouter.
     */
    private void ajouter(String mot, Regle regle) {
	String lettre = mot.substring(0, 1);
	String fin = mot.substring(1);
	if (lettre.equals(getLettre())) {
	    //la lettre existe
	    if (fin.length() == 0) {
		//c'est la derniere lettre
		regles.ajouter(regle);
	    }
	    else {
		//lettre du mot
		if (getFils() == null) 
		    ajouterFils(fin.substring(0, 1));
		getFils().ajouter(fin, regle);
	    }
	}
	else if (lettre.compareTo(getLettre()) > 0) {
	    //la lettre est lexicographiquement apres
	    if (getFrere() == null) 
		ajouterFrere(lettre);
	    getFrere().ajouter(mot, regle);
	}
	else {
	    //la lettre n'existe pas
	    ajouterDebut(lettre);
	    ajouter(mot, regle);
	}
    }  

    /** Pour trouver la liste de phon�me correspondant � un mot � partir d'un indice
     * <p><b>Remarque</b> : on choisit la r�gle qui permet d'unifier  la plus grande chaine commen�ant � l'indice i.</p> 
     * <p><b>Postcondition</b> : i d�signe la prochaine lettre � analyser</p>
     * @param mot le mot � analyser
     * @param i l'indice � partir duquel on analyse
     * @return la liste des phoneme qui va bien(� partir de l'indice i)
     */
    private String trouverPhoneme(String mot, Indice i) {
	// la chaine r�sultat
	String res = ListeRegles.PAS_DE_REGLE; 
	// la lettre courante
	String lettre = mot.substring(i.val(), i.val() + 1);

	if (lettre.equals(getLettre())) {
	    //la lettre existe
	    i.inc();
	    // on applique les r�gles de plus grande racine d'abord
	    // s'il y a un fils et qu'on a encore des lettres
	    // on cherche � appliquer une r�gle sur le fils
	    if (!i.egal(mot.length()) && getFils()!=null) {
		int saveInd = i.val();
		String resFils = getFils().trouverPhoneme(mot, i);
		if (!vide(resFils)) {
		    // on a trouv� un plus grand unificateur
		    res = resFils;
		}
		else { // pas d'unification avec le fils, 
		    // on doit revenir sur la lettre courante
		    i.val(saveInd);
		    res = getRegles().trouverPhoneme(mot, i.val());
		}
	    }
	    // pas de fils ou plus d'autres lettres : on applique
	    // la r�gle courante
	    else  res = getRegles().trouverPhoneme(mot, i.val());
	}
	else 
	    if (lettre.compareTo(getLettre()) > 0) {
		//la lettre est lexicographiquement apres
		if (getFrere() != null) {
		    int saveInd = i.val();
		    String resFrere = getFrere().trouverPhoneme(mot, i);
		    if (!vide(resFrere)) {
			res = resFrere;
		    }
		    else i.val(saveInd);
		}
	    }
	    else res = ListeRegles.PAS_DE_REGLE;
	return res;
    }
    
    /** Pour savoir si une chaine de caract�re est �gale au tag "PAS DE REGLES".
     * @param s la chaine a tester
     * @return true si c'est le cas, false sinon
     */
    private static boolean vide(String s) {
	return s.equals(ListeRegles.PAS_DE_REGLE);
    }

    /**
     * Classes priv�e, utilis�e pour l'affichage de l'arbre (d�buggage)
     */

    private class FileArbre{
	private ChaineArbre entree;
	private ChaineArbre sortie; 

	public FileArbre() {
	    entree = null;
	    sortie = null;
	}

	private FileArbre(FileArbre f) {
	    entree = f.entree;
	    sortie = f.sortie;
	}
	/**
	 * Ajoute un nouvel objet dans la file.
	 */
	public void ajouter(Arbre objet) {
	    if ( vide() ) {
		entree = new ChaineArbre(objet);
		sortie = entree;
	    }
	    else {
		if (!dejaMis(objet,new FileArbre(this))) {
		    entree.suiv = new ChaineArbre(objet);
		    entree = entree.suiv;
		}
	    }
	}

	private boolean dejaMis(Arbre a,FileArbre f) {
	    if (f.vide()) return false;
	    else {
		Arbre af = f.retirer();
		if ((af.getRegles().toString()).equals(a.getRegles().toString()))
		    return true; 
		else return dejaMis(a,f);
	    }
	}
  
	/**
	 * Retire un objet de la file et retourne cet objet.
	 * Pr�condition : la file n'est pas vide.
	 */
	public Arbre retirer() {
	    Arbre x = sortie.a;
	    sortie = sortie.suiv;
	    if ( sortie == null ) {
		entree = null;
	    }
	    return x;
	}

	/**
	 * Retourne l'objet situ� en t�te de la file.
	 * Pr�condition : la file n'est pas vide.
	 */
	public Arbre suivant() {
	    return sortie.a;
	}


	/**
	 * Teste si la file est vide.
	 */
	public boolean vide() {
	    return entree == null;
	}

	/**
	 * Teste si la file est pleine.
	 */
	public boolean pleine() {
	    return false;
	}
    }
    
    private class ChaineArbre{
	private Arbre a;
	private ChaineArbre suiv; 
	    
	public ChaineArbre(Arbre a) {
	    this.a = a;
	}

	public ChaineArbre(Arbre a, ChaineArbre s) {
	    this.a = a;
	    suiv = s;
	}
    }

} 

