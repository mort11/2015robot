package org.mort11.commands.auton;

import org.mort11.Robot;
import org.mort11.subsystems.dt.DTSide;
import org.mort11.util.DTConstants;
import org.mort11.util.Profiler;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDist extends Command {

	private double driveDistance;
	private DTSide left = Robot.left;
	private DTSide right = Robot.right;
	private Profiler profiler;
	private Timer timer;
	private double lastTime = 0;
	double setpoint = 0;
	public DriveDist(double distance) {
		requires(left);
		requires(right);
		profiler = new Profiler(distance/2, 3); //because math
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
		double currtime = timer.get();
		double vel =  profiler.getDesiredVelocity(currtime);
		setpoint += (currtime - lastTime) * vel;
		System.out.println(left.getDist() + " left ");
		System.out.println(right.getDist() + " right ");
		double errorLeft = (setpoint - left.getDist());		
		double errorRight = (setpoint - right.getDist());
		System.out.println(errorRight * DTConstants.DT_P+ " errorRight");
		System.out.println(errorLeft * DTConstants.DT_P+ " errorLeft");
		//System.out.println(errorLeft);
		right.set(errorRight * DTConstants.DT_P);
		left.set(errorLeft*DTConstants.DT_P);
		System.out.println();
		lastTime = currtime;		
	}

	// Make thi7s return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
			if(timer.get() > 3)
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
