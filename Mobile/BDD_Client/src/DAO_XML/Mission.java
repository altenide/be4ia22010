/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO_XML;

import java.util.Vector;

/**
 *
 * @author Edith
 */
public class Mission {

    private int idMission;
    private String etat;
    private int idOrdreCourant;
    private String destinataire;
    private boolean publie;
    private String date;
    private Vector ordres;

    public Mission(int idMission, String etat, int idOrdreCourant, String destinataire, boolean publie, String date) {
        this.idMission = idMission;
        this.etat = etat;
        this.idOrdreCourant = idOrdreCourant;
        this.destinataire = destinataire;
        this.publie = publie;
        this.date = date;
        ordres = null;
    }

    public void initOrdres(){
        ordres = new Vector();
    }

    public void addOrdre(Ordre o){
        ordres.add(o);
    }


    public String toString(){
        return "Mission : "+idMission+" , "+etat+" , "+idOrdreCourant+" , "+destinataire+" , "+publie+" , "+date+" , "+ordres;
    }
    
}
