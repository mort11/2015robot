package org.mort11.commands.auton;

import org.mort11.Robot;
import org.mort11.subsystems.dt.LeftDT;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnWithEncoders extends Command {
	double speed;

	public TurnWithEncoders(double speed) {
		this.speed = speed;
		requires(Robot.left);
		requires(Robot.right);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		LeftDT.resetEnc();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.left.set(-speed);
		Robot.right.set(speed);
		System.out.println(LeftDT.getDist());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (LeftDT.getDist() >= -10)
			return false;
		else
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
