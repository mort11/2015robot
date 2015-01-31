package org.mort11.subsystems.ee;

import org.mort11.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    
    
	DoubleSolenoid clawSol	= new DoubleSolenoid(RobotMap.CLAW_IN, RobotMap.CLAW_OUT);
	boolean isClosed = true;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setClaw(boolean closed)
    {
    	if(closed){
    		clawSol.set(DoubleSolenoid.Value.kForward);
    	} else {
    		clawSol.set(DoubleSolenoid.Value.kReverse);
    	}
    	isClosed = closed;
    }
    public boolean getClawState()
    {
    	return isClosed;
    }
}

