/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineclient;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Earth_MacBook
 */
public class Main extends javax.swing.JPanel {

    /**
     * Creates new form Main
     */
    public Main(Sender sender, Receiver receiver, Login mainPage) {
        this.sender = sender;
        this.receiver = receiver;
        this.mainPage = mainPage;
        initComponents();
        setSize(480, 690);

        this.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane(allGroupPanel);
        allGroupPanel = new javax.swing.JPanel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jPanel1.setBackground(new java.awt.Color(220, 220, 220));
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 460));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID :  ");
        jLabel1.setToolTipText("");

        nameLabel.setFont(new java.awt.Font("TH Sarabun New", 1, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 204, 255));
        nameLabel.setText(mainPage.loginName);

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("TH Sarabun New", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("Log out");
        jButton1.setPreferredSize(new java.awt.Dimension(79, 20));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 255, 102));
        jButton4.setFont(new java.awt.Font("TH Sarabun New", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 204, 255));
        jButton4.setText("Group");
        jButton4.setPreferredSize(new java.awt.Dimension(79, 15));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(280, 300));

        allGroupPanel.setLayout(null);

        jScrollPane1.setAutoscrolls(true);

        jScrollPane1.setViewportView(allGroupPanel);
        allGroupPanel.setPreferredSize(new java.awt.Dimension(270,1000));

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        mainPage.changeToGroup();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mainPage.logOut();
    }//GEN-LAST:event_jButton1ActionPerformed

    private Sender sender;
    private Receiver receiver;
    private Login mainPage;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allGroupPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables

    private GroupPanel panels[];
    
    //functions
    public void setGroupPanels(ArrayList<String> parameters) {
        System.out.println("group list: ");
        int preferredHeight = 320;
        if(90*(parameters.size()/2) > 320) preferredHeight = 90*(parameters.size()/2);
        allGroupPanel.setPreferredSize(new java.awt.Dimension(280, preferredHeight));
        allGroupPanel.setLayout(new FlowLayout());
        //allGroupPanel.setLayout(new BoxLayout(allGroupPanel, BoxLayout.Y_AXIS));
        allGroupPanel.removeAll();
        panels = new GroupPanel[parameters.size() - 1];
        for (int i = 1; i < parameters.size(); i += 2) {
            System.out.println(parameters.get(i) + " " + parameters.get(i + 1));
            panels[(i-1)/2] = new GroupPanel(parameters.get(i), parameters.get(i + 1), mainPage);
            allGroupPanel.add(panels[(i-1)/2].panel);
        }
        allGroupPanel.setVisible(true);
        System.out.println("-------------");
    }

    class GroupPanel {

        public JPanel panel;
        public JLabel groupName;
        public JLabel unread;
        public Login mainPage;

        public GroupPanel(String groupNameStr, String unreadStr, Login mainPage) {
            panel = new JPanel();
            groupName = new JLabel();
            unread = new JLabel();
            this.mainPage = mainPage;

            panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 2, true));
            panel.setPreferredSize(new java.awt.Dimension(250, 80));
            panel.setMaximumSize(new java.awt.Dimension(251, 81));
            panel.setMinimumSize(new java.awt.Dimension(250, 80));

            groupName.setFont(new java.awt.Font("TH Sarabun New", 1, 24)); // NOI18N
            groupName.setForeground(new java.awt.Color(0, 204, 255));
            groupName.setText(groupNameStr);

            unread.setFont(new java.awt.Font("TH Sarabun New", 0, 16)); // NOI18N
            unread.setForeground(new java.awt.Color(0, 204, 255));
            unread.setText(unreadStr + " Unread messages");
            
            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(panel);
            panel.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                    jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(groupName)
                                    .addComponent(unread))
                    .addContainerGap(164, Short.MAX_VALUE)
                    )
            );
            jPanel5Layout.setVerticalGroup(
                    jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(groupName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(unread)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    )
            );
            
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){
                    System.out.println(groupName.getText());
                    
                    mainPage.mainToChat(groupName.getText());
                }
            
            });
        }
    }
    
    public void setNameLabel(String username){
        nameLabel.setText(username);
    }

}
