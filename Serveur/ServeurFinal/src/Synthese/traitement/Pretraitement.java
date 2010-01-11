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

import Synthese.util.*;

/** Pour traiter un texte et le transformer en phrases
 */
public class Pretraitement {

    // constantes pour les nombres
    private static final int MILLIARD = 1000000000;
    private static final int MILLION = 1000000;
    private static final int MILLE = 1000;
    private static final int CENT = 100;
    private static final String[] nombre = {
	"", "un", "deux", "trois",
	"quatre", "cinq", "six", "sept", "huit", "neuf",
	"dix", "onze", "douze", "treize", "quatorze",
	"quinze", "seize", "dix_sept", "dix_huit",
	"dix_neuf"};
    private static final String[] dizaine = {
	"", "", "vingt", "trente", "quarante", "cinquante",
	"soixante", "", "quatre_vingt",
	""};

    private String texte; //texte a lire

    /** Constructeur par d�faut de pr�-traitement.
     * <p> <b>Remarque</b> : Si la chaine <code>txt</code> ne finit pas par un caract�re de coupure (<i>ponctuation</i>), on rajoute un <code>'.'</code>
     * de chaine.</p>
     * @param txt la chaine de caract�res � pr� - traiter
     */
    public Pretraitement(String txt) {
	this.texte = txt;
	if(!texte.equals("") && !estCoupure(texte.charAt(texte.length()-1)))
	    texte+=".";
    }

    /** Pour prendre une nouvelle <code>Phrase</code> dans le texte pr�sent dans <code>this</code>
     * <p><b>Remarque</b> : Par effet de bord, on avance (sans espoir de retour) dans le texte pr�-trait�.</p>
     * @return une instance de <code>Phrase</code> contenant les informations lue dans le texte.
     * @throws PlusDePhraseException
     */
    public Phrase nouvellePhrase() throws PlusDePhraseException {

	if (texte.equals(""))
	    throw new PlusDePhraseException();

	Phrase p = traiter();

	if (p == null)
	    throw new PlusDePhraseException();
	return p;
    }
    

    /**
     * M�thodes priv�es ... (m�nage effectu� dans les scopes ^_^)
     */

    /** Pour pr�-traiter le texte pr�sent dans this.
     * <p><b>Pr�-traitement</b> : il faut rajouter le traitement des symboles bizarres...
     * <p><ul>
     *   <li> on enleve les majuscules </li>
     *   <li> on transforme les nombres</li>
     *   <li> On transforme les <code>' '</code> en <code>'_'</code>.
     * </ul></p>
     *  @return   Une instance de <code>Phrase</code> relative au texte pr�-trait� (texte + type de prosodie a appliquer), 
     *            ou <code>null</code> si on ne peut rien faire.
     */
    private Phrase traiter() {
	int i = 0;
	String res = "";
	char tete = texte.charAt(i);
	while (i < texte.length() && !estCoupure(tete)) {

	    if (Character.isUpperCase(tete)) { //on traite les majuscules
		Indice in = new Indice(i);
		String a = abbrev(texte,in);
		if (a.length()>0) {
		    // abbr�viation, a contient le nombre de caract�res
		    res+= a;
		    i = in.val();
		} 
		else {
		    res += Character.toLowerCase(tete);
		    i++;
		}
	    }
	    else if ((tete == ' ') || (tete == '\n')) { // espace --> '_'
		if (!res.equals("") && res.charAt(res.length() - 1) != '_')
		    res += '_';
		i++;
	    }
	    else if (tete == '-') {
		res += '_';
		i++;
	    }
	    else if (estSpecial(tete)) { // caract�re sp�cial
		res += special(tete);
		i++;
	    }
	    else if (estChiffre(tete)) { // les chiffres
		Indice ind = new Indice(i);
		res += traiterLesChiffres(texte,ind);
		i = ind.val();
		if (i < texte.length()) 
		    tete = texte.charAt(i);
	    }
	    else if (estLettre(tete)) { // on copie la lettre 
		res += tete;
		i++;
	    }
	    else { // on est sur un caract�re non trait�
		res += '_';
		System.out.println("SI_VOX WARNING [Pretraitement.traiter] : le caract�re '" + tete + "' � �t� ignor� !");
		i++;
	    }
	    if (i < texte.length())
		tete = texte.charAt(i);
	}
	//on arrive ici pour chaque caract�re de coupure ou quand on est a la fin du texte
	if (estCoupure(tete)) {
	    while(i < texte.length() && estCoupure(texte.charAt(i)))
		i++;

	    if (!res.equals("")) {
		if (res.charAt(0) != '_')
		    res = "_" + res;
		if (res.charAt(res.length() - 1) != '_')
		    res += "_"; 
		if (i < texte.length())
		    texte = texte.substring(i);
		else
		    texte = "";
		return new Phrase(res, prosodie(tete));
	    }
	    if (i < texte.length())
		texte = texte.substring(i);
	    else
		texte = "";
	    return new Phrase("_", prosodie(tete));
	}
	return null;
    }

