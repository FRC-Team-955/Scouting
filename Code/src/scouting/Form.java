
package scouting;
import java.awt.Color;
import javax.swing.*;
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
    static int m_iMatchNumber = 1;
    static final int m_iAmountOfBots = 3;
    static String m_sColor = "blue";
    static FileWriter writer;
    
    // keyArray Format: low, mid, high, pyramid
    static char m_cBotKeys[][] = {
        {'q', 'a', 'z', '1'}, 
        {'w', 's', 'x', '2'}, 
        {'e', 'd', 'c', '3'}}; 
    
    // Data for bots starts ----------------------------------------------------
    static int m_iBotScoreDataAuto[][] = {
        {0, 0, 0, 0}, 
        {0, 0, 0, 0}, 
        {0, 0, 0, 0}};
    
    static int m_iBotScoreDataTeleop[][] = {
        {0, 0, 0, 0}, 
        {0, 0, 0, 0}, 
        {0, 0, 0, 0}};
    
    static int m_iBotClimbData[] = {0, 0, 0};
    
    static boolean m_bBotBooleanData[][] = {
        {false, false, false}, 
        {false, false, false}, 
        {false, false, false}};
    
    static String m_sBotStringData[][] = {
        {"", ""}, 
        {"", ""},
        {"", ""}};
    // Data for bots end -------------------------------------------------------
    
    
    // Bot defensive, broken, penalized
    JCheckBox[][] m_checkBoxes;
    
    // Bot Climb level 
    JSlider[] m_sliders;
    
    // Team numbers, comments
    JTextField[][] m_textBoxes;
    
    /**
     * Creates new form Form
     */
    public Form() 
    {
        initComponents(); 
        
        m_checkBoxes = new JCheckBox[][]{
            {chkBot1Defensive, chkBot1Penalized, chkBot1Broken},
            {chkBot2Defensive, chkBot2Penalized, chkBot2Broken},
            {chkBot3Defensive, chkBot3Penalized, chkBot3Broken}};         
        
        m_sliders = new JSlider[] 
            {slBot1ClimbLevel, slBot2ClimbLevel, slBot3ClimbLevel};
        
        m_textBoxes = new JTextField[][]{
            {txBot1Number, txBot1Comments}, 
            {txBot2Number, txBot2Comments},
            {txBot3Number, txBot3Comments}};
    }
    
    // Combines two int arrays
    public static int[] combineIntArrays(int iArrayOne[], int iArrayTwo[], int iNum)
    {
        int[] iReturnArray = new int[iArrayOne.length + iArrayTwo.length + 1];
        int index = -1;
        
        while(++index < iArrayOne.length)
            iReturnArray[index] = iArrayOne[index];
        
        index--;
        
        while(++index < iArrayOne.length + iArrayTwo.length)
            iReturnArray[index] = iArrayTwo[index - iArrayOne.length];
        
        iReturnArray[index] = iNum;
        
        return iReturnArray;
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
     
    public static String eraseComma(String sData)
    {
        String sNoComma = "";
        
        for(int i = 0; i < sData.length(); i++)
            if(sData.charAt(i) != ',')
                sNoComma += sData.charAt(i);
        
        return sNoComma;
    }
     
    public static void writeBotData(String sMatch, String sColor, String sHumanScore, String sArray[], int iArray[], boolean bArray[])
    {  
        try
        {
            // Take out all commas, write string
            writer.append(eraseComma(sMatch));
            writer.append(",");
            
            writer.append(eraseComma(sColor));
            writer.append(",");
            
            writer.append(eraseComma(sHumanScore));
            writer.append(",");
            
            for(int index = 0; index < sArray.length; index++)
            {
                sArray[index] = eraseComma(sArray[index]);
                writer.append(sArray[index]);
                writer.append(",");
            }
            
            // Write ints
            for(int index = 0; index < iArray.length; index++)
            {
                writer.append(String.valueOf(iArray[index]));
                writer.append(",");
            }
            
            // Write booleans
            for(int index = 0; index < bArray.length; index++)
            {              
                writer.append(String.valueOf(bArray[index]));
                writer.append(",");
            }
            
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
        
        for(int iOuter = 0; iOuter < m_iBotScoreDataAuto.length; iOuter++)
            for(int iInner = 0; iInner < m_iBotScoreDataAuto[iOuter].length; iInner++)
                m_iBotScoreDataAuto[iOuter][iInner] = 0;
        
        for(int iOuter = 0; iOuter < m_iBotScoreDataTeleop.length; iOuter++)
            for(int iInner = 0; iInner < m_iBotScoreDataTeleop[iOuter].length; iInner++)
                m_iBotScoreDataTeleop[iOuter][iInner] = 0;
        
        for(int index = 0; index < m_iBotClimbData.length; index++)
            m_iBotClimbData[index] = 0;
        
        for(int iOuter = 0; iOuter < m_bBotBooleanData.length; iOuter++)
            for(int iInner = 0; iInner < m_bBotBooleanData[iOuter].length; iInner++)
                m_bBotBooleanData[iOuter][iInner] = false;
        
        for(int iOuter = 0; iOuter < m_sBotStringData.length; iOuter++)
            for(int iInner = 0; iInner < m_sBotStringData[iOuter].length; iInner++)
                m_sBotStringData[iOuter][iInner] = "";
                
        for(int iOuter = 0; iOuter < m_checkBoxes.length; iOuter++)
            for(int iInner = 0; iInner < m_checkBoxes[iOuter].length; iInner++)
                m_checkBoxes[iOuter][iInner].setSelected(false);
        
        for(int iOuter = 0; iOuter < m_textBoxes.length; iOuter++)
            for(int iInner = 0; iInner < m_textBoxes[iOuter].length; iInner++)
                m_textBoxes[iOuter][iInner].setText("");
        
        for(int index = 0; index < m_sliders.length; index++)
            m_sliders[index].setValue(0);
        
        txBot1Number.setText("Bot 1");
        txBot2Number.setText("Bot 2");
        txBot3Number.setText("Bot 3");
        
        txAuto.setText("");
        txTeleop.setText("");
        txHuman1.setText("");
        txMatchNumber.setText(String.valueOf(++m_iMatchNumber));
    }
    
    public void submitData()
    {
        for(int iOuter = 0; iOuter < m_checkBoxes.length; iOuter++)
            for(int iInner = 0; iInner < m_checkBoxes[iOuter].length; iInner++)
                m_bBotBooleanData[iOuter][iInner] = m_checkBoxes[iOuter][iInner].isSelected();
        
        for(int iOuter = 0; iOuter < m_textBoxes.length; iOuter++)
            for(int iInner = 0; iInner < m_textBoxes[iOuter].length; iInner++)
                m_sBotStringData[iOuter][iInner] = m_textBoxes[iOuter][iInner].getText();
        
        for(int index = 0; index < m_sliders.length; index++)
            m_iBotClimbData[index] = m_sliders[index].getValue();
        
        
        String sDataAuto = txAuto.getText();
        String sDataTeleop = txTeleop.getText();
        
        for(int iBot = 0; iBot < m_cBotKeys.length; iBot++)
        {    
            for(int iKey = 0; iKey < m_cBotKeys[iBot].length; iKey++)
            {    
                for(int iDataAutoIndex = 0; iDataAutoIndex < sDataAuto.length(); iDataAutoIndex++)
                {
                    if(m_cBotKeys[iBot][iKey] == sDataAuto.charAt(iDataAutoIndex))
                        m_iBotScoreDataAuto[iBot][iKey]++;
                }
                
                for(int iDataTeleopIndex = 0; iDataTeleopIndex < sDataTeleop.length(); iDataTeleopIndex++)
                {
                    if(m_cBotKeys[iBot][iKey] == sDataTeleop.charAt(iDataTeleopIndex))
                        m_iBotScoreDataTeleop[iBot][iKey]++;
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
        openFile("Scouting Data/Match " + sMatchNumber  + m_sColor + ".csv");
        
        // Write data to files.
        for(int index = 0; index < m_iAmountOfBots; index++)       
            writeBotData(sMatchNumber, m_sColor, txHuman1.getText(), m_sBotStringData[index], combineIntArrays(m_iBotScoreDataAuto[index], m_iBotScoreDataTeleop[index], m_iBotClimbData[index]), m_bBotBooleanData[index]);

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
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txHuman1 = new javax.swing.JTextField();
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
        jPanel11 = new javax.swing.JPanel();
        chkRedAlliance = new javax.swing.JCheckBox();

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
        txBot1Number.setForeground(java.awt.Color.blue);
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
        txBot2Number.setForeground(java.awt.Color.blue);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        txBot3Number.setForeground(java.awt.Color.blue);
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
        txMatchNumber.setText("1");

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

        chkRedAlliance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        chkRedAlliance.setText("Red Alliance?");
        chkRedAlliance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRedAllianceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkRedAlliance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkRedAlliance, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(btSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(66, 66, 66)
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

    private void txBot1NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBot1NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBot1NumberActionPerformed

    private void txBot2NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBot2NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBot2NumberActionPerformed

    private void txBot3NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txBot3NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txBot3NumberActionPerformed

    private void chkRedAllianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRedAllianceActionPerformed
        // TODO add your handling code here:
        if(chkRedAlliance.isSelected())
        {
            m_sColor = "red";
            txBot1Number.setForeground(Color.red);
            txBot2Number.setForeground(Color.red);
            txBot3Number.setForeground(Color.red);
        }
        
        else 
        {
            m_sColor = "blue";
            txBot1Number.setForeground(Color.blue);
            txBot2Number.setForeground(Color.blue);
            txBot3Number.setForeground(Color.blue);
        }
    }//GEN-LAST:event_chkRedAllianceActionPerformed

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
    private javax.swing.JCheckBox chkRedAlliance;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAutonomous;
    private javax.swing.JLabel lbTeleop;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JSlider slBot1ClimbLevel;
    private javax.swing.JSlider slBot2ClimbLevel;
    private javax.swing.JSlider slBot3ClimbLevel;
    private javax.swing.JTextArea txAuto;
    private javax.swing.JTextField txBot1Comments;
    private javax.swing.JTextField txBot1Number;
    private javax.swing.JTextField txBot2Comments;
    private javax.swing.JTextField txBot2Number;
    private javax.swing.JTextField txBot3Comments;
    private javax.swing.JTextField txBot3Number;
    private javax.swing.JTextField txHuman1;
    private javax.swing.JTextField txMatchNumber;
    private javax.swing.JTextArea txTeleop;
    // End of variables declaration//GEN-END:variables
}
