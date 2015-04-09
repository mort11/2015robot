package org.mort11.commands.ee;

import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Push extends Command {
	/**
	 * 
	 * @author SaltNPeppa
	 */
	private PneumaticSubsystem coOpPush = Robot.canArms;
    public Push() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(coOpPush);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	coOpPush.setSolenoid(!coOpPush.isEngaged());
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