    /** Lit une suite de chiffres �ventuellement s�par�s par une virgule
     * Pr�condition :
     *        texte[i.val()] est un chiffre
     * Postcondition : 
     *        texte[i.val()] n'est pas un chiffre 
     */
    private String traiterLesChiffres(String texte,  Indice ind) {
	int lg = texte.length();
	// on traite la partie enti�re
	String nbr = lireNombre(texte,ind);
	String res = traiterNombre(nbr, false);
	String ordinal = ordinal(texte, ind);
	if (ordinal.length() > 0) 
	    if (ordinal.charAt(1) == 'p') 
		res = ordinal; // premier et premi�re
	    else res += ordinal;
	else {
	    if (ind.val() < lg) {
		char tete = texte.charAt(ind.val());
		// on regarde s'il y a une virgule
		if (estVirgule(tete)|| estHeure(tete)) {
		    int iSuiv = ind.val() + 1;
		    if (iSuiv < lg && estChiffre(texte.charAt(iSuiv))) {
			res += estVirgule(tete) ? "_virgule_" : "_heure_";
			ind.inc();
			nbr = lireNombre(texte,ind);
			res += traiterNombre(nbr, true);
		    }
		}
	    }
	}
	return res;
    }

    /** Lit tous les caract�res du nombre jusqu'� la virgule ou un autre caract�re
     * Pr�condition :
     *        texte[i.val()] est un chiffre
     * Postcondition : 
     *        texte[i.val()] n'est pas un chiffre
     */
    private String lireNombre(String texte,  Indice i) {
	String nbr = "";
	int lg = texte.length();
	char tete = texte.charAt(i.val());
	while (i.val() < lg && estChiffre(tete)) {
	    nbr += tete;
	    i.inc();
	    if (i.val() < lg) tete = texte.charAt(i.val());
        }
	return nbr;
    }


    /**Pour traiter un nombre.
     * <p><center><code>12 |--> douze</code></center></p>
     * <p><b>Remarque</b>: On ne g�re pas le f�minin (et puis quoi encore ??) </p>
     * @param nbr une chaine de caract�re repr�sentant un nombre
     * @param decimal un bool�en pour savoir si l'on doit prononcer les '0'.
     * @return une chaine de caract�re contenant le nombre sous sa forme textuelle.
     */
    private String traiterNombre(String nbr, boolean decimal) {
	String res = "";
	if (decimal) {
	    //on doit dire les zeros
	    while (nbr.charAt(0) == '0') {
		res += "z�ro_";
		nbr = nbr.substring(1);
	    }
	}
	try {
	    int nombre = (new Integer(nbr)).intValue();
	    if (nombre == 0)
		return "z�ro";
	    int milliard = nombre / MILLIARD;
	    nombre = nombre % MILLIARD;
	    int million = nombre / MILLION;
	    nombre = nombre % MILLION;
	    int mille = nombre / MILLE;
	    nombre = nombre % MILLE; //le reste

	    if (milliard != 0)
		res += traiterNombre(milliard) + "_milliard_";
	    if (million != 0)
		res += traiterNombre(million) + "_million_";
	    if (mille != 0) {
		if (mille != 1)
		    res += traiterNombre(mille) + "_mille_";
		else
		    res += "_mille_";
	    }
	    res += traiterNombre(nombre);

	    return res;
	}
	catch (Exception e) {
	    System.out.println("SI_VOX WARNING [Pretraitement.traiterNombre] : Erreur !");
	    System.out.println(e);
	}

	return res += pasTraiterNombre(nbr);
    }

