/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scouting;
import javax.swing.JOptionPane;
import java.io.File;
/**
 *
 * @author Fauzi
 */
public class Form extends javax.swing.JFrame 
{
    RobotData m_bot1;
    RobotData m_bot2;
    RobotData m_bot3;
    RobotData m_bot4;
    RobotData m_bot5;
    RobotData m_bot6;
    
    int m_iKeyLength = 4;
    char m_cBot1Key[] = {'q', 'a', 'z', 'w'};
    char m_cBot2Key[] = {'q', 'a', 'z', 'w'};
    char m_cBot3Key[] = {'q', 'a', 'z', 'w'};
    char m_cBot4Key[] = {'q', 'a', 'z', 'w'};
    char m_cBot5Key[] = {'q', 'a', 'z', 'w'};
    char m_cBot6Key[] = {'q', 'a', 'z', 'w'};
    
    /**
     * Creates new form Form
     */
    public Form() 
    {
        initComponents();
        m_bot1 = new RobotData();
        m_bot2 = new RobotData();
        m_bot3 = new RobotData();
        m_bot4 = new RobotData();
        m_bot5 = new RobotData();
        m_bot6 = new RobotData();        
    }

    public void resetData()
    {
        m_bot1.reset();
        m_bot2.reset();
        m_bot3.reset();
        m_bot4.reset();
        m_bot5.reset();
        m_bot6.reset();  
        
        txAuto.setText("");
        txTeleop.setText("");
        
        // Bot 1
        chkBot1Broken.setSelected(false);
        chkBot1Defensive.setSelected(false);
        chkBot1Penalized.setSelected(false);
        slBot1ClimbLevel.setValue(0);
        txBot1Comments.setText("");
        
        // Bot 2
        chkBot2Broken.setSelected(false);
        chkBot2Defensive.setSelected(false);
        chkBot2Penalized.setSelected(false);
        slBot2ClimbLevel.setValue(0);
        txBot2Comments.setText("");
        
        // Bot 3
        chkBot3Broken.setSelected(false);
        chkBot3Defensive.setSelected(false);
        chkBot3Penalized.setSelected(false);
        slBot3ClimbLevel.setValue(0);
        txBot3Comments.setText("");
        
        // Bot 4
        chkBot4Broken.setSelected(false);
        chkBot4Defensive.setSelected(false);
        chkBot4Penalized.setSelected(false);
        slBot4ClimbLevel.setValue(0);
        txBot4Comments.setText("");
        
        // Bot 5
        chkBot5Broken.setSelected(false);
        chkBot5Defensive.setSelected(false);
        chkBot5Penalized.setSelected(false);
        slBot5ClimbLevel.setValue(0);
        txBot5Comments.setText("");
        
        // Bot 6
        chkBot6Broken.setSelected(false);
        chkBot6Defensive.setSelected(false);
        chkBot6Penalized.setSelected(false);
        slBot6ClimbLevel.setValue(0);
        txBot6Comments.setText("");
    }
    
