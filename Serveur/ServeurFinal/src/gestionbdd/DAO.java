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
public abstract class DAO<T> {
    protected Connection connect;

    public DAO(Connection connect) {
        this.connect = connect;
    }

    public abstract T find(int id);

    public abstract boolean create(T obj);

    public abstract boolean update(T obj);

    public abstract boolean delete(T obj);

}