    /** Pour ne pas traiter un nombre
     * @param nbr la chaine de caract�re repr�sentant le nombre � ne pas traiter
     */

    private String pasTraiterNombre(String nbr){
	String res="";
	int i=0;
	int n;
	while(i<nbr.length()){
	    n=(new Integer(""+nbr.charAt(i))).intValue();
	    res+=nombre[n]+"_";
	    i++;
	}
	return res;
    }
    

    /** Pour transformer un nombre en chaine de caract�re.
     * @param n l'entier que l'on veut transformer
     * @return la chaine de caract�re qui va bien.
     */
    private String traiterNombre(int n) {
	String res = "";
	int cent = n / CENT;
	if (cent != 0) {
	    if (cent != 1)
		res += nombre[cent] + "_cent_";
	    else
		res += "_cent_";
	}
	n = n % CENT; //le reste entre 0 et 99
	if (n >= 0 && n <= 19)
	    res += nombre[n];
	else { //entre 20 et 99
	    if ( (n >= 70 && n <= 79) || (n >= 90 && n <= 99)) {
		res += dizaine[n / 10 - 1];
		res += "_";
		res += nombre[n % 10 + 10];
	    }
	    else {
		res += dizaine[n / 10];
		if (n % 10 != 0)
		    res += "_";
		res += nombre[n % 10];
	    }
	}
	return res;
    }

    /** Pour traiter le cas des ordinaux 
     * Pr�condition :
     *       i est le 1er caract�re de s qui n'est pas un chiffre
     * Remarque : 
     *       On effectue les tests sur une chaine en UTF-8 [ Transposition ISO-8859-1 --> UTF-8 ].
     * @param s la chaine � transformer
     * @param i un Indice
     * @return renvoi le texte '_premier', '_iaime', '_premiaire' ou la chaine vide
     */
    private String ordinal(String s, Indice i) {
	String fin = encode(s.substring(i.val()),ConfigFile.rechercher("ENCODAGE_FICHIER"),"UTF-8");
	if (fin.length() >= 2) {
	    if (fin.substring(0,2).equals("er")){
		i.inc(2);
		return "_premier";
	    }
	    if (fin.substring(0,3).equals("�me")){
		i.inc(3);
		return "_iaime";
	    }
	    if (fin.substring(0,3).equals("�re")){
		i.inc(3);
		return "_premiaire";
	    }
	}
	return "";
    }
	
    /** Pour determiner si un caract�re est la chaine vide
     * @param c le caract�re � tester.
     * @return true si c est un c est un caract�re de coupure {, . ; : ! ? parenth�ses}
     */
    private boolean estCoupure(char c) {
	return c == ',' || c == '.' || c == ';' || c == ':' || c == '!' || c == '?' 
	    || estParenthese(c);
    }

    /** Pour determiner si un caract�re est un caract�re sp�cial
     * @param c le caract�re � tester
     * @return true si c est un caract�re sp�cial {% " @ � monnaie}
     */
    private boolean estSpecial(char c) {
	return c == '%' || c == '&' ||  c == '"' || c == '@'|| c == '�'
	    || estMonnaie(c) ;
    }

    /** Pour d�terminer si un caract�re est une parenth�se 
     * @param c le caract�re � tester
     * @return true si c est un caract�re de parenth�sage, ie (, ), {, }, [, ] ou "
     */
    private boolean estParenthese(char c) {
	return c == '(' || c == ')' ||  c == '{' ||  c == '}' 
	    ||  c == '[' ||  c == ']' || c == '"';
    }

    /** Pour d�terminer si un caract�re est une virgule
     * @param c le charact�re � tester
     * @return true si c est un caract�re de 'virgule' {, .}
     */
    private boolean estVirgule(char c) {
	return c == ',' || c == '.';
    }

