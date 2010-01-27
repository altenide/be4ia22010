/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.sql.*;
import java.util.Vector;

/**
 * DAO pour accéder aux objets de type Ordre
 * @author nfloquet
 */
public class DAOOrdre extends DAO<Ordre> {

    /**
     * Constructeur de la classe
     * @param conn
     * Instance de connexion à la base de données
     * @throws SQLException
     */
    public DAOOrdre(Connection conn) throws SQLException {
        super(conn);
        boolean res = false;
        /* On vérifie si la table existe. Si elle n'existe pas, on la crée */

        try {
            res = (conn.getMetaData().getTables(null, null, "ORDRE",
                    new String[]{"TABLE"}).next());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (res) {
            System.out.println("table exists");
        } else {
            System.out.println("table \"Ordre\" does not exist and is going to be created");

            

            /* Ordre (ID, idmission, etat, dernierordre contenu, filename)*/
            String sCreation = "CREATE TABLE ORDRE ( ID bigint not null,"
                                                    + " idmission integer NOT NULL,"
                                                    + " etat varchar(8) NOT NULL,"
                                                    + " dernierordre varchar(8) NOT NULL,"
                                                    + " contenu varchar(256) NOT NULL,"
                                                    + " filename varchar(256) NOT NULL,"
                                                    +" PRIMARY KEY(ID,idmission))";

            Statement statement = conn.createStatement();
            statement.execute(sCreation);
            System.out.println("Table created!");
        }
    }

    public boolean create(Ordre obj) {
       String sInsertion = "INSERT INTO ORDRE (ID ,idmission ,etat ,dernierordre ,contenu ,filename) VALUES ("
                            +obj.getIdOrdre()+","
                            +obj.getIdMission()+","
                            +"'"+Boolean.toString(obj.getEtat())+"',"
                            +"'"+Boolean.toString(obj.isDernierOrdre())+"',"
                            +"'"+obj.getContenu()+"',"
                            +"'"+obj.getFilename()+"')";
        DAOReponse acces_reponses =(DAOReponse) DAOFactory.getDAOReponse();

        try{
            Statement statement = connect.createStatement();
            statement.execute(sInsertion);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }

        /* On ajoute toutes les réponses associées à l'ordre */
        for(int i=0; i<obj.getReponsesPossibles().size(); i++)
        {
            acces_reponses.create(obj.getReponsesPossibles().get(i));
        }

        System.out.println("Ordre creation done");
        return true;
    }

    public boolean delete(Ordre obj) {
        String sDeletion = "DELETE FROM ORDRE WHERE ID="+obj.getIdOrdre()+" AND idmission="+obj.getIdMission();
        DAOReponse acces_reponses =(DAOReponse) DAOFactory.getDAOReponse();

        try{
            Statement statement = connect.createStatement();
            statement.execute(sDeletion);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }

        /* On supprime toutes les réponses associées à l'ordre */
        for(int i=0; i<obj.getReponsesPossibles().size(); i++)
        {
            acces_reponses.delete(obj.getReponsesPossibles().get(i));
        }

        System.out.println("Ordre delete done!");
        return true;
    }

    public Ordre find(int id) {
        return null;
    }

    /**
     * Retourne la liste des Ordres identifiés par une mission
     * @param idmission
     * Id de la mission identifiant les ordres
     * @return
     */
    public Vector<Ordre> findList(int idmission){
        Vector<Ordre> list = new Vector<Ordre>();
        Ordre temp_ordre = null;
        DAOReponse acces_reponses =(DAOReponse) DAOFactory.getDAOReponse();


        String sSelect = "SELECT * FROM ORDRE WHERE idmission="+idmission;
        ResultSet rs = null;
        try {
            Statement statement = connect.createStatement();
            statement.execute(sSelect);
            rs = statement.getResultSet();
            while (rs.next()) {
                temp_ordre = new Ordre(rs.getInt("ID"),
                                       rs.getInt("idmission"),
                                       rs.getString("contenu"),
                                       Boolean.valueOf(rs.getString("dernierordre")));
                temp_ordre.setFilename(rs.getString("filename"));
                temp_ordre.setReponsesPossibles(acces_reponses.findList(temp_ordre.getIdOrdre()));
                list.add(temp_ordre);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    public boolean update(Ordre obj) {
          String sUpdate = "UPDATE ORDRE SET " +
                "contenu='" + obj.getContenu() + "'," +
                "filename='" + obj.getFilename() + "'," +
                "etat=" + obj.getEtat() + "," +
                "dernierordre=" + obj.isDernierOrdre() +
                "WHERE idmission=" + obj.getIdMission() +
                "AND " + "ID=" + obj.getIdOrdre();
         DAOReponse acces_reponses =(DAOReponse) DAOFactory.getDAOReponse();

        try {
            Statement statement = this.connect.createStatement();
            statement.execute(sUpdate);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        /* On met à jour toutes les réponses associées à l'ordre */
        for(int i=0; i<obj.getReponsesPossibles().size(); i++)
        {
            acces_reponses.update(obj.getReponsesPossibles().get(i));
        }

        System.out.println("Ordre update done!");
        //statement.execute(sInsertion);
        return true;
    }
    


}
