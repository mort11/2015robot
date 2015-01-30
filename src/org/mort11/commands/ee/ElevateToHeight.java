package org.mort11.commands.ee;
import static org.mort11.Robot.*;

import org.mort11.Robot;
import org.mort11.util.*;

import edu.wpi.first.wpilibj.command.Command;

public class ElevateToHeight extends Command {
	int toteheight;
    public ElevateToHeight(int toteHeight) {
        this.toteheight = toteHeight;
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double error = toteheight - Robot.elevator.getHeight();
    	Robot.elevator.setSpeed(error * EEConstants.HeightP);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.elevator.getHeight()/
        		EEConstants.TOTES_TO_INCHES == toteheight);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
