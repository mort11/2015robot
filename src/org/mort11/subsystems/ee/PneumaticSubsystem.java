package org.mort11.subsystems.ee;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticSubsystem extends Subsystem {
	DoubleSolenoid sol;

	public PneumaticSubsystem(int engagedPort, int notEngagedPort) {
		// sol = new DoubleSolenoid(engagedPort, notEngagedPort);
	}

	boolean engaged = true; // tbd (assumed to be closed)

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setSolenoid(boolean engage) {
		if (engage) {
			// sol.set(DoubleSolenoid.Value.kForward); // tbd
		} else {
			// sol.set(DoubleSolenoid.Value.kReverse); // tbd
		}
		engaged = engage;
	}

	public boolean isEngaged() {
		return engaged;
	}
}
