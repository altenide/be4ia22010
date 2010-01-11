package gui;

import java.awt.*;
import java.awt.event.*;

public class IHMawt extends Frame {
    Label loginLabel;
    TextField loginTextField;
    Label MdpLabel;
    TextField MdpText;
    Button ConnexionButton;
    Label OrdreLabel;
    TextArea IntituerOrdre;

    public IHMawt() {
        IHMawtLayout customLayout = new IHMawtLayout();

        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);

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

        OrdreLabel = new Label("Ordre:");
        add(OrdreLabel);

        IntituerOrdre = new TextArea("Intituler ordre");
        add(IntituerOrdre);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        IHMawt window = new IHMawt();

        window.setTitle("IHMawt");
        window.pack();
        window.show();
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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+40,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+40,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+80,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+128,184,80);}
    }
}
