package org.mort11.commands.ee;

import static org.mort11.Robot.elevator;

import org.mort11.OI;
import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.subsystems.ee.VerticalActuator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevate extends Command {
	private VerticalActuator moveElevator = Robot.elevator;
	private PneumaticSubsystem brake = Robot.brake;
	private OI oi = Robot.oi;

	public ManualElevate() {
		requires(elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// TODO - some form of PID Control?
		moveElevator.setSpeed(oi.getEEJoy());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return elevator.getBottomLim();
	}

	// Called once after isFinished returns true
	protected void end() {
		brake.setSolenoid(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		// cri
	}
}
