package org.mort11.commands.dt;

import org.mort11.Robot;
import org.mort11.subsystems.dt.DTSide;
import org.mort11.util.Profiler;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackwards extends Command {

	private double driveDistance;
	private double leftSpeed;
	private double rightSpeed;
	private DTSide left = Robot.left;
	private DTSide right = Robot.right;
	Profiler profiler;
	Timer timer;
	public DriveBackwards() {
		requires(left);
		requires(right);
		profiler = new Profiler(0.7, 10);
		driveDistance = 60;
		timer = new Timer();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	public DriveBackwards(double driveDistance, double leftSpeed,
			double rightSpeed) {
		this.driveDistance = driveDistance;
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		right.resetEnc();
		left.resetEnc();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double errorRight = driveDistance - right.getDist();
		double errorLeft = driveDistance - left.getDist(); 
		if(errorLeft/driveDistance < 0.3) {
			profiler.getDesiredVelocity(timer.get());
		} else {
			left.set(-errorLeft/30);
		}
		if(errorRight/driveDistance < 0.3) {
			profiler.getDesiredVelocity(timer.get());
		} else {
			right.set(-errorRight/30);
		}
		System.out.println(driveDistance - right.getDist() + " error");		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (right.getDist() < driveDistance
				&& left.getDist() < driveDistance)
			return false;
		else
			return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("Finished.");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
