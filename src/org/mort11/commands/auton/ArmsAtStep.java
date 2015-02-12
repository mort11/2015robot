package org.mort11.commands.auton;

import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Called in auton after the robot reaches the step
 *
 */
public class ArmsAtStep extends Command {
	private PneumaticSubsystem armUp = Robot.autonArmUp;
	private PneumaticSubsystem leftArm = Robot.autonLeft;
	private PneumaticSubsystem rightArm = Robot.autonRight;

	public ArmsAtStep() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(armUp);
		requires(leftArm);
		requires(rightArm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		armUp.setSolenoid(true);// tbd does true mean the solenoid is
								// being put out?
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
