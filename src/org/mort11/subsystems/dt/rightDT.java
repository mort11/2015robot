package org.mort11.subsystems.dt;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.RobotMap;
/**
 *
 */
public class rightDT extends DTSide 
{
	public rightDT()
	{
		super(RobotMap.DT_RIGHT_PORT, RobotMap.DT_ENC_RIGHT_A,RobotMap.DT_ENC_RIGHT_B,false, true);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() 
    {
    	//setDefaultCommand();	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}