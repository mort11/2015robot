package org.mort11.subsystems.dt;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.RobotMap;
import org.mort11.commands.dt.DriveLinear;

/**
 *
 */
public class LeftDT extends DTSide 
{
	public LeftDT()
	{
		super(RobotMap.DT_LEFT_PORT, RobotMap.DT_ENC_LEFT_A, RobotMap.DT_ENC_LEFT_B, true, false);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//setDefaultCommand();
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	protected DriveLinear getLinearDrive() {
		// TODO Auto-generated method stub
		return null;
	}
}

