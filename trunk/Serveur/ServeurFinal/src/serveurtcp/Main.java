/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serveurtcp;

/**
 *
 * @author Administrateur
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TCPServeur serv = new TCPServeur(4242);
        serv.start();
    }

}
