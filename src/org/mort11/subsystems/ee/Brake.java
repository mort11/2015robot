package org.mort11.subsystems.ee;

import org.mort11.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Brake extends Subsystem {
	DoubleSolenoid brake = new DoubleSolenoid(RobotMap.BRAKE_DISENGAGED, 
			RobotMap.BRAKE_ENGAGED);
	boolean isBreakOn = false;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setBrake(boolean on)
    {
    	if(on) {
    		brake.set(DoubleSolenoid.Value.kForward);
    	} else {
    		brake.set(DoubleSolenoid.Value.kReverse);
    	}
    	isBreakOn = on;
    }
    public boolean getBrakeState()
    {
    	return isBreakOn;
    }
}

