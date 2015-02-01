package org.mort11.commands.ee;
import static org.mort11.Robot.*;

import org.mort11.Robot;
import org.mort11.util.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevateToHeight extends Command {
	double toteheight;
    public ElevateToHeight(int toteHeight) {
        this.toteheight = toteHeight * EEConstants.TOTES_TO_INCHES;
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double error = (toteheight - Robot.elevator.getHeight())/toteheight;
    	if(error>0.8) {
    		Robot.elevator.setSpeed(0.2+(1-error));
    	} else {
    		Robot.elevator.setSpeed(error * EEConstants.HeightP);
    	}
    	System.out.println(error+" : error");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//epsilon compare on robot height/limitswitch tripped
        return (Math.abs(Robot.elevator.getHeight() - toteheight) < 0.5 || 
        		!elevator.getLimSwitch());
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("finished");
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
