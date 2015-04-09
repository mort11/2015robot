package org.mort11.commands.ee;

import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.subsystems.ee.VerticalActuator;
import org.mort11.util.EEConstants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Zero extends Command {
	private VerticalActuator elevator = Robot.elevator;
	private PneumaticSubsystem brake = Robot.brake;
	private PneumaticSubsystem intake = Robot.PneumaticIntake;

	public Zero() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(elevator);
		requires(brake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.brake.setSolenoid(false);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevator.setSpeed(-EEConstants.LOWERING_SPEED);
		Robot.PneumaticIntake.setSolenoid(true);
		System.out.println(elevator.getBottomLim());
		// if (elevator.getHeight() < EEConstants.OPEN_INTAKE_HIGHT) {
		// intake.setSolenoid(intake.isEngaged() == false);
		// }
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return elevator.getBottomLim();
	}

	// Called once after isFinished returns true
	protected void end() {
		elevator.setSpeed(0);
		elevator.resetEnc();
		System.out.println("zeroed");
		brake.setSolenoid(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
