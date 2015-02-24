package org.mort11.subsystems.ee;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ActiveIntake extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private Talon motors;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public ActiveIntake(int talPort) {
		motors = new Talon(talPort);
	}

	public void set(double speed) {
		motors.set(speed);
	}
}
