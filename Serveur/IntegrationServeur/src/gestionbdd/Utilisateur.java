/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

/**
 * Classe représentant un utilisateur client
 * @author nfloquet
 */
public class Utilisateur {
    /* nom de l'utilisateur */
    private String login;

    /* mot de passe de l'utilisateur */
    private String password;

    /* Numero du terminal utilisé */
    private int terminal;

    /**
     * Constructeur de la classe Utilisateur
     * @param login
     * Identifiant de l'utilisateur
     * @param password
     * Mot de passe de l'utilisateur
     * @param terminal
     * Numero du terminal de cet utilisateur
     */
    public Utilisateur(String login, String password, int terminal) {
        this.login = login;
        this.password = password;
        this.terminal = terminal;
    }

    /*
     * Getters
     */

    /**
     * Retourne l'identifiant de l'utilisateur
     * @return
     * Identifiant de l'utilisateur
     */
    public String getLogin() {
        return login;
    }

    /**
     * Retourne le mot de passe de l'utilisateur
     * @return
     * Mot de passe de l'utilisateur
     */
    public String getPassword() {
        return password;
    }

    /**
     *Retourne le numero de terminal de l'utilisateur
     * @return
     * Numero de terminal de l'utilisateur
     */
    public int getTerminal() {
        return terminal;
    }

    /*
     * Setters
     */

    /**
     * Défini l'identifiant de l'utilisateur
     * @param login
     * Identifiant de l'utilisateur
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Défini le mot de passe de l'utilisateur
     * @param password
     * Mot de passe de l'utilisateur
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Défini le numero de terminal de l'utilisateur
     * @param terminal
     *  Numero de terminal de l'utilisateur
     */
    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

}
