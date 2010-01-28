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


/** Une classe permettant la gestion des indices dans les chaines de caract�res
 */
public class Indice {
    // L'indice courant
    private int indice;

    /** Construit une instance d'Indice suivant le param�tre fourni
     * @param i le num�ro de l'indice voulu
     */
    public Indice(int i) {
	indice = i;
    }

    /** Construit une instance d'indice initialis� � 0
     */
    public Indice() {
	this(0);
    }

    /** Incr�mente l'indice d'un facteur donn�
     * @param i le facteur en question
     */
    public void inc(int i) {
	indice+=i;
    }

    /** Incr�mente l'indice d'un facteur 1
     */
    public void inc() {
	indice++;
    }

    /** Pour avoir la valeur courante de l'indice
     * @return la valeur courante stock� dans l'instance
     */
    public int val() {
	return indice;
    }
    
    /** Pour mettre � jour la valeur stock�e dans l'Indice
     * @param i la nouvelle valeur
     */
    public void val(int i) {
	indice = i;
    }

    /** Teste l'�galit� entre l'indice courant et le param�tre
     * @param i la valeur � tester
     * @return true si �galit�, false sinon
     */
    public boolean egal(int i) {
	return indice == i;
    }

    /** Teste la sup�riorit� stricte pour l'indice courant et le param�tre
     * @param i le param�tree � tester
     * @return true si <code>courant > i</code>, false sinon
     */
    public boolean plusGrand(int i) {
	return indice > i;
    }

    /** Teste la sup�riorit� au sens large pour l'indice courant et le param�tre
     * @param i le param�tree � tester
     * @return true si <code>courant >= i</code>, false sinon
     */
    public boolean grandOuEgal(int i) {
	return indice >= i;
    }

    /** Pour afficher une instance d'indice
     * @return une chaine de caract�res repr�sentant l'indice
     */
    public String toString() {
	return " " + indice + " ";
    }
}
