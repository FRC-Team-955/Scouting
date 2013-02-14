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
    private boolean m_bDefensive = false;
    private boolean m_bPenalized = false;
    private boolean m_bBroken = false;
    private int m_iHighGoalAuto = 0;
    private int m_iMiddleGoalAuto = 0;
    private int m_iLowGoalAuto = 0;
    private int m_iDumpGoalAuto = 0;
    private int m_iClimbLevel = 0;
    private String m_sFeedTime = "0";
    
    public void setDefensive(boolean bVal)
    {
        m_bDefensive = bVal;
    }
    
    public void setPenalized(boolean bVal)
    {
        m_bPenalized = bVal;
    }
    
    public void setBroken(boolean bVal)
    {
        m_bBroken = bVal;
    }
    
    public void setHighGoalShotsAuto(int iShots)
    {
        m_iHighGoalAuto = iShots;
    }
    
    public void setMiddleGoalShotsAuto(int iShots)
    {
        m_iMiddleGoalAuto = iShots;
    }
    
    public void setLowGoalShotsAuto(int iShots)
    {
        m_iLowGoalAuto = iShots;
    }
    
    public void setDumpGoalShotsAuto(int iShots)
    {
        m_iDumpGoalAuto = iShots;
    }
    
    public void setClimbLevel(int iLevel)
    {
        m_iClimbLevel = iLevel;
    }
    
    public void setFeedTime(String sTime)
    {
        m_sFeedTime = sTime;
    }
    
    public boolean getDefensive()
    {
        return m_bDefensive;
    }
    
    public boolean getPenalized()
    {
        return m_bPenalized;
    }
    
    public boolean getBroken()
    {
        return m_bBroken;
    }
    
    public int getHighGoalShotsAuto()
    {
        return m_iHighGoalAuto;
    }
    
    public int getMiddleGoalShotsAuto()
    {
        return m_iMiddleGoalAuto;
    }
    
    public int getLowGoalShotsAuto()
    {
        return m_iLowGoalAuto;
    }
    
    public int getDumpGoalShotsAuto()
    {
        return m_iDumpGoalAuto;
    }
    
    public int getClimbLevel()
    {
        return m_iClimbLevel;
    }
    
    public String getFeedTime()
    {
        return m_sFeedTime;
    }
    
    public void reset()
    {
        m_bDefensive = false;
        m_bPenalized = false;
        m_bBroken = false;
        m_iHighGoalAuto = 0;
        m_iMiddleGoalAuto = 0;
        m_iLowGoalAuto = 0;
        m_iDumpGoalAuto = 0;
        m_iClimbLevel = 0;
        m_sFeedTime = "";
    }
}
