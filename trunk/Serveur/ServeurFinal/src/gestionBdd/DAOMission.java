/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbdd;

import java.sql.*;
import java.util.Vector;

/**
 *
 * @author nfloquet
 */
public class DAOMission extends DAO<Mission> {

    public DAOMission(Connection conn) throws SQLException {
        super(conn);
        boolean res = false;
        /* On vérifie si la table existe. Si elle n'existe pas, on la crée */

        try {
            res = (conn.getMetaData().getTables(null, null, "MISSION",
                    new String[]{"TABLE"}).next());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (res) {
            System.out.println("table exists");
        } else {
            System.out.println("table \"Mission\" does not exist and is going to be created");

            /* MISSION (ID, idmission, etat, dernierMISSION contenu, filename)*/
            String sCreation = "CREATE TABLE MISSION ( ID int not null,"
                    + " etat varchar(16) NOT NULL,"
                    + " idOrdreCourant int NOT NULL,"
                    + " utilisateur varchar(256) NOT NULL,"
                    + " publie varchar(8) NOT NULL,"
                    + " PRIMARY KEY(ID))";


            Statement statement = conn.createStatement();
            statement.execute(sCreation);
            System.out.println("Table created!");
        }
    }

    public boolean create(Mission obj) {
        String etat;
        DAOOrdre acces_ordres;

        if (obj.getEtat() == Mission.etat_mission.EN_COURS) {
            etat = new String("EN_COURS");
        } else if (obj.getEtat() == Mission.etat_mission.EN_ATTENTE) {
            etat = new String("EN_ATTENTE");
        } else {
            etat = new String("TERMINEE");
        }

        String sInsertion = "INSERT INTO MISSION (ID ,etat ,idOrdreCourant ,utilisateur ,publie) VALUES ("
                + obj.getIdMission() + ","
                + "'" + etat + "',"
                + obj.getIdOrdreCourant() + ","
                + "'" + obj.getUtilisateur() + "',"
                + "'" + Boolean.toString(obj.isPublie()) + "')";
        try {
            acces_ordres = (DAOOrdre) DAOFactory.getDAOOrdre();
            Statement statement = connect.createStatement();
            statement.execute(sInsertion);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        /* On ajoute toutes les ordres associées à la mission */
        for (int i = 0; i < obj.getListOrdres().size(); i++) {
            acces_ordres.create(obj.getListOrdres().get(i));
        }

        System.out.println("Mission creation done");
        return true;
    }

    public boolean delete(Mission obj) {
        String sDeletion = "DELETE FROM MISSION WHERE ID="+obj.getIdMission();
        DAOOrdre acces_ordres;

        try{
            acces_ordres = (DAOOrdre) DAOFactory.getDAOOrdre();
            Statement statement = connect.createStatement();
            statement.execute(sDeletion);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }

        /* On supprime toutes les réponses associées à l'ordre */
        for(int i=0; i<obj.getListOrdres().size(); i++)
        {
            acces_ordres.delete(obj.getListOrdres().get(i));
        }

        System.out.println("Mission delete done!");
        return true;
    }

    public Mission find(int id) {
        Mission temp_mission = null;
        DAOOrdre acces_ordres;

        String sSelect = "SELECT * FROM MISSION WHERE ID="+ id;
        ResultSet rs = null;
        try {
            acces_ordres = (DAOOrdre) DAOFactory.getDAOOrdre();
            Statement statement = connect.createStatement();
            statement.execute(sSelect);
            rs = statement.getResultSet();
            rs.next();

            temp_mission = new Mission(rs.getString("utilisateur"));
            temp_mission.setEtat(Mission.etat_mission.valueOf(rs.getString("etat")));
            temp_mission.setIdMission(rs.getInt("ID"));
            temp_mission.setIdOrdreCourant(rs.getInt("idOrdreCourant"));
            temp_mission.setListOrdres(acces_ordres.findList(temp_mission.getIdMission()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return temp_mission;
    }

    public Vector<Mission> findListFromUser(String user) {

        Vector<Mission> list = new Vector<Mission>();
        Mission temp_mission = null;
        DAOOrdre acces_ordres;

        String sSelect = "SELECT * FROM MISSION WHERE utilisateur='" + user + "'";
        ResultSet rs = null;
        try {
            acces_ordres = (DAOOrdre) DAOFactory.getDAOOrdre();
            Statement statement = connect.createStatement();
            statement.execute(sSelect);
            rs = statement.getResultSet();
            while (rs.next()) {

                temp_mission = new Mission(rs.getString("utilisateur"));
                temp_mission.setEtat(Mission.etat_mission.valueOf(rs.getString("etat")));
                temp_mission.setIdMission(rs.getInt("ID"));
                temp_mission.setIdOrdreCourant(rs.getInt("idOrdreCourant"));
                temp_mission.setListOrdres(acces_ordres.findList(temp_mission.getIdMission()));

                list.add(temp_mission);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public Vector<Mission> findListAll() {

        Vector<Mission> list = new Vector<Mission>();
        Mission temp_mission = null;
        DAOOrdre acces_ordres;

        String sSelect = "SELECT * FROM MISSION";
        ResultSet rs = null;
        try {
            acces_ordres = (DAOOrdre) DAOFactory.getDAOOrdre();
            Statement statement = connect.createStatement();
            statement.execute(sSelect);
            rs = statement.getResultSet();
            while (rs.next()) {

                temp_mission = new Mission(rs.getString("utilisateur"));
                temp_mission.setEtat(Mission.etat_mission.valueOf(rs.getString("etat")));
                temp_mission.setIdMission(rs.getInt("ID"));
                temp_mission.setIdOrdreCourant(rs.getInt("idOrdreCourant"));
                temp_mission.setListOrdres(acces_ordres.findList(temp_mission.getIdMission()));

                list.add(temp_mission);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public boolean update(Mission obj) {
        return false;
    }
}
