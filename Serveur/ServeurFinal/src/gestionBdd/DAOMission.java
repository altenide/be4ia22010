/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.sql.*;

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
                                                    + " etat varchar(8) NOT NULL,"
                                                    + " idOrdreCourant int NOT NULL,"
                                                    + " utilisateur varchar(256) NOT NULL,"
                                                    + " publie varchar(8) NOT NULL,"
                                                    +" PRIMARY KEY(ID))";


            Statement statement = conn.createStatement();
            statement.execute(sCreation);
            System.out.println("Table created!");
        }
    }

    public boolean create(Mission obj) {
        return false;
    }

    public boolean delete(Mission obj) {
        return false;
    }

    public Mission find(int id) {
        return null;
    }

    public boolean update(Mission obj) {
        return false;
    }


}
