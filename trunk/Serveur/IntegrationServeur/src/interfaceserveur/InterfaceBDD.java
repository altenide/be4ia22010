/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceserveur;

/**
 *
 * @author mac
 */
public interface InterfaceBDD {

    public void AjouterEmployeBDD(String login, char[] motDePasse);
    public void RetirerEmployeBDD (String login);
    public void AjouterMissionBDD ();
    public void RetirerMissionBDD ();
    


}
