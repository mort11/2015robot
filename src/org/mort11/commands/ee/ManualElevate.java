package org.mort11.commands.ee;

import static org.mort11.Robot.elevator;

import org.mort11.OI;
import org.mort11.Robot;
import static org.mort11.Robot.*;
import org.mort11.subsystems.dt.DTSide;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.subsystems.ee.VerticalActuator;
import org.mort11.util.EEConstants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevate extends Command {
	private VerticalActuator moveElevator = Robot.elevator;
	private PneumaticSubsystem brake = Robot.brake;
	//private OI oi = Robot.oi;
	private double speed; //speed as given by joystick

//lexi and jakob code
	public ManualElevate() {
		requires(elevator);
	}
	
//	public ManualElevate(double speed){
//		this.speed = speed;
//	}

	// Called just before this Command runs the first time
	protected void initialize() {
	System.out.println(oi.a);
		brake.setSolenoid(false);
		setInterruptible(true);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() { 
		System.out.println("execute");
		System.out.println("Joystick val: " + oi.ee.getY());
		elevator.setSpeed(oi.ee.getY());
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println("isFinished");
		if(oi.manuElevOff.get()){
			return true;
		}
		return elevator.getBottomLim();
	}

	// Called once after isFinished returns true
	protected void end() {
		if(elevator.getBottomLim()){
			elevator.resetEnc();
			//push out of sketchy zone
			//elevator.setSpeed(EEConstants.PUSHOUT_SPEED);
			//while(time.get() < 0.5);
			//System.out.println("pushing");
		} else if (elevator.getTopLim()) {
			//push out of sketchy zone
			//elevator.setSpeed(-EEConstants.PUSHOUT_SPEED);
			//while(time.get() < 0.5);
		}
		System.out.println("end");
		Robot.elevator.setSpeed(0);
		brake.setSolenoid(true);
	}
	
	//makes sure we aren't heading in the same way as the switch

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		// cri
		System.out.println("interrupted");
	}
}
