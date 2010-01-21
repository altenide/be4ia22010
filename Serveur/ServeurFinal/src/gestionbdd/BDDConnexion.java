/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.sql.*;

/**
 * Singleton gerant la connexion à la base de données JavaDB
 * @author nfloquet
 */
public class BDDConnexion {

    static class NotConnected extends Exception{};

    private Connection conn =null;
    private static BDDConnexion instance = null;

    /**
     * Constructeur par défaut.
     */  
    public BDDConnexion(){
    }


 
    /**
     * Passe à BDDConnection l'adresse, le nom de la bdd, le login et le password
     * et établi la connexion avec le serveur Derby
     * @param address
     * Adresse du serveur
     * @param name
     * Nom de la base de données sur le serveur
     * @param login
     * Identifiant de connexion à la base de données
     * @param password
     * Mot de passe pour la connexion à la base de donnes
     */
    public void Connect(String address, String name, String login, String password){
        try {
            // Charge le driver JDBC
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            // Connexion à la base de données
            this.conn = DriverManager.getConnection(address + name, login, password);
            this.conn.setAutoCommit(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }

    }

    /**
     * Retourne la connexion au serveur
     * @return
     * Objet de connexion au serveur
     */
    public Connection getConnexion(){
          return conn;
    }

    /**
     * Retourne l'instance de BDDConnexion
     * @return
     * L'instance de BDDConnexion
     */
    public static BDDConnexion getInstance(){
        if(instance == null){
            instance = new BDDConnexion();
        }
        return instance;
    }
}
