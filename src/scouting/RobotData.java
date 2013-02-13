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
    private int m_iTotalShots = 0;
    private int m_iHighGoal = 0;
    private int m_iMiddleGoal = 0;
    private int m_iLowGoal = 0;
    private int m_iDumpGoal = 0;
    private int m_iClimbLevel = 0;
    
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
    
    public void setTotalShots(int iTotalShots)
    {
        m_iTotalShots = iTotalShots;
    }
    
    public void setHighGoalShots(int iShots)
    {
        m_iHighGoal = iShots;
    }
    
    public void setMiddleGoalShots(int iShots)
    {
        m_iMiddleGoal = iShots;
    }
    
    public void setLowGoalShots(int iShots)
    {
        m_iLowGoal = iShots;
    }
    
    public void setDumpGoalShots(int iShots)
    {
        m_iDumpGoal = iShots;
    }
    
    public void setClimbLevel(int iLevel)
    {
        m_iClimbLevel = iLevel;
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
    
    public int getTotalShots()
    {
        return m_iTotalShots;
    }
    
    public int getHighGoalShots()
    {
        return m_iHighGoal;
    }
    
    public int getMiddleGoalShots()
    {
        return m_iMiddleGoal;
    }
    
    public int getLowGoalShots()
    {
        return m_iLowGoal;
    }
    
    public int getDumpGoalShots()
    {
        return m_iDumpGoal;
    }
    
    public int getClimbLevel()
    {
        return m_iClimbLevel;
    }
    
    public void reset()
    {
        m_bDefensive = false;
        m_bPenalized = false;
        m_bBroken = false;
        m_iTotalShots = 0;
        m_iHighGoal = 0;
        m_iMiddleGoal = 0;
        m_iLowGoal = 0;
        m_iDumpGoal = 0;
        m_iClimbLevel = 0;
    }
}