    /** Pour determiner si on est sur le tag de repr�sentation usuel des heures ('h')
     * @param c le caract�re � tester
     * @return true si <code>c == 'h'</code>, false sinon.
     */
    private boolean estHeure(char c) {
	return c == 'h' ;
    }

    /** Pour transformer un caract�re sp�cial en chaine de caract�re
     * @param c le caract�re � transformer
     * @return la chaine de caract�re qui va bien ^_^
     */
    private String special(char c){
	if (estMonnaie(c)) return monnaie(c);
	switch(c){
	case '&': return "_et_";
	case '%': return "_pour_cent_";
	case '@': return "_arobase_"; 
	case '�': return "_copirailt_";
	}
	return "";
    }
  
    /** Pour determiner si un caract�re est un tag de monnaie
     * @param c le caract�re � tester
     * @return true si c est un caract�re de monnaie {$, � ou \200} (\200 == euros)
     */
    private boolean estMonnaie(char c) {
	return c == '$' || c == '�' || c == '�';
    }

    /** Pour prononcer un carcat�re de monnaie
     * @param c le caract�re � prononcer
     * @return la chaine de caract�re correspondant au symbole de la monnaie.
     */
    private String monnaie(char c){
	switch(c){
	case '$':return "_dollar_";
	case '�':return "_livre_sterling_";
	default:  return "";
	}
    }

    /** Pour determiner si un caract�re est une lettre
     * @param c le caract�re � tester
     * @return true si c est une lettre au sens de <code>Character.isLetter(char)</code> ou si c == '
     */
    private boolean estLettre(char c) {
	return (Character.isLetter(c) || c == '\'');
    }

    /** Renvoie une chaine contenant la traduction des abr�viations qui commencent sur texte[i]
     * renvoie "" si pas d'abr�viation
     * Pr�condition :  : texte[i] est une majuscule
     */
    private String abbrev(String texte, Indice i) {
	int l = texte.length();
	String res = "";
	String s = "";
	int ii = i.val();
	// on a au moins 3 caract�res
	if (l-ii>=2) {
	    s = texte.substring(ii,ii+2);
	    if (s.equals("M.")) {res = "_monsieur_";i.inc(2);}
	}
	if (l-ii>=4) {
	    s = texte.substring(ii,ii+4);
	    if (s.equals("Mme.")) {res = "_madame_";i.inc(4);}
	}
	if (l-i.val()>=5) {
	    s = texte.substring(ii,ii+5);
	    if (s.equals("Mlle.")) {res = "_mademoiselle_";i.inc(5);}
	}
	return res;
    }


 
    /** Pour r�cuperer la prosodie � appliquer � cette phrase
     * @param c un caract�re de ponctuation
     * @return l'entier correspondant, a la prosodie li�e au caract�re de coupure.
     */
    private int prosodie(char c) {
	if (estParenthese(c)) 
	    return Phrase.VIRGULE; 
	else 
	    switch (c) {
	    case ',':
		return Phrase.VIRGULE;
	    case ';':
		return Phrase.VIRGULE;
	    case '.':
		return Phrase.POINT;
	    case '!':
		return Phrase.EXCLAMATION;
	    case '?':
		return Phrase.INTERROGATION;
	    default:
		return Phrase.DEFAUT;
	    }
    }

    /** Pour savoir si un caract�re est un chiffre
     * @param c le caract�re � tester
     * @returntrue si c est un chiffre, false sinon
     */
    private boolean estChiffre(char c) {
	return c >= 48 && c <= 57;
    }

    /** Transcodage d'une chaine de caract�re d'un charset vers un autre
     * @param s la chaine de caract�re a transcoder
     * @param cs1 le charset initial
     * @param cs2 le charset voulu
     * @return une chaine de caract�re contenant <code>s<code> transcod�e selon <code>cs2</code>
     */
    private static String encode(String s, String cs1, String cs2) {
	String res = "";
	try {
	    byte[] b = s.getBytes(cs1);
	    res = new String(b,cs2);
	}
	catch (Exception e) { 
	    System.out.println("SI_VOX WARNING [Pretraitement.encode] : Erreur d'encodage pour la chaine \n" + s);
	}
	return res;
    }

}
