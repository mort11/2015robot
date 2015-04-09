package org.mort11.commands.ee;

import org.mort11.Robot;
import org.mort11.subsystems.ee.ActiveIntake;
import org.mort11.subsystems.ee.ActiveIntakeLeft;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeBoth extends Command {
	double speed;
	private ActiveIntakeLeft intakeLeft = Robot.leftIntake;
	private ActiveIntake intakeRight = Robot.rightIntake;
	boolean initState;
	public IntakeBoth(double speed) {
		requires(intakeLeft);
		requires(intakeRight);
		this.speed = speed;
		this.initState = Robot.PneumaticIntake.isEngaged();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setInterruptible(true);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println(speed);
		if(/*intakeLeft.getSwitch() && !initState*/false  ) {
			//Robot.PneumaticIntake.setSolenoid(!Robot.PneumaticIntake.isEngaged());
			intakeLeft.set(0);
			intakeRight.set(0);
			System.out.println("hit");
		} else {
			intakeLeft.set(speed);
			intakeRight.set(speed);
		}
		initState = Robot.PneumaticIntake.isEngaged();
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
