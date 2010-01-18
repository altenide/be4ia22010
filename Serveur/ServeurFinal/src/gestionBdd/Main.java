/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.util.Vector;

/**
 *
 * @author nfloquet
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BDDConnexion.getInstance().Connect("jdbc:derby://localhost:1527/", "pouet", "pouet", "pouet");
        try
        {
            DAOUtilisateur user =(DAOUtilisateur) DAOFactory.getDAOUtilisateur();
            DAOOrdre acces_ordre =(DAOOrdre) DAOFactory.getDAOOrdre();

           // user.create(new Utilisateur("Robert", "azerty",5));

            Ordre o1 = new Ordre(1,1,"Aller faire les courses",false);
            Ordre o2 = new Ordre(2,1,"Aller faire le ménage",false);
            o1.addReponse(new Reponse(0,"Courses faites",1,2));
            o1.addReponse(new Reponse(1,"Repeter",1,1));
            o1.addReponse(new Reponse(2,"Impossible",1,0));
            o1.setFilename("o1.wav");

            o2.addReponse(new Reponse(0,"Menage fait",2,2));
            o2.addReponse(new Reponse(1,"Repeter",2,1));
            o2.addReponse(new Reponse(2,"Impossible",2,0));
            o2.setFilename("o2.wav");
//            reponse.create(new Reponse(0,"Ok",0,1));
//            reponse.create(new Reponse(1,"Pas ok",0,2));
//            reponse.create(new Reponse(2,"Repeter",0,0));
//            Vector<Reponse> liste = reponse.findList(0);
            System.out.println("ajout o1 dans la bdd:");
            acces_ordre.create(o1);
            System.out.println("ajout o2 dans la bdd:");
            acces_ordre.create(o2);
            
           // System.out.println(liste.size());


        }
        catch(Exception Ex)
        {
            Ex.printStackTrace();
        }
    }

}
