package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import ctrl.Controleur;

/**
 * Interface graphique du terminal
 * @author Arthur Daussy
 */
public class IHM extends Frame implements ActionListener, ItemListener {

    TextField loginTextField, mdpText;
    Label mdpLabel, lblInfo, loginLabel, ordreLabel;
    Choice ReponceChoice;
    Button ValiderButton;
    String reponseSelectionne;
    String Dossier;
    Button connexionButton;
    private Controleur ctrl;

    public IHM(String Dossier) {
        this.Dossier = Dossier;
        initComponents();
    }

    /**
     * Initialisation/mise en place de tous les composants de la fenêtre
     */
    private void initComponents() {

        IHMawtLayout customLayout = new IHMawtLayout();

        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);

        loginLabel = new Label("Login :");
        add(loginLabel);

        loginTextField = new TextField("");
        add(loginTextField);

        mdpLabel = new Label("Mot de passe :");
        add(mdpLabel);

        mdpText = new TextField("");
        add(mdpText);

        connexionButton = new Button("Connexion");
        add(connexionButton);
        connexionButton.addActionListener(this);

        ordreLabel = new Label("ordre");
        add(ordreLabel);



        ReponceChoice = new Choice();
        ReponceChoice.addItemListener(this);

        ReponceChoice.addItem("Reponses");
        ReponceChoice.select(0);
        reponseSelectionne = "Reponse";

        add(ReponceChoice);

        ValiderButton = new Button("Valider Ordre");
        ValiderButton.addActionListener(this);
        add(ValiderButton);

        lblInfo = new Label("");
        add(lblInfo);

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pack();
    }

    /**
     * mise en place du controleur
     * @param ctrl
     */
    public void setControleur(Controleur ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * Affiche les informations
     * @param m
     */
    public void showInfo(String m) {
        lblInfo.setText(m);
    }

    public void refreshMsg(String m) {
    }

    /**
     * Enleve l'interface de log (apres un log valide)
     */
    public void disableLogin() {
        mdpText.setEnabled(false);
        loginTextField.setEnabled(false);
        connexionButton.setEnabled(false);
    }

    /**
     * Affiche le premier ordre de la mission, et ses reponses possibles
     */
    public void affichageOrdre() {
        ordreLabel.setText(ctrl.Ordre(ctrl.GetIdOrdreCourant()));//le 1er ordre est l'ordre courant a reception de la mission
        AddReponses(ctrl.ReponsePossible(1), ReponceChoice);
    }

    /**
     * Interactions avec l'utilisateurs
     * @param arg0
     */
    public void actionPerformed(ActionEvent arg0) {

        //Action au clic du bouton de connexion
        if (arg0.getSource() == connexionButton) {
            String login = loginTextField.getText();
            String mdp = mdpText.getText();

            if (!login.equals("") && !mdp.equals("")) {
                ctrl.envoyerLog(login, mdp);
            } else {
                lblInfo.setText("Erreur de saisie");
            }
        }
        //Action au clic du bouton de validation
        else if (arg0.getSource() == ValiderButton) {

            String reponseChoisi = reponseSelectionne;

            if (!reponseChoisi.equals("reponse")) {
                //On passe à l'ordre suivant
                int newIdCourant = ctrl.OrdreSuivant(ctrl.GetIdOrdreCourant(), reponseChoisi);
  
                ordreLabel.setText(ctrl.Ordre(newIdCourant));
                ReponceChoice.removeAll();
                Vector v = ctrl.ReponsePossible(newIdCourant);
                if (v != null) {
                    AddReponses(v, ReponceChoice);
                }
                //on lit le fichier audio correspondant
                ctrl.lireAudio(Dossier + ctrl.GetFichierAudio(ctrl.GetIdOrdreCourant()));
            } else {
                lblInfo.setText("Veuillez choisir une reponse");
            }
        }
    }

    /**
     * Ajout des réponses possibles de l'ordre
     * @param reponse
     * @param choix
     */
    private void AddReponses(Vector reponse, Choice choix) {

        for (int i = 0; i < reponse.size(); i++) {
            choix.add((String) reponse.get(i));
        }
    }

    /**
     * 
     * @param arg0
     */
    public void itemStateChanged(ItemEvent arg0) {

        if (arg0.getSource() == ReponceChoice) {
            reponseSelectionne = ReponceChoice.getSelectedItem();
        }

    }
}

/**
 * Classe de gestion du layout de l'interface graphique
 * @author Arthur Daussy
 */
class IHMawtLayout implements LayoutManager {

    public IHMawtLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 320 + insets.left + insets.right;
        dim.height = 240 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {
            c.setBounds(insets.left + 8, insets.top + 8, 72, 24);
        }
        c = parent.getComponent(1);
        if (c.isVisible()) {
            c.setBounds(insets.left + 112, insets.top + 8, 72, 24);
        }
        c = parent.getComponent(2);
        if (c.isVisible()) {
            c.setBounds(insets.left + 8, insets.top + 40, 100, 24);
        }
        c = parent.getComponent(3);
        if (c.isVisible()) {
            c.setBounds(insets.left + 112, insets.top + 40, 72, 24);
        }
        c = parent.getComponent(4);
        if (c.isVisible()) {
            c.setBounds(insets.left + 208, insets.top + 40, 72, 24);
        }
        c = parent.getComponent(5);
        if (c.isVisible()) {
            c.setBounds(insets.left + 8, insets.top + 72, 200, 24);
        }
        c = parent.getComponent(6);
        if (c.isVisible()) {
            c.setBounds(insets.left + 8, insets.top + 112, 184, 80);
        }
        c = parent.getComponent(7);
        if (c.isVisible()) {
            c.setBounds(insets.left + 200, insets.top + 112, 72, 24);
        }
        c = parent.getComponent(8);
        if (c.isVisible()) {
            c.setBounds(insets.left + 88, insets.top + 192, 72, 24);
        }


    }
}
