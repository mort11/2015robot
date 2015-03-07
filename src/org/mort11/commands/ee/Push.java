package org.mort11.commands.ee;

import org.mort11.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Push extends Command {
	/**
	 * 
	 * @author SaltNPeppa
	 */
    public Push() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.coOpPush);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.coOpPush.setSolenoid(!Robot.coOpPush.isEngaged());
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
