package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WaitTime extends Command {
	Timer time;
	double timeToWait;
    public WaitTime(double timeToWait) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	time = new Timer();
    	this.timeToWait = timeToWait;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//partay
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (time.get() > timeToWait);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
