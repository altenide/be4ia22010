/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testreseau;

import java.awt.*;
import network.*;

/**
 * @author Administrateur
 */
public class Main extends Frame {

    private TCPClient tcpC;
    private ReceptionFichierServeur rfs;

    private String msg;

    public Main() {

        msg = "Test du groupe A2";

        initComponents();
        tcpC = new TCPClient(4242, "ordidebeshopp", this);
        tcpC.start();
        tcpC.send("Test qui me prend la tete");

        rfs = new ReceptionFichierServeur(4343, this);
        rfs.start();
    }

    private void initComponents() {
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString(msg, 5, 50);
    }

    public void showInfo(String msg) {
        this.msg += " | "+msg;
        majFenetre();
    }

    public void refreshMsg(String msg){
        this.msg += " | "+msg;
        majFenetre();
    }

    private void majFenetre(){
        repaint();
    }
}
