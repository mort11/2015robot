package org.mort11.commands.ee;

import org.mort11.Robot;
import org.mort11.util.EEConstants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Zero extends Command {

    public Zero() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	requires(Robot.brake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.brake.setSolenoid(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.setSpeed(-EEConstants.LOWERING_SPEED);
    	System.out.println(Robot.elevator.getBottomLim());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getBottomLim();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setSpeed(0);
    	Robot.elevator.resetEnc();
    	System.out.println("zeroed");
    	Robot.brake.setSolenoid(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
