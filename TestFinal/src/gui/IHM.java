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

public class IHM extends Frame implements ActionListener,ItemListener{

	TextField loginTextField, mdpText;
	Label mdpLabel, lblInfo, loginLabel,ordreLabel;
	Choice ReponceChoice;
	Button ValiderButton;
	String reponseSelectionne;

	Button connexionButton;

	private Controleur ctrl; 

	public IHM(){
		initComponents();
	}

	private void initComponents(){

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
		reponseSelectionne="Reponse";

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

	public void setControleur(Controleur ctrl){
		this.ctrl = ctrl;
	}

	public void showInfo(String m){
		lblInfo.setText(m);
	}

	public void refreshMsg(String m){

	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == connexionButton){
			////////////////////Gestion de l'ordre////////////////
			// a implementer changer le 1 en int getMission -> getPremierOrdre
			ordreLabel.setText(ctrl.Ordre(ctrl.GetIdOrdreCourant()));//le 1er ordre est l'ordre courant a reception de la mission
			AddReponses(ctrl.ReponsePossible(1), ReponceChoice);

			////////////////////////////////////////
			System.out.println("Clic");
			String login = loginTextField.getText();
			String mdp = mdpLabel.getText();

			if(!login.equals("") && !mdp.equals(""))			
				ctrl.envoyerLog(login, mdp);
			else lblInfo.setText("Erreur de saisie");
		}
		else if (arg0.getSource() == ValiderButton){
			System.out.println("");
			String reponseChoisi =reponseSelectionne;
			System.out.println("------------------Reponce chois"+reponseChoisi);
			if (!reponseChoisi.equals("reponse")){
				//Changer par setIdcourrant a newIdcourant et changer le 2 par getIdCourant =>OK
				int newIdCourant = ctrl.OrdreSuivant(ctrl.GetIdOrdreCourant(),reponseChoisi);
				System.out.println("----------------------Nouvel id courant"+newIdCourant);
				ordreLabel.setText(ctrl.Ordre(newIdCourant));
				ReponceChoice.removeAll();
				Vector v =ctrl.ReponsePossible(newIdCourant);
				if ( v != null){
					AddReponses(v, ReponceChoice);
				}
			}
			else {
				lblInfo.setText("Veuillez choisir une reponse");
			}
		}
	}

	private void AddReponses (Vector reponse,Choice choix){
		//Pas disponible pour cette version de java
		//for (String R : reponse.listIterator()){
		//}
		for (int i =0 ; i< reponse.size();i++){
			choix.add((String)reponse.get(i));
		}
	}

	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == ReponceChoice){
			reponseSelectionne=ReponceChoice.getSelectedItem();
		}

	}
}



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
		if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,72,24);}
		c = parent.getComponent(1);
		if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+8,72,24);}
		c = parent.getComponent(2);
		if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,100,24);}
		c = parent.getComponent(3);
		if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+40,72,24);}
		c = parent.getComponent(4);
		if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+40,72,24);}
		c = parent.getComponent(5);
		if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+72, 200,24);}
		c = parent.getComponent(6);
		if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+112,184,80);}
		c = parent.getComponent(7);
		if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+112,72,24);}
		c = parent.getComponent(8);
		if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+192,72,24);}
		//c = parent.getComponent(9);
		//if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+192,72,24);}

	}
}
