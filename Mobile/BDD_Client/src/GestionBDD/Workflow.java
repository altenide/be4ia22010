package GestionBDD;

import DAO_XML.*;

/**
 * Classe de gestion du workflow sur le mobile
 * @author Edith Guilbaud
 */
public class Workflow {

    /**
     * Trouve le prochain ordre a executer
     * @param id identifiant de l'ordre courant
     * @param rep reponse a cet ordre
     * @return l'identifiant du prochain ordre correspondant a cette reponse, -5 pour erreur
     */
    public int prochainOrdre(int id, String rep) {

        XMLDAOFactory factory = new XMLDAOFactory();
        OrdreDAO ordreDao = factory.getOrdreDAO();
        ReponsePossibleDAO reponseDao = factory.getReponsePossibleDAO();
        Ordre monOrdre = ordreDao.findOrdre(id, true);

        if (monOrdre != null) {
            return reponseDao.findReponse(rep).getIdOrdreSuivant();
        } else {
            return -5;
        }

    }
    
    
    
}
