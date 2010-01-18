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

    public DAOMission(Connection conn){
        super(conn);
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
