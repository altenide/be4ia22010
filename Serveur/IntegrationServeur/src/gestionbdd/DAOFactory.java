/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.sql.*;

/**
 * Factory permettant de récuperer les DAO pour chaque objet
 * @author nfloquet
 */
public class DAOFactory {
    /**
     * Instance de la connection utilisée pour accéder à la base de données
     */
    protected static final Connection conn = BDDConnexion.getInstance().getConnexion();

    /**
     * Retourne un DAO pour objet de type Mission
     * @return Objet de type Mission
     * @throws SQLException
     */
    public static DAO getDAOMission() throws SQLException{
        return new DAOMission(conn);
    }

    /**
     * Retourne un DAO pour objet de type Ordre
     * @return Objet de type Ordre
     * @throws SQLException
     */
    public static DAO getDAOOrdre() throws SQLException {
        return new DAOOrdre(conn);
    }

    /**
     * Retourne un DAO pour objet de type Reponse
     * @return Objet de type Reponse
     */
    public static DAO getDAOReponse(){
        return new DAOReponse(conn);
    }

    /**
     * Retourne un DAO pour objet de type Utilisateur
     * @return Objet de type Utilisateur
     * @throws SQLException
     */
    public static DAO getDAOUtilisateur()  throws SQLException {
        return new DAOUtilisateur(conn);
    }

}
