package org.mort11.commands.ee;

import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseClaw extends Command {

	boolean isClosed;
	private PneumaticSubsystem claw = Robot.claw;

	public CloseClaw(boolean isClosed) {
		this.isClosed = isClosed;
		requires(claw);
		// Use requires() here to declare subsystem dependencies
		// );
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.claw.setSolenoid(isClosed);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
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
