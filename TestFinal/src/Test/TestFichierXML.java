/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO_XML.XMLDAOFactory;
import GestionMobile.FichierXML;

/**
 *
 * @author Edith
 */
public class TestFichierXML {

    public static void main(String args[]) {

        XMLDAOFactory factory = new XMLDAOFactory();
        TestFichierXML test = new TestFichierXML();

        //test.testChoixPossibles(factory);
        test.testGetIdOrdreCourant(factory);

    }

    public void testChoixPossibles(XMLDAOFactory factory) {

        FichierXML fichier = new FichierXML("/My document/GRA2/");
        fichier.choixPossible(1);

    }

    public void testGetIdOrdreCourant(XMLDAOFactory factory){

        FichierXML fichier = new FichierXML("/My document/GRA2/");
        int o = fichier.getIdOrdreCourant();
        System.out.println("Ordre courant : "+o+" (resultat a verifier dans le fichier)");
    }
}
