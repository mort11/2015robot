package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.Robot;
/**
 *
 */
public class CloseClaw extends Command {
	
	boolean isClosed;

    public CloseClaw(boolean isClosed) {
    	this.isClosed =  isClosed;
    	requires(Robot.claw);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.claw.setPart(isClosed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
