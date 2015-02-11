package org.mort11.commands.auton;

import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Called after robot has moved backwards, at the end of autonomous
 *
 */
public class RetractArms extends Command {

	private PneumaticSubsystem armUp = Robot.autonArmUp;
	private PneumaticSubsystem leftArm = Robot.autonLeft;
	private PneumaticSubsystem rightArm = Robot.autonRight;
	Timer time = new Timer();

	public RetractArms() {
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
		armUp.setSolenoid(false);
		time.start();
		if (time.get() >= .5) {
			leftArm.setSolenoid(false);
			rightArm.setSolenoid(false);
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
