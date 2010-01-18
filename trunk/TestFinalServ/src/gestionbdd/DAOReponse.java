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
public class DAOReponse extends DAO<Reponse> {

    public DAOReponse(Connection conn){
        super(conn);
        boolean res = false;
        /* On vérifie si la table existe. Si elle n'existe pas, on la crée */

        try {
            res = (conn.getMetaData().getTables(null, null, "REPONSE",
                    new String[]{"TABLE"}).next());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (res) {
            System.out.println("table exists");
        } else {
            System.out.println("table \"Reponse\" does not exist and is going to be created");

            /* Utilisateur (ID, reponse, ordre_actuel, ordre_suivant)*/
            String sCreation = "CREATE TABLE REPONSE ( ID bigint not null,"
                                                   + " reponse varchar(50) NOT NULL ,"
                                                   + "ordre_actuel int NOT NULL,"
                                                   +" ordre_suivant int NOT NULL, "
                                                   +" PRIMARY KEY(ID,ordre_actuel))";

            try {
                Statement statement = conn.createStatement();
                statement.execute(sCreation);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Table created!");
        }
    }

    public boolean create(Reponse obj) {
       String sInsertion = "INSERT INTO REPONSE (ID ,reponse, ordre_actuel, ordre_suivant) VALUES ("+
                            obj.getIdReponse()+","+
                            "'"+obj.getReponse()+"',"+
                            +obj.getOrdreActuel()+","
                            +obj.getOrdreSuivant()+")";
        try{
            Statement statement = connect.createStatement();
            statement.execute(sInsertion);
        }
        catch (Exception ex){
            System.out.print("Response creation impossible");
            return false;
        }

        System.out.println("Response creation done");
        return true;
    }

    public boolean delete(Reponse obj) {
        String sDeletion = "DELETE FROM REPONSE WHERE ID="+obj.getIdReponse()+" AND ordre_actuel="+obj.getOrdreSuivant();
        try{
            Statement statement = connect.createStatement();
            statement.execute(sDeletion);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
        System.out.println("User delete done!");
        return true;
    }


    public Reponse find(int id) {
        return null;
    }

    public Vector<Reponse> findList(int idOrdre){
        Vector<Reponse> list = new Vector<Reponse>();

        String sSelect = "SELECT * FROM REPONSE WHERE ordre_actuel="+idOrdre;
        ResultSet rs = null;
        try {
            Statement statement = connect.createStatement();
            statement.execute(sSelect);
            rs = statement.getResultSet();
            while (rs.next()) {
                list.add(new Reponse(rs.getInt("ID"), rs.getString("reponse"),rs.getInt("ordre_actuel"), rs.getInt("ordre_suivant")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean update(Reponse obj) {
        String sUpdate = "UPDATE REPONSE SET " +
                "reponse='" + obj.getIdReponse() + "'," +
                "ordre_suivant=" + obj.getOrdreSuivant() +
                "WHERE ordre_actuel=" + obj.getOrdreActuel() +
                "AND " + "ID=" + obj.getIdReponse();

        try {
            Statement statement = this.connect.createStatement();
            statement.execute(sUpdate);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        System.out.println("Response update done!");
        //statement.execute(sInsertion);
        return true;
    }
}
