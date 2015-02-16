package org.mort11.commands.ee;

import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorBrake extends Command {
	private boolean isBrakeOn;
	private PneumaticSubsystem brake = Robot.brake;
	//this is bad but i want to test before using this constructor
	public ElevatorBrake(boolean isBrakeOn) {
		this.isBrakeOn = isBrakeOn;
		requires(brake);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chasssis);
	}
	public ElevatorBrake()
	{
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		brake.setSolenoid(!brake.isEngaged());
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
