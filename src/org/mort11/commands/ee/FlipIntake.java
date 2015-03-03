package org.mort11.commands.ee;

import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlipIntake extends Command {

	boolean isClosed = true; //idk
	private PneumaticSubsystem intake = Robot.PneumaticIntake;

	
	public FlipIntake(boolean isClosed) {
		this.isClosed = isClosed;
		requires(Robot.PneumaticIntake);
		// Use requires() here to declare subsystem dependencies
		// );
	}
	public FlipIntake()
	{
		requires(intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println(intake.isEngaged() + " intake eng");
		intake.setSolenoid(!intake.isEngaged());
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
