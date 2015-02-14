package org.mort11.commands.dt;

import org.mort11.Robot;
import org.mort11.subsystems.dt.DTSide;
import org.mort11.subsystems.dt.LeftDT;
import org.mort11.subsystems.dt.RightDT;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackwards extends Command {

	private double driveDistance;
	private double leftSpeed;
	private double rightSpeed;
	private DTSide left = Robot.left;
	private DTSide right = Robot.right;

	public DriveBackwards() {
		requires(left);
		requires(right);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	public DriveBackwards(double driveDistance, double leftSpeed,
			double rightSpeed) {
		this.driveDistance = driveDistance;
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		right.resetEnc();
		left.resetEnc();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		right.set(this.rightSpeed);
		left.set(this.leftSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (right.getDist() < driveDistance
				&& left.getDist() < driveDistance)
			return false;
		else
			return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("Finished.");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
