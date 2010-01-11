package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ctrl.Controleur;

public class IHM extends Frame implements ActionListener{

    TextField loginTextField, mdpText;
    Label mdpLabel, lblInfo, loginLabel;

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
			
			System.out.println("Clic");
			String login = loginTextField.getText();
			String mdp = mdpLabel.getText();
			
			if(!login.equals("") && !mdp.equals(""))			
				ctrl.envoyerLog(login, mdp);
			else lblInfo.setText("Erreur de saisie");
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

    }
}
