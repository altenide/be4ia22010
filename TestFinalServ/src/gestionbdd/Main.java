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
            DAOReponse reponse =(DAOReponse) DAOFactory.getDAOReponse();
            reponse.create(new Reponse(0,"Ok",0,1));
            reponse.create(new Reponse(1,"Pas ok",0,2));
            reponse.create(new Reponse(2,"Repeter",0,0));
            Vector<Reponse> liste = reponse.findList(0);
            System.out.println(liste.size());


        }
        catch(Exception Ex)
        {
            Ex.printStackTrace();
        }
    }

}
