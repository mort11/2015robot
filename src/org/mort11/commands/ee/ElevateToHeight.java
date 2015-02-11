package org.mort11.commands.ee;

import static org.mort11.Robot.elevator;

import org.mort11.Robot;
import org.mort11.util.EEConstants;
import org.mort11.util.Profiler;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ElevateToHeight extends Command {
	double desiredHeight;
	double toteheight;
	Timer time = new Timer();
	Profiler profiler;
	boolean useP;

	/**
	 * 
	 * @param desiredHeight
	 *            number of totes the elevator should rise
	 * @param useP
	 *            escalating using a P loop or a derpy trapezoid
	 */
	public ElevateToHeight(double desiredHeight, boolean useP) {
		requires(Robot.elevator);
		this.desiredHeight = desiredHeight * EEConstants.TOTES_TO_INCHES;
		this.useP = useP;
		profiler = new Profiler(1, EEConstants.TIME_PER_LEVEL * desiredHeight);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		new ElevatorBrake(false).start();
		Robot.elevator.resetEnc();
		time.start();
		System.out.println("resetting");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (useP) {
			double error = toteheight - Robot.elevator.getHeight();
			Robot.elevator.setSpeed(error * EEConstants.ELEVATOR_P);
		} else {
			// increment virtual sp by deltaV * t
			double speed = profiler.getDesiredVelocity(time.get());
			Robot.elevator.setSpeed(speed);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// epsilon compare on robot height/limitswitch tripped
		return (Math.abs(Robot.elevator.getHeight() - toteheight) < 0.5 || elevator
				.getLimSwitch());
	}

	// Called once after isFinished returns true
	protected void end() {
		if(elevator.getLimSwitch()){
			elevator.resetEnc();
		}
		new ElevatorBrake(true).start();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
