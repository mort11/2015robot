package org.mort11.commands.ee;

import org.mort11.Robot;
import org.mort11.subsystems.ee.ActiveIntake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeLeft extends Command {
	double speed;
	private ActiveIntake intakeLeft = Robot.leftIntake;

	public IntakeLeft(double speed) {
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		intakeLeft.set(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
