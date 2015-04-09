package org.mort11.commands.auton;

import org.mort11.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TwoCan extends Command {
	Timer time;
    public TwoCan() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.canArms);
    	requires(Robot.left);
    	requires(Robot.right);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time.start();
    	//drop arms
    	Robot.canArms.setSolenoid(!Robot.canArms.isEngaged()); //if the arms
    						//drop out automatically then comment out this line
    															
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//flip positive to negative to change direction of the spin
    	//this part is the turn
    	Robot.left.set(-0.9);
    	Robot.right.set(0.9);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//when to stop spinning
        return time.get() > 1; //the time spent spinning (currently 1s)
    }

    // Called once after isFinished returns true
    protected void end() {
    	//stow away the arms after cans have been grabbed
    	/**Robot.canArms.setSolenoid(!Robot.canArms.isEngaged());**/ //comment this in
    													//to put the arms back in    
    	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
