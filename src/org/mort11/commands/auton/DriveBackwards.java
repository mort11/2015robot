package org.mort11.commands.auton;

import org.mort11.Robot;
import org.mort11.subsystems.dt.LeftDT;
import org.mort11.subsystems.dt.RightDT;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackwards extends Command {

	public DriveBackwards() {
		requires(Robot.left);
		requires(Robot.right);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RightDT.resetEnc();
		LeftDT.resetEnc();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (RightDT.getDist() < 10000) {
			Robot.right.set(0.5);
			Robot.left.set(-0.5);
		} else
			isFinished();
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
