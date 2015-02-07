package org.mort11.commands.ee;
import static org.mort11.Robot.*;

import org.mort11.Robot;
import org.mort11.subsystems.ee.VerticalActuator;
import org.mort11.util.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevateToHeight extends Command {
	double toteheight;
	Timer time = new Timer();
	Profiler profiler;
	boolean useP;
	/**
	 * 
	 * @param toteHeight number of totes the elevator should rise
	 * @param useP escalating using a P loop or a derpy trapezoid
	 */
    public ElevateToHeight(int toteHeight,boolean useP) {
        requires(Robot.elevator);
        this.toteheight = toteHeight * EEConstants.TOTES_TO_INCHES;
        this.useP = useP;
        profiler = new Profiler(1, EEConstants.TIME_PER_LEVEL * toteHeight);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.brake.setSolenoid(false);
    	Robot.elevator.resetEnc();
    	time.start();
    	System.out.println("resetting");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(useP) {
    		double error = toteheight - Robot.elevator.getHeight();
    		Robot.elevator.setSpeed(error * EEConstants.ELEVATOR_P);
    	} else {
    		//increment virtual sp by deltaV * t
    		double speed = profiler.getDesiredVelocity(time.get());
    		Robot.elevator.setSpeed(speed);
    	}
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//epsilon compare on robot height/limitswitch tripped
        return (Math.abs(Robot.elevator.getHeight() - toteheight) < 0.5 ||
        		elevator.getLimSwitch());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.brake.setSolenoid(true);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
