/*
 * InterfaceServeurAffichage.java
 */

package interfaceserveur;

import gestionbdd.*;
import java.sql.SQLException;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class InterfaceServeurAffichage extends FrameView {

    private DAOMission acces_mission;

    public InterfaceServeurAffichage(SingleFrameApplication app) throws SQLException {
        super(app);
        BDDConnexion.getInstance().Connect("jdbc:derby://localhost:1527/", "pouet", "pouet", "pouet");
        acces_mission = (DAOMission) DAOFactory.getDAOMission();
        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = InterfaceServeurApp.getApplication().getMainFrame();
            aboutBox = new InterfaceServeurFenetreAPropos(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        InterfaceServeurApp.getApplication().show(aboutBox);
    }
    @Action
    public void montrerFenetreEmployes() {
        if (fenetreListeEmployes == null) {
            JFrame mainFrame = InterfaceServeurApp.getApplication().getMainFrame();
            fenetreListeEmployes = new InterfaceEmployes(mainFrame, listeMissions);
            fenetreListeEmployes.setLocationRelativeTo(mainFrame);
        }
        InterfaceServeurApp.getApplication().show(fenetreListeEmployes);
    }

    @Action
    public void montrerFenetreNouvelleMission() {
        if (fenetreAjouterNouvelleMission == null) {
            JFrame mainFrame = InterfaceServeurApp.getApplication().getMainFrame();
            fenetreAjouterNouvelleMission = new InterfaceNouvelleMission(mainFrame, listeMissions, acces_mission);
            fenetreAjouterNouvelleMission.setLocationRelativeTo(mainFrame);
        }
        InterfaceServeurApp.getApplication().show(fenetreAjouterNouvelleMission);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        panneauListeMission = new javax.swing.JScrollPane();
        listeMissions = new javax.swing.JList();
        descriptionPanneauListeMission = new javax.swing.JLabel();
        choixAffichagePanneauListeMission = new javax.swing.JComboBox();
        boutonAffecter = new javax.swing.JToggleButton();
        separateurDescriptionMission = new javax.swing.JSeparator();
        boutonAjouterMission = new javax.swing.JToggleButton();
        javax.swing.JLabel labelDescriptionMission = new javax.swing.JLabel();
        barreMenu = new javax.swing.JMenuBar();
        javax.swing.JMenu ongletMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem sousOngletQuitter = new javax.swing.JMenuItem();
        javax.swing.JMenu ongletAide = new javax.swing.JMenu();
        javax.swing.JMenuItem sousOngletAide = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        panneauListeMission.setName("panneauListeMission"); // NOI18N

        DefaultListModel listeMissionModel = new DefaultListModel();
        listeMissions.setModel(listeMissionModel);
        listeMissions.setName("listeMissions"); // NOI18N
        listeMissions.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listeMissionsValueChanged(evt);
            }
        });
        panneauListeMission.setViewportView(listeMissions);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(interfaceserveur.InterfaceServeurApp.class).getContext().getResourceMap(InterfaceServeurAffichage.class);
        descriptionPanneauListeMission.setText(resourceMap.getString("descriptionPanneauListeMission.text")); // NOI18N
        descriptionPanneauListeMission.setName("descriptionPanneauListeMission"); // NOI18N

        choixAffichagePanneauListeMission.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Toutes", "En attente", "En cours", "Terminées" }));
        choixAffichagePanneauListeMission.setName("choixAffichagePanneauListeMission"); // NOI18N
        choixAffichagePanneauListeMission.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choixAffichagePanneauListeMissionItemStateChanged(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(interfaceserveur.InterfaceServeurApp.class).getContext().getActionMap(InterfaceServeurAffichage.class, this);
        boutonAffecter.setAction(actionMap.get("montrerFenetreEmployes")); // NOI18N
        boutonAffecter.setText(resourceMap.getString("boutonAffecter.text")); // NOI18N
        boutonAffecter.setName("boutonAffecter"); // NOI18N
        boutonAffecter.setVisible(false);
        boutonAffecter.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                boutonAffecterStateChanged(evt);
            }
        });
        boutonAffecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAffecterActionPerformed(evt);
            }
        });

        separateurDescriptionMission.setName("separateurDescriptionMission"); // NOI18N

        boutonAjouterMission.setAction(actionMap.get("montrerFenetreNouvelleMission")); // NOI18N
        boutonAjouterMission.setText(resourceMap.getString("boutonAjouterMission.text")); // NOI18N
        boutonAjouterMission.setName("boutonAjouterMission"); // NOI18N
        boutonAjouterMission.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                boutonAjouterMissionStateChanged(evt);
            }
        });
        boutonAjouterMission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAjouterMissionActionPerformed(evt);
            }
        });

        labelDescriptionMission.setFont(labelDescriptionMission.getFont().deriveFont(labelDescriptionMission.getFont().getStyle() | java.awt.Font.BOLD, labelDescriptionMission.getFont().getSize()+4));
        labelDescriptionMission.setText(resourceMap.getString("labelDescriptionMission.text")); // NOI18N
        labelDescriptionMission.setName("labelDescriptionMission"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(separateurDescriptionMission, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                            .addComponent(boutonAffecter, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelDescriptionMission)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panneauListeMission, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(descriptionPanneauListeMission)
                        .addGap(18, 18, 18)
                        .addComponent(choixAffichagePanneauListeMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boutonAjouterMission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(choixAffichagePanneauListeMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(descriptionPanneauListeMission)
                        .addComponent(labelDescriptionMission)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(separateurDescriptionMission, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(boutonAffecter, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panneauListeMission, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonAjouterMission)
                .addGap(19, 19, 19))
        );

        barreMenu.setName("barreMenu"); // NOI18N

        ongletMenu.setText(resourceMap.getString("ongletMenu.text")); // NOI18N
        ongletMenu.setName("ongletMenu"); // NOI18N

        sousOngletQuitter.setAction(actionMap.get("quit")); // NOI18N
        sousOngletQuitter.setText(resourceMap.getString("sousOngletQuitter.text")); // NOI18N
        sousOngletQuitter.setName("sousOngletQuitter"); // NOI18N
        ongletMenu.add(sousOngletQuitter);

        barreMenu.add(ongletMenu);

        ongletAide.setText(resourceMap.getString("ongletAide.text")); // NOI18N
        ongletAide.setName("ongletAide"); // NOI18N

        sousOngletAide.setAction(actionMap.get("showAboutBox")); // NOI18N
        sousOngletAide.setText(resourceMap.getString("sousOngletAide.text")); // NOI18N
        sousOngletAide.setName("sousOngletAide"); // NOI18N
        ongletAide.add(sousOngletAide);

        barreMenu.add(ongletAide);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(barreMenu);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void choixAffichagePanneauListeMissionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_choixAffichagePanneauListeMissionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_choixAffichagePanneauListeMissionItemStateChanged

    private void boutonAjouterMissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAjouterMissionActionPerformed

    }//GEN-LAST:event_boutonAjouterMissionActionPerformed

    private void boutonAffecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAffecterActionPerformed

    }//GEN-LAST:event_boutonAffecterActionPerformed

    private void boutonAffecterStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_boutonAffecterStateChanged
        // TODO add your handling code here:
        boutonAffecter.setSelected(false);
    }//GEN-LAST:event_boutonAffecterStateChanged

    private void boutonAjouterMissionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_boutonAjouterMissionStateChanged
        // TODO add your handling code here:
        boutonAjouterMission.setSelected(false);
    }//GEN-LAST:event_boutonAjouterMissionStateChanged

    private void listeMissionsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listeMissionsValueChanged
        // TODO add your handling code here:
        boutonAffecter.setVisible(true); //Rajouter condition pour activer et l'enlever
        System.out.println(acces_mission.find(0).getNom());
        System.out.println(acces_mission.find(1).getNom());
    }//GEN-LAST:event_listeMissionsValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barreMenu;
    private javax.swing.JToggleButton boutonAffecter;
    private javax.swing.JToggleButton boutonAjouterMission;
    private javax.swing.JComboBox choixAffichagePanneauListeMission;
    private javax.swing.JLabel descriptionPanneauListeMission;
    private javax.swing.JList listeMissions;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane panneauListeMission;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JSeparator separateurDescriptionMission;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    private JDialog fenetreListeEmployes;
    private JDialog fenetreAjouterNouvelleMission;
}
