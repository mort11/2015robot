package org.mort11.commands.dt;

import org.mort11.Robot;
import org.mort11.subsystems.dt.DTSide;
import org.mort11.util.DTConstants;
import org.mort11.util.Profiler;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackwards extends Command {

	private double driveDistance;
	private DTSide left = Robot.left;
	private DTSide right = Robot.right;
	private Profiler profiler;
	private Timer timer;
	private double lastTime = 0;
	double setpoint = 0;
	public DriveBackwards() {
		requires(left);
		requires(right);
		profiler = new Profiler(36, 10);
		driveDistance = 25;
		timer = new Timer();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		right.resetEnc();
		left.resetEnc();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		/**double errorRight = driveDistance - right.getDist();
		double errorLeft = driveDistance - left.getDist(); 
		if(left.getDist()/driveDistance < 0.3) { //steal ramp up from profiler
			left.set(-profiler.getDesiredVelocity(timer.get()));
			System.out.println("trap");
		} else {
			left.set(-errorLeft/30);
			System.out.println("P");
		}
		if(right.getDist()/driveDistance < 0.3) {
			right.set(-profiler.getDesiredVelocity(timer.get()));
		} else {
			right.set(-errorRight/30);
		}
		System.out.println(driveDistance - right.getDist() + " error");**/
		double currtime = timer.get();
		double vel =  profiler.getDesiredVelocity(currtime);
		setpoint += (currtime - lastTime) * vel;
		double errorLeft = setpoint - left.getDist();
		double errorRight = setpoint - right.getDist();
		right.set(-errorRight * (DTConstants.DT_P));
		left.set(-errorLeft * (DTConstants.DT_P - 0.06));
		lastTime = currtime;		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
			if(timer.get() > 12)
				return true;
			else
				return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println(left.getDist() + " left distance");
		System.out.println(right.getDist() + " right distance");
		System.out.println(setpoint + " sp");
		System.out.println("Finished.");
		left.resetEnc();
		right.resetEnc();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
