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
            DAOUtilisateur acces_utilisateur =(DAOUtilisateur) DAOFactory.getDAOUtilisateur();
            DAOMission acces_mission = (DAOMission) DAOFactory.getDAOMission();

            acces_utilisateur.create(new Utilisateur("Robert", "azerty",5));
            Mission m1 = new Mission("Robert");

            /* Création des ordres */
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

            /* Configuration de la mission */
            m1.addOrdre(o1);
            m1.addOrdre(o2);
            m1.setEtat(Mission.etat_mission.EN_COURS);
            m1.setIdMission(0);
            m1.setIdOrdreCourant(1);
            m1.setPublie(true);

            /* Ajout de la mission dans la BDD */
            acces_mission.create(m1);

        }
        catch(Exception Ex)
        {
            Ex.printStackTrace();
        }
    }

}
