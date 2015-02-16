package org.mort11.commands.ee;

import org.mort11.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Zero extends Command {

    public Zero() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.setSpeed(-0.3);
    	System.out.println(Robot.elevator.getBottomLim());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getBottomLim();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setSpeed(0);
    	System.out.println("zeroed");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
