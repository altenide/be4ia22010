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
public class DAOOrdre extends DAO<Ordre> {

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
                                                    + " etat boolean NOT NULL,"
                                                    + " dernierordre boolean NOT NULL,"
                                                    + " contenu varchar(256) NOT NULL,"
                                                    + " filename varchar(256) NOT NULL,"
                                                    +" PRIMARY KEY(ID,idmission))";

            Statement statement = conn.createStatement();
            statement.execute(sCreation);
            System.out.println("Table created!");
        }
    }

    public boolean create(Ordre obj) {
       String sInsertion = "INSERT INTO ORDRE (ID ,idmission ,etat, contenu, filename) VALUES ("
                            +obj.getIdOrdre()+","
                            +obj.getIdMission()+","
                            +obj.getEtat()+","
                            +"'"+obj.getContenu()+"',"
                            +"'"+obj.getFilename()+"')";
        DAOReponse acces_reponses =(DAOReponse) DAOFactory.getDAOReponse();

        try{
            Statement statement = connect.createStatement();
            statement.execute(sInsertion);
        }
        catch (Exception ex){
            System.out.print("Response creation impossible");
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
            ex.printStackTrace();
            return false;
        }

        /* On ajoute toutes les réponses associées à l'ordre */
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
                                       rs.getBoolean("dernierordre"));
                temp_ordre.setReponsesPossibles(acces_reponses.findList(temp_ordre.getIdOrdre()));
                list.add(temp_ordre);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public boolean update(Ordre obj) {
        return false;
    }


}