    public void submitData()
    {
        // Bot 1
        m_bot1.setBroken(chkBot1Broken.isSelected());
        m_bot1.setDefensive(chkBot1Defensive.isSelected());
        m_bot1.setDefensive(chkBot1Penalized.isSelected());
        m_bot1.setClimbLevel(slBot1ClimbLevel.getValue());
        m_bot1.setComment(txBot1Comments.getText());
        
        // Bot 2
        m_bot2.setBroken(chkBot2Broken.isSelected());
        m_bot2.setDefensive(chkBot2Defensive.isSelected());
        m_bot2.setDefensive(chkBot2Penalized.isSelected());
        m_bot2.setClimbLevel(slBot2ClimbLevel.getValue());
        m_bot2.setComment(txBot2Comments.getText());
        
        // Bot 3
        m_bot3.setBroken(chkBot3Broken.isSelected());
        m_bot3.setDefensive(chkBot3Defensive.isSelected());
        m_bot3.setDefensive(chkBot3Penalized.isSelected());
        m_bot3.setClimbLevel(slBot3ClimbLevel.getValue());
        m_bot3.setComment(txBot3Comments.getText());
        
        // Bot 4
        m_bot4.setBroken(chkBot4Broken.isSelected());
        m_bot4.setDefensive(chkBot4Defensive.isSelected());
        m_bot4.setDefensive(chkBot4Penalized.isSelected());
        m_bot4.setClimbLevel(slBot4ClimbLevel.getValue());
        m_bot4.setComment(txBot4Comments.getText());
        
        // Bot 5
        m_bot5.setBroken(chkBot5Broken.isSelected());
        m_bot5.setDefensive(chkBot5Defensive.isSelected());
        m_bot5.setDefensive(chkBot5Penalized.isSelected());
        m_bot5.setClimbLevel(slBot5ClimbLevel.getValue());
        m_bot5.setComment(txBot5Comments.getText());
        
        // Bot 6
        m_bot6.setBroken(chkBot6Broken.isSelected());
        m_bot6.setDefensive(chkBot6Defensive.isSelected());
        m_bot6.setDefensive(chkBot6Penalized.isSelected());
        m_bot6.setClimbLevel(slBot6ClimbLevel.getValue());
        m_bot6.setComment(txBot6Comments.getText());
        
        String sData = txAuto.getText();
        
        // Autonomous
        for(int keyIndex = 0; keyIndex < m_iKeyLength; keyIndex++)
        {
            for(int dataIndex = 0; dataIndex < sData.length(); dataIndex++)
            {
                // Bot 1
                if(sData.charAt(dataIndex) == m_cBot1Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot1.setLowGoalShotsAuto(m_bot1.getLowGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 1)
                        m_bot1.setMiddleGoalShotsAuto(m_bot1.getMiddleGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot1.setHighGoalShotsAuto(m_bot1.getHighGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot1.setPryamidGoalShots(m_bot1.getPryamidGoalShots() + 1);
                }
                
                // Bot 2
                else if(sData.charAt(dataIndex) == m_cBot2Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot2.setLowGoalShotsAuto(m_bot2.getLowGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 1)
                        m_bot2.setMiddleGoalShotsAuto(m_bot2.getMiddleGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot2.setHighGoalShotsAuto(m_bot2.getHighGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot2.setPryamidGoalShots(m_bot2.getPryamidGoalShots() + 1);
                }
                
                // Bot 3
                else if(sData.charAt(dataIndex) == m_cBot3Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot3.setLowGoalShotsAuto(m_bot3.getLowGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 1)
                        m_bot3.setMiddleGoalShotsAuto(m_bot3.getMiddleGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot3.setHighGoalShotsAuto(m_bot3.getHighGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot3.setPryamidGoalShots(m_bot3.getPryamidGoalShots() + 1);
                }
                
                // Bot 4
                else if(sData.charAt(dataIndex) == m_cBot4Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot4.setLowGoalShotsAuto(m_bot4.getLowGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 1)
                        m_bot4.setMiddleGoalShotsAuto(m_bot4.getMiddleGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot4.setHighGoalShotsAuto(m_bot4.getHighGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot4.setPryamidGoalShots(m_bot4.getPryamidGoalShots() + 1);
                }
                
                // Bot 5
                else if(sData.charAt(dataIndex) == m_cBot5Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot5.setLowGoalShotsAuto(m_bot5.getLowGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 1)
                        m_bot5.setMiddleGoalShotsAuto(m_bot5.getMiddleGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot5.setHighGoalShotsAuto(m_bot5.getHighGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot5.setPryamidGoalShots(m_bot5.getPryamidGoalShots() + 1);
                }
                
                // Bot 6
                else if(sData.charAt(dataIndex) == m_cBot6Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot6.setLowGoalShotsAuto(m_bot6.getLowGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 1)
                        m_bot6.setMiddleGoalShotsAuto(m_bot6.getMiddleGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot6.setHighGoalShotsAuto(m_bot6.getHighGoalShotsAuto() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot6.setPryamidGoalShots(m_bot6.getPryamidGoalShots() + 1);
                }
            }
        }
        
        sData = txTeleop.getText();
        
        // Teleop
        for(int keyIndex = 0; keyIndex < m_iKeyLength; keyIndex++)
        {
            for(int dataIndex = 0; dataIndex < sData.length(); dataIndex++)
            {
                // Bot 1
                if(sData.charAt(dataIndex) == m_cBot1Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot1.setLowGoalShotsTeleop(m_bot1.getLowGoalShotsTeleop()+ 1);
                    
                    else if(keyIndex == 1)
                        m_bot1.setMiddleGoalShotsTeleop(m_bot1.getMiddleGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot1.setHighGoalShotsTeleop(m_bot1.getHighGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot1.setPryamidGoalShots(m_bot1.getPryamidGoalShots() + 1);
                }
                
                // Bot 2
                else if(sData.charAt(dataIndex) == m_cBot2Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot2.setLowGoalShotsTeleop(m_bot2.getLowGoalShotsTeleop()+ 1);
                    
                    else if(keyIndex == 1)
                        m_bot2.setMiddleGoalShotsTeleop(m_bot2.getMiddleGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot2.setHighGoalShotsTeleop(m_bot2.getHighGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot2.setPryamidGoalShots(m_bot2.getPryamidGoalShots() + 1);
                }
                
                // Bot 3
                else if(sData.charAt(dataIndex) == m_cBot3Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot3.setLowGoalShotsTeleop(m_bot3.getLowGoalShotsTeleop()+ 1);
                    
                    else if(keyIndex == 1)
                        m_bot3.setMiddleGoalShotsTeleop(m_bot3.getMiddleGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot3.setHighGoalShotsTeleop(m_bot3.getHighGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot3.setPryamidGoalShots(m_bot3.getPryamidGoalShots() + 1);
                }
                
                // Bot 4
                else if(sData.charAt(dataIndex) == m_cBot4Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot4.setLowGoalShotsTeleop(m_bot4.getLowGoalShotsTeleop()+ 1);
                    
                    else if(keyIndex == 1)
                        m_bot4.setMiddleGoalShotsTeleop(m_bot4.getMiddleGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot4.setHighGoalShotsTeleop(m_bot4.getHighGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot4.setPryamidGoalShots(m_bot4.getPryamidGoalShots() + 1);
                }
                
                // Bot 5
                else if(sData.charAt(dataIndex) == m_cBot5Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot5.setLowGoalShotsTeleop(m_bot5.getLowGoalShotsTeleop()+ 1);
                    
                    else if(keyIndex == 1)
                        m_bot5.setMiddleGoalShotsTeleop(m_bot5.getMiddleGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot5.setHighGoalShotsTeleop(m_bot5.getHighGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot5.setPryamidGoalShots(m_bot5.getPryamidGoalShots() + 1);
                }
                
                // Bot 6
                else if(sData.charAt(dataIndex) == m_cBot6Key[keyIndex])
                {
                    if(keyIndex == 0)
                        m_bot6.setLowGoalShotsTeleop(m_bot6.getLowGoalShotsTeleop()+ 1);
                    
                    else if(keyIndex == 1)
                        m_bot6.setMiddleGoalShotsTeleop(m_bot6.getMiddleGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 2)
                        m_bot6.setHighGoalShotsTeleop(m_bot6.getHighGoalShotsTeleop() + 1);
                    
                    else if(keyIndex == 3)
                        m_bot6.setPryamidGoalShots(m_bot6.getPryamidGoalShots() + 1);
                }
            }
        }
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        lbTitle = new javax.swing.JLabel();
        lbAutonomous = new javax.swing.JLabel();
        lbTeleop = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txTeleop = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txAuto = new javax.swing.JTextArea();
        btSubmit = new javax.swing.JButton();
        lbBot2 = new javax.swing.JLabel();
        lbBot1 = new javax.swing.JLabel();
        lbBot3 = new javax.swing.JLabel();
        lbBot4 = new javax.swing.JLabel();
        lbBot6 = new javax.swing.JLabel();
        lbBot5 = new javax.swing.JLabel();
        chkBot1Defensive = new javax.swing.JCheckBox();
        chkBot1Penalized = new javax.swing.JCheckBox();
        chkBot1Broken = new javax.swing.JCheckBox();
        chkBot2Broken = new javax.swing.JCheckBox();
        chkBot2Penalized = new javax.swing.JCheckBox();
        chkBot2Defensive = new javax.swing.JCheckBox();
        chkBot3Defensive = new javax.swing.JCheckBox();
        chkBot3Broken = new javax.swing.JCheckBox();
        chkBot3Penalized = new javax.swing.JCheckBox();
        chkBot4Defensive = new javax.swing.JCheckBox();
        chkBot4Broken = new javax.swing.JCheckBox();
        chkBot4Penalized = new javax.swing.JCheckBox();
        chkBot5Defensive = new javax.swing.JCheckBox();
        chkBot5Broken = new javax.swing.JCheckBox();
        chkBot5Penalized = new javax.swing.JCheckBox();
        chkBot6Defensive = new javax.swing.JCheckBox();
        chkBot6Broken = new javax.swing.JCheckBox();
        chkBot6Penalized = new javax.swing.JCheckBox();
        slBot1ClimbLevel = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        slBot2ClimbLevel = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        slBot3ClimbLevel = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        slBot4ClimbLevel = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        slBot5ClimbLevel = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        slBot6ClimbLevel = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        txBot1Comments = new javax.swing.JTextField();
        txBot2Comments = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txBot3Comments = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txBot4Comments = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txBot5Comments = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txBot6Comments = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txHuman1 = new javax.swing.JTextField();
        txHuman2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1250, 636));
        setResizable(false);

        lbTitle.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        lbTitle.setText("Team 955 Scouting!");

        lbAutonomous.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbAutonomous.setText("Autonomous");

        lbTeleop.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTeleop.setText("Teleop");

        txTeleop.setColumns(20);
        txTeleop.setRows(5);
        jScrollPane1.setViewportView(txTeleop);

        txAuto.setColumns(20);
        txAuto.setRows(5);
        jScrollPane2.setViewportView(txAuto);

        btSubmit.setText("Submit");
        btSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmitActionPerformed(evt);
            }
        });

        lbBot2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBot2.setText("Bot 2");

        lbBot1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBot1.setText("Bot 1");

        lbBot3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBot3.setText("Bot 3");

        lbBot4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBot4.setText("Bot 4");

        lbBot6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBot6.setText("Bot 6");

        lbBot5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBot5.setText("Bot 5");

        chkBot1Defensive.setText("Defensive ?");
        chkBot1Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot1DefensiveActionPerformed(evt);
            }
        });

        chkBot1Penalized.setText("Penalized?");

        chkBot1Broken.setText("Broken?");

        chkBot2Broken.setText("Broken?");

        chkBot2Penalized.setText("Penalized?");

        chkBot2Defensive.setText("Defensive ?");
        chkBot2Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot2DefensiveActionPerformed(evt);
            }
        });

        chkBot3Defensive.setText("Defensive ?");
        chkBot3Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot3DefensiveActionPerformed(evt);
            }
        });

        chkBot3Broken.setText("Broken?");

        chkBot3Penalized.setText("Penalized?");

        chkBot4Defensive.setText("Defensive ?");
        chkBot4Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot4DefensiveActionPerformed(evt);
            }
        });

        chkBot4Broken.setText("Broken?");

        chkBot4Penalized.setText("Penalized?");
        chkBot4Penalized.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot4PenalizedActionPerformed(evt);
            }
        });

        chkBot5Defensive.setText("Defensive ?");
        chkBot5Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot5DefensiveActionPerformed(evt);
            }
        });

