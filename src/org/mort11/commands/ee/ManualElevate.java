package org.mort11.commands.ee;

import static org.mort11.Robot.elevator;
import static org.mort11.Robot.oi;

import org.mort11.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevate extends Command {

	public ManualElevate() {
		requires(elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// TODO - some form of PID Control?
		elevator.setSpeed(oi.getEEJoyThrottle());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return elevator.getLimSwitch();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.brake.setSolenoid(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		// cri
	}
}
