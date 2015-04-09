package org.mort11.commands.auton;

import org.mort11.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnDegNav extends Command {

	private double desiredYaw;
    public TurnDegNav(double desiredYaw) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.desiredYaw = desiredYaw;
    	requires(Robot.left);
    	requires(Robot.right);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    private double error;
    protected void execute() {
    	error = desiredYaw - Robot.imu.getYaw();
    	Robot.left.set(error * 0.1);
    	Robot.right.set(-error * 0.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (error < 0.5 && error > -0.5);
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
