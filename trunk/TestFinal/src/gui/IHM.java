package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IHM extends Frame implements ActionListener{

	Label loginLabel;
    TextField loginTextField;
    Label MdpLabel;
    TextField MdpText;
    Button ConnexionButton;
	
	public IHM(){
		initComponents();
	}
	
	private void initComponents(){
		
		loginLabel = new Label("Login :");
        add(loginLabel);

        loginTextField = new TextField("login");
        add(loginTextField);

        MdpLabel = new Label("Mot de passe :");
        add(MdpLabel);

        MdpText = new TextField("mot de passe");
        add(MdpText);

        ConnexionButton = new Button("Connexion");
        add(ConnexionButton);
		ConnexionButton.addActionListener(this);
        
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		
		pack();
	}
	
	public void showInfo(String m){
		
	}
	
	public void refreshMsg(String m){
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == ConnexionButton){
			System.out.println("Clic");
		}
	}
}
