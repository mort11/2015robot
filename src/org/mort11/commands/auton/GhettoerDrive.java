package org.mort11.commands.auton;

import org.mort11.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GhettoerDrive extends Command {
	Timer time;
    public GhettoerDrive() {
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
    	while(time.get() < 3) {
    		System.out.println(Robot.left.getDist() + " left");
    		System.out.println(Robot.right.getDist() + " right");
    		Robot.left.set(0.05);
    		Robot.right.set(0.05);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (time.get() > 3);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
