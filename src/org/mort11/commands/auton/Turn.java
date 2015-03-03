package org.mort11.commands.auton;

import org.mort11.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	Timer time;
	double error;
    public Turn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.left);
    	requires(Robot.right);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time = new Timer();
    	time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(error + " turn error");
    	error = 21 + Robot.right.getDist();
    	Robot.left.set(error * 0.2);
    	Robot.right.set(-error * 0.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(error) < 0.05 || time.get() > 4;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.left.set(0);
    	Robot.right.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
