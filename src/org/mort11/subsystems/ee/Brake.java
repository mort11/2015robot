package org.mort11.subsystems.ee;

import org.mort11.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Brake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid brake = new DoubleSolenoid(RobotMap.BREAK_OUT, RobotMap.BREAK_IN);
	boolean isBreakOff = true;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setBrake(boolean off)
    {
    	if(off) {
    		brake.set(DoubleSolenoid.Value.kReverse);
    	} else {
    		brake.set(DoubleSolenoid.Value.kForward);
    	}
    	isBreakOff = off;
    }
    public boolean getBrakeState()
    {
    	return isBreakOff;
    }
}

