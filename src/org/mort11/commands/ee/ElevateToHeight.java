package org.mort11.commands.ee;
import static org.mort11.Robot.*;

import org.mort11.Robot;
import org.mort11.util.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevateToHeight extends Command {
	double toteheight;
	Timer time = new Timer();
	Profiler profiler;
	double lastTime = 0;
	double setpoint = 0;
	double error;
    public ElevateToHeight(int toteHeight) {
        this.toteheight = toteHeight * EEConstants.TOTES_TO_INCHES;
        requires(Robot.elevator);
        profiler = new Profiler(1, EEConstants.TIME_PER_LEVEL * toteHeight);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.resetEnc();
    	time.start();
    	System.out.println("resetting");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/**double error = toteheight - Robot.elevator.getHeight();
    	if(error/toteheight > 0.8 && Robot.elevator.getSpeed()!=1) {
    		System.out.println("ramping");
    		if(Robot.elevator.getSpeed() == 0) {
    			Robot.elevator.setSpeed(0.1);
    		} else {
    			Robot.elevator.setSpeed(Robot.elevator.getSpeed() * 1.005);
    		}
    	} else {
    		Robot.elevator.setSpeed(error * EEConstants.HeightP);
    	}
    	System.out.println(error/toteheight+" : error");**/
    	double currTime = time.get();
    	//increment virtual sp by deltaV * t
    	setpoint += profiler.getDesiredVelocity(time.get()) * 
    			(currTime - lastTime);
    	System.out.println(setpoint + " :setpoint");
    	error = setpoint - Robot.elevator.getHeight();
    	Robot.elevator.setSpeed(error * EEConstants.ELEVATOR_P);
    	System.out.println(Robot.elevator.getHeight() + " :height");
    	lastTime = currTime;
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//epsilon compare on robot height/limitswitch tripped
        /**return (Math.abs(Robot.elevator.getHeight() - toteheight) < 0.5 ||
        		elevator.getLimSwitch());**/
    	return time.get() > 7;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("finished");
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
