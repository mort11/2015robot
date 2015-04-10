package org.mort11.commands.ee;

import org.mort11.Robot;
import org.mort11.subsystems.ee.ActiveIntake;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.subsystems.ee.VerticalActuator;
import org.mort11.util.EEConstants;

import edu.wpi.first.wpilibj.command.Command;

public class ElevateToHeight extends Command {
	double desiredHeight;
	private VerticalActuator elevator = Robot.elevator;
	private PneumaticSubsystem brake = Robot.brake;
	private ActiveIntake intakeLeft = Robot.leftIntake;
	private ActiveIntake intakeRight = Robot.rightIntake;
	private PneumaticSubsystem intake = Robot.PneumaticIntake;

	/**
	 * 
	 * @param desiredHeight
	 *            number of totes the elevator should rise
	 */
	public ElevateToHeight(double desiredHeight) {
		this.desiredHeight = desiredHeight * EEConstants.TOTES_TO_INCHES;
		requires(elevator);
		requires(brake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		brake.setSolenoid(false);
		setInterruptible(true);
		Robot.PneumaticIntake.setSolenoid(true);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println(elevator.getHeight() + " height");
		System.out.println(desiredHeight + " goal");
		System.out.println(elevator.getTopLim());
		// if (elevator.getHeight() < EEConstants.OPEN_INTAKE_HIGHT) {
		// intake.setSolenoid(intake.isEngaged() == false);
		// }
	    if (desiredHeight > elevator.getHeight()) {
			elevator.setSpeed(EEConstants.ESCALATION_SPEED);
		} else {
			elevator.setSpeed(-EEConstants.LOWERING_SPEED);
		}
		Robot.PneumaticIntake.setSolenoid(true);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// epsilon compare on robot height/limitswitch tripped
		return (Math.abs(Robot.elevator.getHeight() - desiredHeight) < 0.5 || checkDirection());
	}

	// Called once after isFinished returns true
	protected void end() {
		if (elevator.getBottomLim()) {
			elevator.resetEnc();
		}
		Robot.elevator.setSpeed(0);
		brake.setSolenoid(true);
	}

	// makes sure we aren't heading in the same way as the switch
	private boolean checkDirection() {
		return (elevator.getBottomLim() && desiredHeight < Robot.elevator
				.getHeight())
				|| (elevator.getTopLim() && desiredHeight > Robot.elevator
						.getHeight());

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
