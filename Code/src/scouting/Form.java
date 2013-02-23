
package scouting;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

/**
 *
 * @author Fauzi
 */
public class Form extends javax.swing.JFrame 
{
    int m_iMatchNumber = 00;
    RobotData m_bot1;
    RobotData m_bot2;
    RobotData m_bot3;
    RobotData m_bot4;
    RobotData m_bot5;
    RobotData m_bot6;
    
    static FileWriter writer;
    
    int m_iKeyLength = 4;
    
    // keyArray Format: low, mid, high, pyramid
    char m_cBot1Key[] = {'q', 'a', 'z', '1'};
    char m_cBot2Key[] = {'w', 's', 'x', '2'};
    char m_cBot3Key[] = {'e', 'd', 'c', '3'};
    char m_cBot4Key[] = {'r', 'f', 'v', '4'};
    char m_cBot5Key[] = {'t', 'g', 'b', '5'};
    char m_cBot6Key[] = {'y', 'h', 'n', '6'};
    
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
    
    /**
     * Exports to .csv file.
     * @param directory
     * @param bArray
     * @param array
     * @param sComment 
     */
     public static void openFile(String sDirectory)
     {
        try
        {
            File file = new File(sDirectory);
            file.getParentFile().mkdirs();
            writer = new FileWriter(file);
        }
         
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
     
    public static void writeBotData(String sMatch, String sTeamNumber, int array[], boolean bArray[], String sComment, String sHumanScored, String sColor)
    {  
        try
        {
            //TeamNumber
            writer.append(sTeamNumber);
            writer.append(",");
            
            for(int index = 0; index < array.length; index++)
            {
                writer.append(String.valueOf(array[index]));
                writer.append(",");
            }
            
            for(int index = 0; index < bArray.length; index++)
            {              
                writer.append(String.valueOf(bArray[index]));
                writer.append(",");
            }
            
            writer.append(sComment);
            writer.append(",");
            
            writer.append(sHumanScored);
            writer.append(",");
            
            writer.append(sColor);
            writer.append(",");
            
            writer.append(sMatch);
            writer.append(",");
            
            //New line
            writer.append("\n");
            writer.flush();
        }

        catch(IOException e)
        {
             e.printStackTrace();
        } 
    }
     
    public static void closeFile()
    {
        try
        {
            writer.close();
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
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
        txBot1Number.setText("Bot 1");
        
        // Bot 2
        chkBot2Broken.setSelected(false);
        chkBot2Defensive.setSelected(false);
        chkBot2Penalized.setSelected(false);
        slBot2ClimbLevel.setValue(0);
        txBot2Comments.setText("");
        txBot2Number.setText("Bot 2");
        
        // Bot 3
        chkBot3Broken.setSelected(false);
        chkBot3Defensive.setSelected(false);
        chkBot3Penalized.setSelected(false);
        slBot3ClimbLevel.setValue(0);
        txBot3Comments.setText("");
        txBot3Number.setText("Bot 3");
        
        // Bot 4
        chkBot4Broken.setSelected(false);
        chkBot4Defensive.setSelected(false);
        chkBot4Penalized.setSelected(false);
        slBot4ClimbLevel.setValue(0);
        txBot4Comments.setText("");
        txBot4Number.setText("Bot 1");
        
        // Bot 5
        chkBot5Broken.setSelected(false);
        chkBot5Defensive.setSelected(false);
        chkBot5Penalized.setSelected(false);
        slBot5ClimbLevel.setValue(0);
        txBot5Comments.setText("");
        txBot5Number.setText("Bot 2");
        
        // Bot 6
        chkBot6Broken.setSelected(false);
        chkBot6Defensive.setSelected(false);
        chkBot6Penalized.setSelected(false);
        slBot6ClimbLevel.setValue(0);
        txBot6Comments.setText("");
        txBot6Number.setText("Bot 3");
        
        txHuman1.setText("");
        txHuman2.setText("");
        txMatchNumber.setText(String.valueOf(++m_iMatchNumber));
    }
    
    public void submitData()
    {
        // Bot 1
        m_bot1.setTeamNumber(txBot1Number.getText());
        m_bot1.setBroken(chkBot1Broken.isSelected());
        m_bot1.setDefensive(chkBot1Defensive.isSelected());
        m_bot1.setPenalized(chkBot1Penalized.isSelected());
        m_bot1.setClimbLevel(slBot1ClimbLevel.getValue());
        m_bot1.setComment(txBot1Comments.getText());
        
        // Bot 2
        m_bot2.setTeamNumber(txBot2Number.getText());
        m_bot2.setBroken(chkBot2Broken.isSelected());
        m_bot2.setDefensive(chkBot2Defensive.isSelected());
        m_bot2.setPenalized(chkBot2Penalized.isSelected());
        m_bot2.setClimbLevel(slBot2ClimbLevel.getValue());
        m_bot2.setComment(txBot2Comments.getText());
        
        // Bot 3
        m_bot3.setTeamNumber(txBot3Number.getText());
        m_bot3.setBroken(chkBot3Broken.isSelected());
        m_bot3.setDefensive(chkBot3Defensive.isSelected());
        m_bot3.setPenalized(chkBot3Penalized.isSelected());
        m_bot3.setClimbLevel(slBot3ClimbLevel.getValue());
        m_bot3.setComment(txBot3Comments.getText());
        
        // Bot 4
        m_bot4.setTeamNumber(txBot4Number.getText());
        m_bot4.setBroken(chkBot4Broken.isSelected());
        m_bot4.setDefensive(chkBot4Defensive.isSelected());
        m_bot4.setPenalized(chkBot4Penalized.isSelected());
        m_bot4.setClimbLevel(slBot4ClimbLevel.getValue());
        m_bot4.setComment(txBot4Comments.getText());
        
        // Bot 5
        m_bot5.setTeamNumber(txBot5Number.getText());
        m_bot5.setBroken(chkBot5Broken.isSelected());
        m_bot5.setDefensive(chkBot5Defensive.isSelected());
        m_bot5.setPenalized(chkBot5Penalized.isSelected());
        m_bot5.setClimbLevel(slBot5ClimbLevel.getValue());
        m_bot5.setComment(txBot5Comments.getText());
        
        // Bot 6
        m_bot6.setTeamNumber(txBot6Number.getText());
        m_bot6.setBroken(chkBot6Broken.isSelected());
        m_bot6.setDefensive(chkBot6Defensive.isSelected());
        m_bot6.setPenalized(chkBot6Penalized.isSelected());
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
        
        //openFile(System.getProperty("user.home") + "\\Documents\\Scouting Data\\Match " + txMatchNumber.getText() + ".csv");
        try
        {
            m_iMatchNumber = Integer.parseInt(txMatchNumber.getText());
        }
        
        catch(NumberFormatException e){}
        
        String sMatchNumber = String.valueOf(m_iMatchNumber);
        
        // Open file
        openFile("Scouting Data/Match " + sMatchNumber + ".csv");
        
        // Team red
        writeBotData(sMatchNumber, m_bot1.getTeamNumber(), m_bot1.getAllIntData(), m_bot1.getAllBooleanData(), m_bot1.getComment(), txHuman1.getText(), "red");
        writeBotData(sMatchNumber, m_bot2.getTeamNumber(), m_bot2.getAllIntData(), m_bot2.getAllBooleanData(), m_bot2.getComment(), txHuman1.getText(), "red");
        writeBotData(sMatchNumber, m_bot3.getTeamNumber(), m_bot3.getAllIntData(), m_bot3.getAllBooleanData(), m_bot3.getComment(), txHuman1.getText(), "red");
        
        // Team blue
        writeBotData(sMatchNumber, m_bot4.getTeamNumber(), m_bot4.getAllIntData(), m_bot4.getAllBooleanData(), m_bot4.getComment(), txHuman2.getText(), "blue");
        writeBotData(sMatchNumber, m_bot5.getTeamNumber(), m_bot5.getAllIntData(), m_bot5.getAllBooleanData(), m_bot5.getComment(), txHuman2.getText(), "blue");
        writeBotData(sMatchNumber, m_bot6.getTeamNumber(), m_bot6.getAllIntData(), m_bot6.getAllBooleanData(), m_bot6.getComment(), txHuman2.getText(), "blue");
        
        // Close file
        closeFile();
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
        btSubmit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        slBot1ClimbLevel = new javax.swing.JSlider();
        chkBot1Penalized = new javax.swing.JCheckBox();
        chkBot1Broken = new javax.swing.JCheckBox();
        chkBot1Defensive = new javax.swing.JCheckBox();
        txBot1Comments = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txBot1Number = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        slBot2ClimbLevel = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        chkBot2Broken = new javax.swing.JCheckBox();
        chkBot2Defensive = new javax.swing.JCheckBox();
        chkBot2Penalized = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        txBot2Comments = new javax.swing.JTextField();
        txBot2Number = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        slBot3ClimbLevel = new javax.swing.JSlider();
        chkBot3Defensive = new javax.swing.JCheckBox();
        chkBot3Broken = new javax.swing.JCheckBox();
        chkBot3Penalized = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txBot3Comments = new javax.swing.JTextField();
        txBot3Number = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        slBot4ClimbLevel = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        chkBot4Defensive = new javax.swing.JCheckBox();
        chkBot4Broken = new javax.swing.JCheckBox();
        chkBot4Penalized = new javax.swing.JCheckBox();
        txBot4Comments = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txBot4Number = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        slBot5ClimbLevel = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        chkBot5Defensive = new javax.swing.JCheckBox();
        chkBot5Broken = new javax.swing.JCheckBox();
        chkBot5Penalized = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        txBot5Comments = new javax.swing.JTextField();
        txBot5Number = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        chkBot6Penalized = new javax.swing.JCheckBox();
        chkBot6Broken = new javax.swing.JCheckBox();
        chkBot6Defensive = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        txBot6Comments = new javax.swing.JTextField();
        slBot6ClimbLevel = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        txBot6Number = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txHuman1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txHuman2 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txTeleop = new javax.swing.JTextArea();
        lbTeleop = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txAuto = new javax.swing.JTextArea();
        lbAutonomous = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txMatchNumber = new javax.swing.JTextField();

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

        lbTitle.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        lbTitle.setText("Team 955 Scouting!");

        btSubmit.setText("Submit");
        btSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Climb Level");

        slBot1ClimbLevel.setMajorTickSpacing(1);
        slBot1ClimbLevel.setMaximum(3);
        slBot1ClimbLevel.setPaintLabels(true);
        slBot1ClimbLevel.setValue(0);
        slBot1ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        chkBot1Penalized.setText("Penalized?");

        chkBot1Broken.setText("Broken?");

        chkBot1Defensive.setText("Defensive ?");
        chkBot1Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot1DefensiveActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Comments");

        txBot1Number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txBot1Number.setForeground(new java.awt.Color(255, 0, 0));
        txBot1Number.setText("Bot 1");
        txBot1Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBot1NumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBot1Defensive)
                            .addComponent(chkBot1Penalized)
                            .addComponent(chkBot1Broken))
                        .addGap(120, 120, 120))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(txBot1Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txBot1Number))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(slBot1ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txBot1Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkBot1Defensive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot1Penalized)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot1Broken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slBot1ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txBot1Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        slBot2ClimbLevel.setMajorTickSpacing(1);
        slBot2ClimbLevel.setMaximum(3);
        slBot2ClimbLevel.setPaintLabels(true);
        slBot2ClimbLevel.setValue(0);
        slBot2ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Climb Level");

        chkBot2Broken.setText("Broken?");

        chkBot2Defensive.setText("Defensive ?");
        chkBot2Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot2DefensiveActionPerformed(evt);
            }
        });

        chkBot2Penalized.setText("Penalized?");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Comments");

        txBot2Number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txBot2Number.setForeground(new java.awt.Color(255, 0, 0));
        txBot2Number.setText("Bot 2");
        txBot2Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBot2NumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txBot2Number)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBot2Defensive)
                            .addComponent(chkBot2Broken)
                            .addComponent(chkBot2Penalized)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(slBot2ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txBot2Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txBot2Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chkBot2Defensive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot2Penalized)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot2Broken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slBot2ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txBot2Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Climb Level");

        slBot3ClimbLevel.setMajorTickSpacing(1);
        slBot3ClimbLevel.setMaximum(3);
        slBot3ClimbLevel.setPaintLabels(true);
        slBot3ClimbLevel.setValue(0);
        slBot3ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        chkBot3Defensive.setText("Defensive ?");
        chkBot3Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot3DefensiveActionPerformed(evt);
            }
        });

        chkBot3Broken.setText("Broken?");

        chkBot3Penalized.setText("Penalized?");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Comments");

        txBot3Number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txBot3Number.setForeground(new java.awt.Color(255, 0, 0));
        txBot3Number.setText("Bot 3");
        txBot3Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBot3NumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txBot3Number)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBot3Defensive)
                            .addComponent(chkBot3Broken)
                            .addComponent(chkBot3Penalized)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txBot3Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(slBot3ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(txBot3Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chkBot3Defensive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot3Penalized)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot3Broken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(slBot3ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(7, 7, 7)
                .addComponent(txBot3Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        slBot4ClimbLevel.setMajorTickSpacing(1);
        slBot4ClimbLevel.setMaximum(3);
        slBot4ClimbLevel.setPaintLabels(true);
        slBot4ClimbLevel.setValue(0);
        slBot4ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Climb Level");

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Comments");

        txBot4Number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txBot4Number.setForeground(new java.awt.Color(0, 0, 255));
        txBot4Number.setText("Bot 1");
        txBot4Number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txBot4NumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBot4Defensive)
                            .addComponent(chkBot4Penalized)
                            .addComponent(chkBot4Broken))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(169, 169, 169))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txBot4Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(slBot4ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txBot4Number))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(txBot4Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chkBot4Defensive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot4Penalized)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot4Broken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slBot4ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txBot4Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        slBot5ClimbLevel.setMajorTickSpacing(1);
        slBot5ClimbLevel.setMaximum(3);
        slBot5ClimbLevel.setPaintLabels(true);
        slBot5ClimbLevel.setValue(0);
        slBot5ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Climb Level");

        chkBot5Defensive.setText("Defensive ?");
        chkBot5Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot5DefensiveActionPerformed(evt);
            }
        });

        chkBot5Broken.setText("Broken?");

        chkBot5Penalized.setText("Penalized?");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Comments");

        txBot5Number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txBot5Number.setForeground(new java.awt.Color(0, 0, 255));
        txBot5Number.setText("Bot 2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txBot5Number)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkBot5Defensive)
                                .addComponent(chkBot5Broken)
                                .addComponent(chkBot5Penalized))
                            .addGap(45, 45, 45)))
                    .addComponent(jLabel6)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(slBot5ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txBot5Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(txBot5Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chkBot5Defensive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot5Penalized)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot5Broken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slBot5ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txBot5Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        chkBot6Penalized.setText("Penalized?");

        chkBot6Broken.setText("Broken?");

        chkBot6Defensive.setText("Defensive ?");
        chkBot6Defensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBot6DefensiveActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Comments");

        slBot6ClimbLevel.setMajorTickSpacing(1);
        slBot6ClimbLevel.setMaximum(3);
        slBot6ClimbLevel.setPaintLabels(true);
        slBot6ClimbLevel.setValue(0);
        slBot6ClimbLevel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Climb Level");

        txBot6Number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txBot6Number.setForeground(new java.awt.Color(0, 0, 255));
        txBot6Number.setText("Bot 3");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkBot6Defensive)
                                    .addComponent(chkBot6Broken)
                                    .addComponent(chkBot6Penalized)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(slBot6ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txBot6Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txBot6Number)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(txBot6Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(chkBot6Defensive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot6Penalized)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBot6Broken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slBot6ClimbLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txBot6Comments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Human Scored");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txHuman1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txHuman1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Human Scored");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txHuman2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txHuman2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txTeleop.setColumns(20);
        txTeleop.setRows(5);
        jScrollPane1.setViewportView(txTeleop);

        lbTeleop.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTeleop.setText("Teleop");

        txAuto.setColumns(20);
        txAuto.setRows(5);
        jScrollPane2.setViewportView(txAuto);

        lbAutonomous.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbAutonomous.setText("Autonomous");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAutonomous, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTeleop, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 539, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbAutonomous)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTeleop, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Match Number:");

        txMatchNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txMatchNumber.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txMatchNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(txMatchNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(320, 320, 320)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(135, 135, 135)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(412, 412, 412))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))))
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

    private void txBot1NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBot1NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBot1NumberActionPerformed

    private void txBot2NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBot2NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBot2NumberActionPerformed

    private void txBot3NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBot3NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBot3NumberActionPerformed

    private void txBot4NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBot4NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBot4NumberActionPerformed

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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAutonomous;
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
    private javax.swing.JTextField txBot1Number;
    private javax.swing.JTextField txBot2Comments;
    private javax.swing.JTextField txBot2Number;
    private javax.swing.JTextField txBot3Comments;
    private javax.swing.JTextField txBot3Number;
    private javax.swing.JTextField txBot4Comments;
    private javax.swing.JTextField txBot4Number;
    private javax.swing.JTextField txBot5Comments;
    private javax.swing.JTextField txBot5Number;
    private javax.swing.JTextField txBot6Comments;
    private javax.swing.JTextField txBot6Number;
    private javax.swing.JTextField txHuman1;
    private javax.swing.JTextField txHuman2;
    private javax.swing.JTextField txMatchNumber;
    private javax.swing.JTextArea txTeleop;
    // End of variables declaration//GEN-END:variables
}
