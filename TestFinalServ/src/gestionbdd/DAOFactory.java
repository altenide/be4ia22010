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
public class DAOFactory {
    protected static final Connection conn = BDDConnexion.getInstance().getConnexion();

    public static DAO getDAOMission(){
        return new DAOMission(conn);
    }

    /*public static DAO getDAOOrdre  throws SQLException (){
        return new DAOOrdre(conn);
    }*/

    public static DAO getDAOReponse(){
        return new DAOReponse(conn);
    }

    public static DAO getDAOUtilisateur()  throws SQLException {
        return new DAOUtilisateur(conn);
    }

}
