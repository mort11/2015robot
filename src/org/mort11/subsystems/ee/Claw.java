package org.mort11.subsystems.ee;

import org.mort11.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {    
	DoubleSolenoid clawSol	= new DoubleSolenoid(RobotMap.CLAW_CLOSED,
			RobotMap.CLAW_OPEN);
	boolean isClosed = true; //tbd (assumed to be closed)
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setClawClosed(boolean closed)
    {
    	if(closed){
    		clawSol.set(DoubleSolenoid.Value.kForward); //tbd
    	} else {
    		clawSol.set(DoubleSolenoid.Value.kReverse); //tbd
    	}
    	isClosed = closed;
    }
    public boolean isClawClosed()
    {
    	return isClosed;
    }
}

