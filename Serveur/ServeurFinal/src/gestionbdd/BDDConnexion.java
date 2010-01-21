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
public class BDDConnexion {

    static class NotConnected extends Exception{};

    private Connection conn =null;
    private static BDDConnexion instance = null;

    public BDDConnexion(){
        /* TODO Etablire la connection */
    }


    /* Passe à BDDConnection l'adresse, le nom de la bdd, le login et le password */    
    public void Connect(String address, String name, String login, String password){
        try {
            // Load the JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            // connect to the DBMS and database, using an authorized user name and password
            this.conn = DriverManager.getConnection(address + name, login, password);
            this.conn.setAutoCommit(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

    }

    public Connection getConnexion(){
          return conn;
    }

    public static BDDConnexion getInstance(){
        if(instance == null){
            instance = new BDDConnexion();
        }
        return instance;
    }
}
