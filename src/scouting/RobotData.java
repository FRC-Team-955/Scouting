/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scouting;

/**
 *
 * @author Fauzi
 */
public class RobotData 
{
    private int m_iDataLengthBoolean = 3;
    private boolean m_bDataArray[] = new boolean[m_iDataLengthBoolean];
    private int m_iDefensive = 0;
    private int m_iPenalized = 1;
    private int m_iBroken = 2;
    private int m_iDataLengthInt = 8;
    private int m_iDataArray[] = new int[m_iDataLengthInt];
    private int m_iHighGoalAuto = 0;
    private int m_iMiddleGoalAuto = 1;
    private int m_iLowGoalAuto = 2;
    private int m_iHighGoalTeleop = 3;
    private int m_iMiddleGoalTeleop = 4;
    private int m_iLowGoalTeleop = 5;
    private int m_iPryamidGoal = 6;
    private int m_iClimbLevel = 7;
    private String m_sComments = "";
    
    public void setDefensive(boolean bVal)
    {
        m_bDataArray[m_iDefensive] = bVal;
    }
    
    public void setPenalized(boolean bVal)
    {
        m_bDataArray[m_iPenalized] = bVal;
    }
    
    public void setBroken(boolean bVal)
    {
        m_bDataArray[m_iBroken] = bVal;
    }
    
    public void setHighGoalShotsAuto(int iShots)
    {
        m_iDataArray[m_iLowGoalAuto] = iShots;
    }
    
    public void setMiddleGoalShotsAuto(int iShots)
    {
        m_iDataArray[m_iMiddleGoalAuto] = iShots;
    }
    
    public void setLowGoalShotsAuto(int iShots)
    {
        m_iDataArray[m_iLowGoalAuto] = iShots;
    }
    
    public void setHighGoalShotsTeleop(int iShots)
    {
        m_iDataArray[m_iHighGoalTeleop] = iShots;
    }
    
    public void setMiddleGoalShotsTeleop(int iShots)
    {
        m_iDataArray[m_iMiddleGoalTeleop] = iShots;
    }
    
    public void setLowGoalShotsTeleop(int iShots)
    {
        m_iDataArray[m_iLowGoalTeleop] = iShots;
    }
    
    public void setPryamidGoalShots(int iShots)
    {
        m_iDataArray[m_iPryamidGoal] = iShots;
    }
    
    public void setClimbLevel(int iLevel)
    {
        m_iDataArray[m_iClimbLevel] = iLevel;
    }
    
    public void setComment(String sComment)
    {
        m_sComments = sComment;
    }
    
    public boolean getDefensive()
    {
        return m_bDataArray[m_iDefensive];
    }
    
    public boolean getPenalized()
    {
        return m_bDataArray[m_iPenalized];
    }
    
    public boolean getBroken()
    {
        return m_bDataArray[m_iBroken];
    }
    
    public int getHighGoalShotsAuto()
    {
        return m_iDataArray[m_iHighGoalAuto];
    }
    
    public int getMiddleGoalShotsAuto()
    {
        return m_iDataArray[m_iMiddleGoalAuto];
    }
    
    public int getLowGoalShotsAuto()
    {
        return m_iDataArray[m_iLowGoalAuto];
    }
    
    public int getHighGoalShotsTeleop()
    {
        return m_iDataArray[m_iHighGoalTeleop];
    }
    
    public int getMiddleGoalShotsTeleop()
    {
        return m_iDataArray[m_iMiddleGoalTeleop];
    }
    
    public int getLowGoalShotsTeleop()
    {
        return m_iDataArray[m_iLowGoalTeleop];
    }
    
    public int getPryamidGoalShots()
    {
        return m_iDataArray[m_iPryamidGoal];
    }
    
    public int getClimbLevel()
    {
        return m_iDataArray[m_iClimbLevel];
    }
    
    public String getComment()
    {
        return m_sComments;
    }
    
    public boolean[] getAllBooleanData()
    {
        return m_bDataArray;
    }
    
    public int[] getAllIntData()
    {
        return m_iDataArray;
    }
    
    public void reset()
    {
        for(int index = 0; index < m_iDataLengthBoolean; index++)
            m_bDataArray[index] = false;
            
        for(int index = 0; index < m_iDataLengthInt; index++)
            m_iDataArray[index] = 0;
            
        m_sComments = "";
    }
}
