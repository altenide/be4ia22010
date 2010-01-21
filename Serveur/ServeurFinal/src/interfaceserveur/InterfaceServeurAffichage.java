/*
 * InterfaceServeurAffichage.java
 */

package interfaceserveur;

import gestionbdd.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Vector;

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
import javax.swing.JLabel;

/**
 * The application's main frame.
 */
public class InterfaceServeurAffichage extends FrameView {

    private DAOMission acces_mission;
    private DefaultListModel listeMissionModel;

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
    public void montrerFenetreEmployes() throws SQLException {
        if (fenetreListeEmployes == null) {
            JFrame mainFrame = InterfaceServeurApp.getApplication().getMainFrame();
            fenetreListeEmployes = new InterfaceEmployes(mainFrame, listeMissions, acces_mission);
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
        labelEmployeDefaut = new javax.swing.JLabel();
        labelEmploye = new javax.swing.JLabel();
        labelEtatDefaut = new javax.swing.JLabel();
        labelEtat = new javax.swing.JLabel();
        labelIDdefaut = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        labelOrdreDefaut = new javax.swing.JLabel();
        labelOrdre2Defaut = new javax.swing.JLabel();
        labelOrdre3Defaut = new javax.swing.JLabel();
        labelOrdre4Defaut = new javax.swing.JLabel();
        labelOrdre3 = new javax.swing.JLabel();
        labelOrdre4 = new javax.swing.JLabel();
        labelOrdre1Defaut = new javax.swing.JLabel();
        labelOrdre2 = new javax.swing.JLabel();
        labelOrdre1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
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

        listeMissionModel = new DefaultListModel();
        for (int i=0; i < acces_mission.findListAll().size();i++)
        {
            listeMissionModel.addElement(Integer.toString(acces_mission.findListAll().get(i).getIdMission()));
        }
        listeMissions.setModel(listeMissionModel);
        listeMissions.setName("listeMissions"); // NOI18N
        listeMissions.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listeMissionsValueChanged(evt);
            }
        });
        panneauListeMission.setViewportView(listeMissions);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(InterfaceServeurAffichage.class);
        descriptionPanneauListeMission.setText(resourceMap.getString("descriptionPanneauListeMission.text")); // NOI18N
        descriptionPanneauListeMission.setName("descriptionPanneauListeMission"); // NOI18N

        choixAffichagePanneauListeMission.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Toutes", "En attente", "En cours", "Terminées" }));
        choixAffichagePanneauListeMission.setName("choixAffichagePanneauListeMission"); // NOI18N
        choixAffichagePanneauListeMission.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                choixAffichagePanneauListeMissionItemStateChanged(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(InterfaceServeurAffichage.class, this);
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

        labelEmployeDefaut.setText(resourceMap.getString("labelEmployeDefaut.text")); // NOI18N
        labelEmployeDefaut.setName("labelEmployeDefaut"); // NOI18N

        labelEmploye.setText(resourceMap.getString("labelEmploye.text")); // NOI18N
        labelEmploye.setName("labelEmploye"); // NOI18N

        labelEtatDefaut.setText(resourceMap.getString("labelEtatDefaut.text")); // NOI18N
        labelEtatDefaut.setName("labelEtatDefaut"); // NOI18N

        labelEtat.setText(resourceMap.getString("labelEtat.text")); // NOI18N
        labelEtat.setName("labelEtat"); // NOI18N

        labelIDdefaut.setText(resourceMap.getString("labelIDdefaut.text")); // NOI18N
        labelIDdefaut.setName("labelIDdefaut"); // NOI18N

        labelID.setText(resourceMap.getString("labelID.text")); // NOI18N
        labelID.setName("labelID"); // NOI18N

        labelOrdreDefaut.setText(resourceMap.getString("labelOrdreDefaut.text")); // NOI18N
        labelOrdreDefaut.setName("labelOrdreDefaut"); // NOI18N

        labelOrdre2Defaut.setText(resourceMap.getString("labelOrdre2Defaut.text")); // NOI18N
        labelOrdre2Defaut.setName("labelOrdre2Defaut"); // NOI18N

        labelOrdre3Defaut.setText(resourceMap.getString("labelOrdre3Defaut.text")); // NOI18N
        labelOrdre3Defaut.setName("labelOrdre3Defaut"); // NOI18N

        labelOrdre4Defaut.setText(resourceMap.getString("labelOrdre4Defaut.text")); // NOI18N
        labelOrdre4Defaut.setName("labelOrdre4Defaut"); // NOI18N

        labelOrdre3.setText(resourceMap.getString("labelOrdre3.text")); // NOI18N
        labelOrdre3.setName("labelOrdre3"); // NOI18N

        labelOrdre4.setText(resourceMap.getString("labelOrdre4.text")); // NOI18N
        labelOrdre4.setName("labelOrdre4"); // NOI18N

        labelOrdre1Defaut.setText(resourceMap.getString("labelOrdre1Defaut.text")); // NOI18N
        labelOrdre1Defaut.setName("labelOrdre1Defaut"); // NOI18N

        labelOrdre2.setText(resourceMap.getString("labelOrdre2.text")); // NOI18N
        labelOrdre2.setName("labelOrdre2"); // NOI18N

        labelOrdre1.setText(resourceMap.getString("labelOrdre1.text")); // NOI18N
        labelOrdre1.setName("labelOrdre1"); // NOI18N
        labelOrdre1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOrdre1MouseClicked(evt);
            }
        });
        labelOrdre1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                labelOrdre1FocusGained(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setName("jList1"); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(separateurDescriptionMission, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                                .addGap(31, 31, 31))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelDescriptionMission)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(labelIDdefaut)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelID))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(labelEmployeDefaut)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelEmploye)
                                        .addGap(119, 119, 119)
                                        .addComponent(labelEtatDefaut)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelEtat))
                                    .addComponent(labelOrdreDefaut)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(labelOrdre3Defaut)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelOrdre3, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(labelOrdre4Defaut)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelOrdre4, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                                    .addComponent(jLabel1)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(labelOrdre2Defaut)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelOrdre2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(labelOrdre1Defaut)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelOrdre1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)))
                        .addGap(45, 45, 45))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(boutonAffecter, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boutonAjouterMission, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(panneauListeMission, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(descriptionPanneauListeMission)
                        .addGap(18, 18, 18)
                        .addComponent(choixAffichagePanneauListeMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonAffecter, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(choixAffichagePanneauListeMission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(descriptionPanneauListeMission)
                                .addComponent(labelDescriptionMission)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addComponent(separateurDescriptionMission, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelIDdefaut)
                                    .addComponent(labelID))
                                .addGap(12, 12, 12)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelEmployeDefaut)
                                    .addComponent(labelEtatDefaut)
                                    .addComponent(labelEtat)
                                    .addComponent(labelEmploye))
                                .addGap(27, 27, 27)
                                .addComponent(labelOrdreDefaut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelOrdre1Defaut)
                                    .addComponent(labelOrdre1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelOrdre2Defaut)
                                    .addComponent(labelOrdre2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelOrdre3Defaut)
                                    .addComponent(labelOrdre3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelOrdre4Defaut)
                                    .addComponent(labelOrdre4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(70, 70, 70))
                            .addComponent(panneauListeMission, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonAjouterMission)))
                .addGap(32, 32, 32))
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
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 567, Short.MAX_VALUE)
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
                .addGap(11, 11, 11))
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
            int id = Integer.parseInt((String) listeMissionModel.getElementAt(listeMissions.getSelectedIndex()));

            Mission mission = acces_mission.find(id);
            labelEmploye.setText(mission.getUtilisateur());
            labelID.setText(String.valueOf(mission.getIdMission()));
            labelEtat.setText(String.valueOf(mission.getEtat()));

            try {
                labelOrdre1.setText(mission.getListOrdres().get(0).getContenu());
                labelOrdre2.setText(mission.getListOrdres().get(1).getContenu());
                labelOrdre3.setText(mission.getListOrdres().get(2).getContenu());
                labelOrdre4.setText(mission.getListOrdres().get(3).getContenu());
            }
            catch (Exception e) {}


        
        //System.out.println("test nom mission : "+acces_mission.findListAll().get(0).getIdMission());
    }//GEN-LAST:event_listeMissionsValueChanged

    private void focusLabel (JLabel label,int numeroLabel)
    {
        int id = Integer.parseInt((String) listeMissionModel.getElementAt(listeMissions.getSelectedIndex()));
        Mission mission = acces_mission.find(id);
        //labelListes des Réponses de l'ordre ? :
        if (mission.getIdOrdreCourant() % 4 == 0)
        {
            label.setForeground(Color.GREEN);
        }
        else {
            label.setForeground(Color.RED);
        }

    }

    private void labelOrdre1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_labelOrdre1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_labelOrdre1FocusGained

    private void labelOrdre1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOrdre1MouseClicked
        // TODO add your handling code here:
                focusLabel(labelOrdre1, 1);
                focusLabel(labelOrdre2, 2);
                focusLabel(labelOrdre3, 3);
                focusLabel(labelOrdre4, 4);
    }//GEN-LAST:event_labelOrdre1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barreMenu;
    private javax.swing.JToggleButton boutonAffecter;
    private javax.swing.JToggleButton boutonAjouterMission;
    private javax.swing.JComboBox choixAffichagePanneauListeMission;
    private javax.swing.JLabel descriptionPanneauListeMission;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEmploye;
    private javax.swing.JLabel labelEmployeDefaut;
    private javax.swing.JLabel labelEtat;
    private javax.swing.JLabel labelEtatDefaut;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelIDdefaut;
    private javax.swing.JLabel labelOrdre1;
    private javax.swing.JLabel labelOrdre1Defaut;
    private javax.swing.JLabel labelOrdre2;
    private javax.swing.JLabel labelOrdre2Defaut;
    private javax.swing.JLabel labelOrdre3;
    private javax.swing.JLabel labelOrdre3Defaut;
    private javax.swing.JLabel labelOrdre4;
    private javax.swing.JLabel labelOrdre4Defaut;
    private javax.swing.JLabel labelOrdreDefaut;
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
