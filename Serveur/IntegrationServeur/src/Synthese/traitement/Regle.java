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
import Synthese.util.*;

/** R�gle de la langue francaise et des exceptions sur les phonemes.
 * <p> Une instance de Regle est compos�e  : <p>
 * <ul>
 *  <li> D'un pr�fixe (expression r�guli�re) </li>
 *  <li> D'un suffixe (expression r�guli�re) </li>
 *  <li> D'une racine </li>
 *  <li> D'une chaine courante contenant les phon�mes de la r�gle </li>
 * </ul
 * <p> A toute r�gle, on associe automatiquement une priorit�, calcul� par le poid de chacune des expr�ssions r�guli�res pr�sente en suffixe et en pr�fixe.</p>
 */
public class Regle{

    private String prefix;  // le pr�fixe
    private String suffix;  // le suffixe
    private String racine;  // la racine du mot
    private String phoneme; // la String contenant les phon�mes
    private int priorite;   // la priorit� de la r�gle

    /** Pour construire une R�gle vide.
     * <p> Tous les param�tres sont initialis� � la chaine vide.
     */
    public Regle() {
	this("","","","");
    }

    /** Pour construire une R�gle sans suffixe ni prefixe.
     * <p> <b> Remarque </b> : utilis� pour les r�gles sur les pr�positions </p>
     * @param r la racine de la r�gle
     * @param ph la chaine contenant les phon�mes
     */
    public Regle(String r,String ph) {
	this("",r, "", ph);
    }

    /** Pour construire une R�gle compl�te.
     * @param p le pr�fixe
     * @param r la racine
     * @param s le suffixe
     * @param ph la chaine contenant les phon�mes
     */
    public Regle(String p, String r, String s, String ph) {
	prefix = p;
	suffix = s;
	racine = r;
	phoneme = ph;
	priorite = poids(p) + poids(s);
    }

    /** Pour r�cuperer le pr�fixe de la r�gle
     * @return l'expression reguliere de l'�l�ment prefix.
     */
    public String getPrefix() {
	return prefix;
    }

    /** Pour r�cuperer le suffixe de la r�gle
     * @return l'expression reguliere de l'�l�ment suffix.
     */
    public String getSuffix() {
	return suffix;
    }

    /** Pour r�cuperer la racine de la r�gle
     * @return  la racine de la r�gle.
     */
    public String getRacine() {
	return racine;
    }

    /** Pour r�cuperer le phon�me de la r�gle
     * @return le phoneme associ� a l'�l�ment courant.
     */
    public String getPhoneme() {
	return phoneme;
    }

    /** Pour r�cuperer la priorit� de la r�gle.
     * <p> <b>Remarque</b> : La priorit� est la somme du poid de chacune des E.R. pr�sente dans la r�gle </p>
     * <p> <center> { <code>priorit� <-- poid(prefixe) + poid(suffixe)</code> } </center> </p>
     * <p> <b> Calcul du poid </b> : Il s'agit de la longueur maximale de la chaine d�finie par l'E.R. <br>En cas de choix (<code>'|'</code>),
     *     on prend la longueur de la plus grande chaine.</p>
     * @return la priorit� associ�e a l'�l�ment courant.
     */
    public int priorite() {
	return priorite;
    }

    /** Pour modifier la chaine de phon�mes
     * @param ph la nouvelle chaine � mettre dans la R�gle
     */
    public void setPhoneme(String ph) {
	phoneme = ph;
    }

    /* 
     * M�thodes pour calculer la priorit� de la r�gle
     */

    /* Pour calculer le poid d'une E.R.
     */

    private static int poids(String s) {
	return poids(s,new Indice());
    }

    /** Renvoie le poids de l'expression r�guli�re s
     * D�finition : 
     *       poids = longueur max de la chaine d�finie par l'expression r�guli�re s.
     *               { Quand il  y a un choix '|', on prend la longueur de la plus grande chaine. }
     * Pr�condition : 
     *       1. s est une expression r�guli�re syntaxiquement correcte 
     *       2. On a calcul� le poids jusqu'� l'indice ind
     */
    private static int poids(String s, Indice ind) {
	if (fin(s,ind)) 
	    return 0;
	else {
	    int max = poidsTerme(s,ind);
	    while (!fin(s,ind)) {
		char cour = s.charAt(ind.val());
		ind.inc();
		if (cour == '|') {
		    int lgCour = poidsTerme(s,ind);
		    if (lgCour > max) max = lgCour;
		}
	    }	
	    return max ;
	}
    }

    /** Renvoie le poids d'un sous-terme.
     * D�finition : 
     *       les sous-termes sont s�par�s pas des '|'
     * Pr�condition : 
     *       1. s est une expression r�guli�re syntaxiquement correcte 
     *       2. on a calcul� le poids jusqu'� l'indice ind
     * Postcondition : 
     *       1. ind d�signe  '|', ')' ou la fin de s
     */
    private static int poidsTerme(String s, Indice ind) {
	if (finTerme(s,ind)) return 0;
	else {
	    char cour = s.charAt(ind.val());
	    if (cour == '[') {
		// on ajoute un caract�re � la chaine
		// on continue l'analyse sur ']'
		ind.val(s.indexOf("]", ind.val()));
		//System.out.println("ind : " + ind);
		ind.inc();
		return 1 + poidsTerme(s,ind);
	    }
	    else {
		if (cour == '(') {
		    ind.inc();
		    int lg = poids(s,ind);
		    // on saute la ')'
		    ind.inc();
		    return lg + poidsTerme(s,ind);
		}
		else { // on est sur une lettre
		    ind.inc();
		    return 1 + poidsTerme(s,ind);
		}
	    }
	}
    }	    

    /** D�termine si s[ind] est la fin d'un terme de s
     * D�finition : 
     *       fin d'un terme = vide ou �gal � ')' ou '|'
     */ 
    private static boolean finTerme(String s, Indice ind) {
	if (ind.egal(s.length())) 
	    return true;
	else {
	    char c = s.charAt(ind.val());
	    return (c==')') || (c=='|');
	}
    }

    /** D�termine si ind est la fin de s
     * D�finition : 
     *       fin de la chaine = s[ind] est vide ou �gal � ')'
     */
    private static boolean fin(String s, Indice ind) {
	if( ind.egal(s.length())) 
	    return true;
	else {
	    char c = s.charAt(ind.val());
	    return (c==')');
	}
    }


    /**Pour afficher une R�gle de mani�re lisible
     * @return la chaine de caract�res qui va bien ^_^.
     */
    public String toString() {
	return ("pref : " + prefix + " racine : " + racine 
		+ " suff :  " + suffix + " pho :  " + phoneme + "\n");
    }

    /** Une m�thode �x�cutable pour faire des tests
     */
    public static void main(String[] s) {
	System.out.println(poids("(a|[ab][ef])(a|b)|ab[cbfe]a|a[ab](de|abc)dfe", new Indice(0)));
	System.out.println(poids("a",new Indice(0)));
    }
}
