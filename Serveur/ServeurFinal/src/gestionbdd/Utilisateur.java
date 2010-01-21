/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionbdd;

/**
 *
 * @author nfloquet
 */
public class Utilisateur {
    /* nom de l'utilisateur */
    private String login;

    /* mot de passe de l'utilisateur */
    private String password;

    /* Numero du terminal utilisé */
    private int terminal;

    public Utilisateur(String login, String password, int terminal) {
        this.login = login;
        this.password = password;
        this.terminal = terminal;
    }

    /*
     * Getters
     */

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getTerminal() {
        return terminal;
    }

    /*
     * Setters
     */

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

}
