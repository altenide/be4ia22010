package GestionMobile;

import DAO_XML.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Classe de gestion du workflow sur le mobile
 * @author Edith Guilbaud
 */
public class Workflow {

	private String path, fichier;
	
	public Workflow(String path){
		this.path = path;
	}
	
	public void setFichier(String f){
		fichier = f;
	}
	

    /**
     * Validation d'un ordre : maj de l'etat de l'ordre, de l'etat de la mission si necessaire, l'id de l'ordre courant
     * @param ordre
     * @param reponse
     * @return le nouvel ordre (-2 si fini)
     */
    public int validationOrdre(int ordre, String reponse) {

        XMLDAOFactory factory = new XMLDAOFactory(path, fichier);
        OrdreDAO oDao = factory.getOrdreDAO();
        Ordre monOrdre;
        Mission mission;
        int prochainOrdre = -2;

        try {

            //maj de l'etat de l'ordre effectue
            //rappel, etats possibles :EnCours, Termine, Disponible, NonDisponible
            oDao.miseAJourEtat(ordre, "Termine");
            MissionDAO mDao = factory.getMissionDAO();
            factory.goToStartDocument();
            mission = mDao.extractMission(true, true);


            monOrdre = mission.findOrdre(ordre);
            if (monOrdre.isOrdreFinal()) {
                mDao.MiseAJourEtat("Termine"); //maj de l'etat de la mission si necessaire
            } else {
                prochainOrdre = monOrdre.findReponse(reponse).getIdOrdreSuivant();
                oDao.miseAJourEtat(prochainOrdre, "EnCours");
                //maj de l'ordre courant
                mDao.MiseAJourOrdreCourant(prochainOrdre);
            }



        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prochainOrdre;


    }


}
