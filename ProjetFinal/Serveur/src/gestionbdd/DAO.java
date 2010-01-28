/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

import java.sql.*;
/**
 * Classe abstraite permettant d'accéder à un objet dans une base de donnée
 * @param <T>
 * Type de l'objet auquel on souhaite accéder
 * @author nfloquet
 */
public abstract class DAO<T> {
    /**
     * Instance de la connection utilisée pour accéder à la base de données
     */
    protected Connection connect;

    /**
     * Constructeur de la classe
     * @param connect
     * Instance de la connection utilisée pour accéder à la base de données
     */
    public DAO(Connection connect) {
        this.connect = connect;
    }

    /**
     * Retourne l'objet identifié par id
     * @param id
     * identifiant de l'objet cherché
     * @return
     */
    public abstract T find(int id);

    /**
     * Ajout un objet à la base
     * @param obj
     * Objet à ajouter
     * @return
     */
    public abstract boolean create(T obj);

    /**
     * Met à jour un objet dans la base
     * @param obj
     * Objet à mettre à jour
     * @return
     */
    public abstract boolean update(T obj);

    /**
     * Supprime un objet de la base
     * @param obj
     * objet à supprimer
     * @return
     */
    public abstract boolean delete(T obj);

}
