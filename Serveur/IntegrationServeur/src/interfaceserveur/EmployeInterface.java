/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceserveur;

/**
 *
 * @author maculet
 */
public class EmployeInterface {

    private String login;
    private String MDP;
    private int terminalUtilise;
    private int dateDernierLog;

    public EmployeInterface(String log, String MotdePasse){
        this.login = log;
        this.MDP = MotdePasse;
    };



    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the MDP
     */
    public String getMDP() {
        return MDP;
    }

    /**
     * @param MDP the MDP to set
     */
    public void setMDP(String MDP) {
        this.MDP = MDP;
    }

    /**
     * @return the terminalUtilise
     */
    public int getTerminalUtilise() {
        return terminalUtilise;
    }

    /**
     * @param terminalUtilise the terminalUtilise to set
     */
    public void setTerminalUtilise(int terminalUtilise) {
        this.terminalUtilise = terminalUtilise;
    }

    /**
     * @return the dateDernierLog
     */
    public int getDateDernierLog() {
        return dateDernierLog;
    }

    /**
     * @param dateDernierLog the dateDernierLog to set
     */
    public void setDateDernierLog(int dateDernierLog) {
        this.dateDernierLog = dateDernierLog;
    }


}
