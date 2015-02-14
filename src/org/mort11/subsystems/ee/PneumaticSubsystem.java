package org.mort11.subsystems.ee;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticSubsystem extends Subsystem {
	DoubleSolenoid sol;
	boolean engaged; // tbd (assumed to be closed)
	public PneumaticSubsystem(int engagedPort, int notEngagedPort) {
		sol = new DoubleSolenoid(engagedPort, notEngagedPort);
		engaged = false;
	}


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setSolenoid(boolean engage) {
		if (engage) {
			sol.set(DoubleSolenoid.Value.kForward); // tbd
		} else {
			sol.set(DoubleSolenoid.Value.kReverse); // tbd
		}
		engaged = engage;
		System.out.println("state 2: " + engage);
	}

	public boolean isEngaged() {
		return engaged;
	}
}
