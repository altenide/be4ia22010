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

import java.util.*;

/** Pour repr�senter une phrase (chaine de caract�res) et sa prosodie (ponctuation).
 */
public class Phrase {

    // les prosodies de la phrase : 
    /** Tag de prosodie 'point' */
    public final static int POINT = 0;
    /** Tag de prosodie 'virgule' */
    public final static int VIRGULE = 1;
    /** Tag de prosodie 'int�rogation' */
    public final static int INTERROGATION = 2;
    /** Tag de prosodie par d�faut */
    public final static int DEFAUT = 3;
    /** Tag de prosodie 'exclamation' */
    public final static int EXCLAMATION = 4;


    private int prosodie; // le code de la prosodie de la phrase (. ? , !)
    private String phrase; // la chaine de carat�res correspondante

    /** Constructeur de phrase standart.
     * @param phrase la chaine de caract�re correspondante
     * @param prosodie le code associ� � la prosodie de cette phrase.
     */
    public Phrase(String phrase, int prosodie){
	this.phrase = phrase;
	this.prosodie=prosodie;
    }


    /** Pour r�cuperer le texte de cette phrase.
     * @return la chaine de caract�res de la phrase.
     */
    public String getPhrase(){
	return phrase;
    }

    /** Pour affecter un type de prosodie � la phrase
     * @param p la nouvelle prosodie.
     */
    public void setProsodie(int p){
	prosodie = p;
    }

    /** Pour r�cuperer la prosodie associ�e � la phrase
     * @return l'entier ad'hoc.
     */
    public int getProsodie(){
	return prosodie;
    }

    /** M�thode d'affichage standart d'une instance de phrase.
     * @return la phrase sous forme de String
     */
    public String toString() {
        return "phrase : " + phrase + "prosodie : " + prosodie;
    }
}
