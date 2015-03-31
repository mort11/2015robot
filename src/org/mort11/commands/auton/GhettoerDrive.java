package org.mort11.commands.auton;

import org.mort11.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GhettoerDrive extends Command {
	Timer timer;
	double timeToDrive;
	double volt;
    public GhettoerDrive(double time, double volt) {
        requires(Robot.left);
        requires(Robot.right);
        this.timeToDrive = time;
        this.volt = volt;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(timer.get() < timeToDrive) {
    		//System.out.println(Robot.left.getDist() + " left");
    		//System.out.println(Robot.right.getDist() + " right");
    		Robot.left.set(volt);
    		Robot.right.set(volt);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (timer.get() > timeToDrive);
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
