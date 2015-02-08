package org.mort11.commands.auton;

import org.mort11.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Called after robot has moved backwards, at the end of autonomous
 *
 */
public class RetractArms extends Command {

	Timer time = new Timer();

	public RetractArms() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.autonLeft);
		requires(Robot.autonRight);
		requires(Robot.autonArmUp);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.autonArmUp.setSolenoid(false);
		time.start();
		if (time.get() >= .5) {
			Robot.autonLeft.setSolenoid(false);
			Robot.autonRight.setSolenoid(false);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
