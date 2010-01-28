/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.sql.*;
import java.util.Vector;

/**
 * DAO pour accéder aux objets de type Reponse
 * @author nfloquet
 */
public class DAOUtilisateur extends DAO<Utilisateur> {

    /**
     * Constructeur de la classe
     * @param conn
     * Instance de connexion à la base de données
     * @throws SQLException
     */
    public DAOUtilisateur(Connection conn) throws SQLException {
        super(conn);
        boolean res = false;
        /* On vérifie si la table existe. Si elle n'existe pas, on la crée */

        try {
            res = (conn.getMetaData().getTables(null, null, "UTILISATEUR",
                    new String[]{"TABLE"}).next());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (res) {
            System.out.println("table exists");
        } else {
            System.out.println("table \"Utilisateur\" does not exist and is going to be created");

            /* Utilisateur (ID, login, password, terminal, date)*/
            String sCreation = "CREATE TABLE UTILISATEUR ( ID bigint generated by default as identity(start with 1 , increment by 1) not null ," + " login varchar(50) UNIQUE NOT NULL ," + " password varchar(50) NOT NULL ," + " terminal int ," + " date int " + ")   ";

            Statement statement = conn.createStatement();
            statement.execute(sCreation);
            System.out.println("Table created!");
        }
    }


    public boolean create(Utilisateur obj) {
        String sInsertion = "INSERT INTO UTILISATEUR (login, password, terminal) VALUES ("+
                            "'"+obj.getLogin()+"'"+","+
                            "'"+obj.getPassword()+"'"+","+
                            obj.getTerminal()+")";
        try{
            Statement statement = connect.createStatement();
            statement.execute(sInsertion);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }

        System.out.println("User creation done");
        return true;
    }

    public boolean delete(Utilisateur obj) {
        String sDeletion = "DELETE FROM UTILISATEUR WHERE login='"+obj.getLogin()+"'";
        try{
            Statement statement = connect.createStatement();
            statement.execute(sDeletion);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
        System.out.println("User delete done!");
        return true;
    }


    /**
     * Retourne un utilisateur en fonction de son login
     * @param login
     * Login de l'utilisateur recherché
     * @return
     * Utilisateur identifié
     */
    public Utilisateur find(String login) {
        String sSelect = "SELECT * FROM UTILISATEUR WHERE login='"+login+"'";
        ResultSet rs = null;
        Utilisateur user;
        try {
            Statement statement = connect.createStatement();
            statement.execute(sSelect);
            rs = statement.getResultSet();
            if(rs.next())
            {
                user = new Utilisateur(rs.getString("login"),
                                       rs.getString("password"),
                                       rs.getInt("terminal"));
                System.out.println("User found.");
            }
            else
            {
                System.out.println("User not found.");
                return null;
            }

            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return user;
    }
    
    public Utilisateur find(int id) {
        String sSelect = "SELECT * FROM UTILISATEUR WHERE ID='"+id+"'";
        ResultSet rs = null;
        Utilisateur user;
        try {
            Statement statement = connect.createStatement();
            statement.execute(sSelect);
            rs = statement.getResultSet();
            if(rs.next())
            {
                user = new Utilisateur(rs.getString("login"),
                                       rs.getString("password"),
                                       rs.getInt("terminal"));
                System.out.println("User found.");
            }
            else
            {
                System.out.println("User not found.");
                return null;
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return user;
    }

    /**
     * Retourne la liste de tous les utilisateurss
     * @return
     * Liste de tous les utilisateurs
     */
    public Vector<Utilisateur> findList(){
        Vector<Utilisateur> list = new Vector<Utilisateur>();

        String sSelect = "SELECT * FROM UTILISATEUR";
        ResultSet rs = null;
        try {
            Statement statement = connect.createStatement();
            statement.execute(sSelect);
            rs = statement.getResultSet();
            while (rs.next()) {
                list.add(new Utilisateur(rs.getString("login"),
                                       rs.getString("password"),
                                       rs.getInt("terminal")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public boolean update(Utilisateur obj) {
        String sUpdate = "UPDATE UTILISATEUR SET "+
                         "password='"+obj.getPassword()+"',"+
                         "terminal="+obj.getTerminal()+
                         "WHERE login='"+obj.getLogin()+"'";

        try{
        Statement statement = this.connect.createStatement();
        statement.execute(sUpdate);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        System.out.println("User update done!");
        //statement.execute(sInsertion);
        return true;
    }


}