        chkBot5Broken.setText("Broken?");

        chkBot5Penalized.setText("Penalized?");

        chkBot6Defensive.setText("Defensive ?");
        chkBot6Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot6DefensiveActionPerformed(evt);
            }
        });

        chkBot6Broken.setText("Broken?");

        chkBot6Penalized.setText("Penalized?");

        slBot1ClimbLevel.setMajorTickSpacing(1);
        slBot1ClimbLevel.setMaximum(3);
        slBot1ClimbLevel.setPaintLabels(true);
        slBot1ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Climb Level");

        slBot2ClimbLevel.setMajorTickSpacing(1);
        slBot2ClimbLevel.setMaximum(3);
        slBot2ClimbLevel.setPaintLabels(true);
        slBot2ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Climb Level");

        slBot3ClimbLevel.setMajorTickSpacing(1);
        slBot3ClimbLevel.setMaximum(3);
        slBot3ClimbLevel.setPaintLabels(true);
        slBot3ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Climb Level");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Climb Level");

        slBot4ClimbLevel.setMajorTickSpacing(1);
        slBot4ClimbLevel.setMaximum(3);
        slBot4ClimbLevel.setPaintLabels(true);
        slBot4ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Climb Level");

        slBot5ClimbLevel.setMajorTickSpacing(1);
        slBot5ClimbLevel.setMaximum(3);
        slBot5ClimbLevel.setPaintLabels(true);
        slBot5ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Climb Level");

        slBot6ClimbLevel.setMajorTickSpacing(1);
        slBot6ClimbLevel.setMaximum(3);
        slBot6ClimbLevel.setPaintLabels(true);
        slBot6ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Comments");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Comments");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Comments");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Comments");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Comments");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Comments");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Human Scored");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Human Scored");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTeleop, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbAutonomous, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(136, 136, 136)
                .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txBot1Comments))
                            .addComponent(chkBot1Defensive)
                            .addComponent(lbBot1)
                            .addComponent(chkBot1Penalized)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slBot1ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txBot2Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkBot2Defensive)
                                .addComponent(chkBot2Broken)
                                .addComponent(chkBot2Penalized)
                                .addComponent(lbBot2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(slBot2ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txBot3Comments))
                            .addComponent(lbBot3)
                            .addComponent(chkBot3Defensive)
                            .addComponent(chkBot3Broken)
                            .addComponent(chkBot3Penalized)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slBot3ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkBot4Defensive)
                                .addComponent(chkBot4Penalized)
                                .addComponent(lbBot4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(slBot4ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(chkBot4Broken))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txBot4Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbBot5)
                                    .addComponent(chkBot5Defensive)
                                    .addComponent(chkBot5Broken)
                                    .addComponent(chkBot5Penalized))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbBot6)
                                    .addComponent(chkBot6Defensive)
                                    .addComponent(chkBot6Broken)
                                    .addComponent(chkBot6Penalized))
                                .addGap(81, 81, 81))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txBot5Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(slBot5ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(slBot6ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txBot6Comments)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkBot1Broken)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txHuman1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txHuman2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBot1)
                            .addComponent(lbBot2)
                            .addComponent(lbBot3)
                            .addComponent(lbBot4)
                            .addComponent(lbBot5)
                            .addComponent(lbBot6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkBot1Defensive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot1Penalized)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot1Broken))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkBot2Defensive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot2Penalized)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot2Broken))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkBot3Defensive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot3Penalized)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot3Broken))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkBot4Defensive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot4Penalized)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot4Broken))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkBot6Defensive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot6Penalized)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot6Broken))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkBot5Defensive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot5Penalized)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBot5Broken)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(slBot1ClimbLevel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(slBot2ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(slBot3ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel3))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(slBot4ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(slBot5ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(slBot6ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel7))))))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txBot1Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txBot2Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txBot3Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txBot4Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txBot5Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txBot6Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txHuman1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txHuman2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAutonomous)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTeleop, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkBot1DefensiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBot1DefensiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBot1DefensiveActionPerformed

    private void chkBot2DefensiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBot2DefensiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBot2DefensiveActionPerformed

    private void chkBot3DefensiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBot3DefensiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBot3DefensiveActionPerformed

    private void chkBot4DefensiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBot4DefensiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBot4DefensiveActionPerformed

    private void chkBot5DefensiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBot5DefensiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBot5DefensiveActionPerformed

    private void chkBot6DefensiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBot6DefensiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBot6DefensiveActionPerformed

    private void btSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmitActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Yes I did!", "Nope, I did not :("};
        int iResponse = JOptionPane.showOptionDialog(this,
                                            "Are you sure you entered the data right?",
                                            "Just Making Sure!!!",
                                            JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            options,
                                            options[1]);
        
        if(iResponse == JOptionPane.YES_OPTION)
        {
            submitData();
            resetData();
        }
    }//GEN-LAST:event_btSubmitActionPerformed

    private void chkBot4PenalizedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBot4PenalizedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBot4PenalizedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JCheckBox chkBot1Broken;
    private javax.swing.JCheckBox chkBot1Defensive;
    private javax.swing.JCheckBox chkBot1Penalized;
    private javax.swing.JCheckBox chkBot2Broken;
    private javax.swing.JCheckBox chkBot2Defensive;
    private javax.swing.JCheckBox chkBot2Penalized;
    private javax.swing.JCheckBox chkBot3Broken;
    private javax.swing.JCheckBox chkBot3Defensive;
    private javax.swing.JCheckBox chkBot3Penalized;
    private javax.swing.JCheckBox chkBot4Broken;
    private javax.swing.JCheckBox chkBot4Defensive;
    private javax.swing.JCheckBox chkBot4Penalized;
    private javax.swing.JCheckBox chkBot5Broken;
    private javax.swing.JCheckBox chkBot5Defensive;
    private javax.swing.JCheckBox chkBot5Penalized;
    private javax.swing.JCheckBox chkBot6Broken;
    private javax.swing.JCheckBox chkBot6Defensive;
    private javax.swing.JCheckBox chkBot6Penalized;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAutonomous;
    private javax.swing.JLabel lbBot1;
    private javax.swing.JLabel lbBot2;
    private javax.swing.JLabel lbBot3;
    private javax.swing.JLabel lbBot4;
    private javax.swing.JLabel lbBot5;
    private javax.swing.JLabel lbBot6;
    private javax.swing.JLabel lbTeleop;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JSlider slBot1ClimbLevel;
    private javax.swing.JSlider slBot2ClimbLevel;
    private javax.swing.JSlider slBot3ClimbLevel;
    private javax.swing.JSlider slBot4ClimbLevel;
    private javax.swing.JSlider slBot5ClimbLevel;
    private javax.swing.JSlider slBot6ClimbLevel;
    private javax.swing.JTextArea txAuto;
    private javax.swing.JTextField txBot1Comments;
    private javax.swing.JTextField txBot2Comments;
    private javax.swing.JTextField txBot3Comments;
    private javax.swing.JTextField txBot4Comments;
    private javax.swing.JTextField txBot5Comments;
    private javax.swing.JTextField txBot6Comments;
    private javax.swing.JTextField txHuman1;
    private javax.swing.JTextField txHuman2;
    private javax.swing.JTextArea txTeleop;
    // End of variables declaration//GEN-END:variables
}
