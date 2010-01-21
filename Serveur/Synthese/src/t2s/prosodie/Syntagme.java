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

package Synthese.prosodie;

import Synthese.traitement.*;
import Synthese.util.*;

/** Classe repr�sentant les diff�rentes cat�gories de syntagme.
 * <p><b>D�finition</b> : [ cf. <code><a href="http://fr.wikipedia.org/wiki/Syntagme">WikiP�dia</a></code> ]<p>
 * <p> Un syntagme est un ensemble de mots formant une seule unit� cat�gorielle et fonctionnelle, mais dont chaque constituant, parce que dissociable (contrairement au mot compos�), conserve sa signification et sa syntaxe propres. Un syntagme constitue donc une association occasionnelle, libre, alors que le mot compos� est une association permanente (lorsqu'un syntagme se fige, il devient bien s�r un compos� d�tach�, soit une locution).
 * <ul>
 * <li>Les �l�ments constitutifs d'un syntagme donn� peuvent �tre de nouveaux syntagmes de niveau inf�rieur (des sous-syntagmes), structur�s � l'instar du syntagme qui les englobe. � son tour, chacun de ces sous-syntagmes pourra le cas �ch�ant, contenir d'autres syntagmes hi�rarchiquement subalternes (des sous-sous-syntagmes, en somme), et ainsi de suite.</li>
 * <li>En cons�quence, quel que soit le niveau d'un syntagme donn�, celui-ci peut virtuellement �tre inclus dans un syntagme de niveau sup�rieur (principe de regroupement), mais peut aussi bien inclure un syntagme de niveau inf�rieur (principe de division) :</li>
 * <ul><li><i>Il a achet� une modeste maison de briques rouges.</i></li>
 * <li>Le syntagme � une modeste maison de briques rouges � est englob� dans le syntagme sup�rieur, c'est-�-dire, la phrase compl�te. Mais ce m�me syntagme � une modeste maison de briques rouges � inclut parmi ses �l�ments, le syntagme inf�rieur � de briques rouges �, compl�ment du nom � maison �.</li></ul>
 * <li> Ce double principe de regroupement et de division (soit, le principe d'inclusion) et cette identit� de structure font du syntagme le v�ritable constituant syntaxique de la phrase.</li>
 * <li>Le syntagme poss�de l'unit� cat�gorielle et fonctionnelle du mot indivisible.</li>
 * </ul></p>
 * <p> <b>En clair</b> : un syntagme est une 'partie de phrase'</p>
 */

public class Syntagme {

    /**
     * Les diff�rents types de syntagmes  
     */

    /** Syntagme mineur : d�but ou milieu de phrase mineure */
    protected static final int MINEUR = 1;      // <==> courbe A
    /** Syntagme majeur : d�but ou milieu de phrase majeure*/
    protected static final int MAJEUR = 2;      // <==> courbe B
    /** Syntagme int�rogatif : fin de phrase interrogative */
    protected static final int FIN_INTERRO = 3; // <==> courbe C
    /** Syntagme final : fin de phrase */
    protected static final int FIN = 4;         // <==> courbe D
    /** Syntagme exclamatif : fin de phrase exclamative */
    protected static final int FIN_EXCLAM = 5;  // <==> courbe E

    /**
     * Les dur�es des pauses a effectuer
     */
    /** Une pause courte : conjonction de coordination */
    protected static final int PAUSE_COURTE = Integer.parseInt(ConfigFile.rechercher("PAUSE_COURTE")); 
    /** Une pause longue : conjonction de subordination */
    protected static final int PAUSE_LONGUE = Integer.parseInt(ConfigFile.rechercher("PAUSE_LONGUE"));
    /** La pause finale : pour le <i>'point final'</i> */
    protected static final int PAUSE_FIN = Integer.parseInt(ConfigFile.rechercher("PAUSE_FIN"));

    /**
     * Variables priv�es � l'objet
     */
    private int synt;            // le type de la phrase
    private int pause;           // la dur�e de la pause associ�e

    /** Constructeur de syntagme
     * @param s le type de syntagme que l'on souhaite cr�er (a choisir parmis les constantes)
     * @param d la dur�e de la pause associ�e (a choisir parmis les constantes)
     */
    public Syntagme(int s, int d) {
	synt =  s;
	pause = d;
    }

    /** Constructeur de Syntagme par d�faut.
     * <p><b>Remarque</b> : cr� un <code>Syntagme</code> au sens de <code>this(0,0)</code></p>
     */
    protected Syntagme() {
	this(0,0);
    }

    /** Pour r�cuperer le code repr�sentant la dur�e de la pause
     * @return l'entier ad'hoc
     */
    protected int dureePause() {
	return pause;
    }

    /** Pour d�terminer le type de syntagme final d'une phrase
     * @param ponctuation la ponctuation de cette phrase
     * @return le Syntagme qui va bien ^_^.
     */
    protected static Syntagme typeFin(int ponctuation) {
	Syntagme synt = new Syntagme();
	switch (ponctuation) {
	case (Phrase.VIRGULE ) : 
	    if (Random.negatif()) 
		synt =  new Syntagme(MINEUR, PAUSE_COURTE);
	    else  
		synt =  new Syntagme(MAJEUR, PAUSE_COURTE); 
	    break;
	case (Phrase.POINT): 
	    synt = new Syntagme(FIN, PAUSE_FIN);
	    break;
	case (Phrase.DEFAUT): 
	    synt = new Syntagme(FIN, PAUSE_FIN);
	    break;
	case (Phrase.INTERROGATION):
	    synt = new Syntagme(FIN_INTERRO, PAUSE_FIN);
	    break;
	case (Phrase.EXCLAMATION):
	    synt = new Syntagme(FIN_EXCLAM, PAUSE_FIN);
	    break;
	}
	return synt;
    }

    /** Pour d�terminer le type de syntagme de coupure en fonction du type de coupure % ou %%.
     * <p><b>Pr�condition</b> : ph contient au moins un % </p>
     * @param ph : une phrase 
     * @param coupure : l'indice dans ph du premier %
     * @return le Syntagme qui va bien ^_^.
     */
    protected static Syntagme type(String ph, int coupure) {
	if (ph.charAt(coupure+1) == '%') 
	    return new Syntagme(MINEUR,PAUSE_COURTE) ;
	else 
	    return new Syntagme(MAJEUR,PAUSE_LONGUE);
    }	


    /**
     * M�thode prot�g�es (aucune raison d'�tre � l'exterieur du package de prosodie) pour d�terminer les types de syntagme
     */
    
    /** Est-ce un syntagme final ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean fin() {
	return (FIN_INTERRO <= synt ) && (synt <= FIN_EXCLAM);
    }

    /** Est-ce un syntagme de fin d'exclamation ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean finExclam() {
	return  (synt == FIN_EXCLAM);
    }

    /** Est-ce un syntagme de fin d'interrogation ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean finInterro(){
	return  (synt == FIN_INTERRO);
    }

    /** Est-ce un syntagme de pause longue?
     * @return true si c'est le cas, false sinon
     */
    protected boolean longb() {
	return (pause == PAUSE_LONGUE);
    }

    /** Est-ce un syntagme de pause courte ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean court() {
	return (pause == PAUSE_COURTE);
    }

    /** Est-ce un syntagme mineur ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean mineur() {
	return (synt == MINEUR);
    }

    /** Est-ce un syntagme majeur ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean majeur() {
	return (synt == MAJEUR);
    }

}
