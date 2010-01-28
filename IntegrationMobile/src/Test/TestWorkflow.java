/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import GestionMobile.*;

/**
 *
 * @author Edith
 */
public class TestWorkflow {

    public static void main(String args[]) {

    	String path="";
    	
        Workflow w = new Workflow(path);

        int ordreSuivant = w.validationOrdre(1,"Non");

        System.out.println("Prochain ordre a executer :");
        System.out.println("-- Resultat attendu : 2 ");
        System.out.println("-- Resultat obtenu : "+ordreSuivant);

    }
}
