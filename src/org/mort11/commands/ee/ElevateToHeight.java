package org.mort11.commands.ee;

import static org.mort11.Robot.elevator;

import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.subsystems.ee.VerticalActuator;
import org.mort11.util.EEConstants;
import org.mort11.util.Profiler;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ElevateToHeight extends Command {
	double desiredHeight;
	Timer time = new Timer();
	Profiler profiler;
	boolean useP;
	private VerticalActuator moveElevator = Robot.elevator;
	private PneumaticSubsystem brake = Robot.brake;

	/**
	 * 
	 * @param desiredHeight
	 *            number of totes the elevator should rise
	 * @param useP
	 *            escalating using a P loop or a derpy trapezoid
	 */
	public ElevateToHeight(double desiredHeight, boolean useP) {
		this.desiredHeight = desiredHeight;
		requires(moveElevator);
		requires(brake);
		this.useP = useP;
		profiler = new Profiler(1, EEConstants.TIME_PER_LEVEL * desiredHeight);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		brake.setSolenoid(false);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println(moveElevator.getHeight() + " height");
		System.out.println(desiredHeight + " goal");
		System.out.println(moveElevator.getTopLim());
		if(desiredHeight > moveElevator.getHeight()) {
			moveElevator.setSpeed(EEConstants.ESCALATION_SPEED);
		}
		else {
			moveElevator.setSpeed(-EEConstants.LOWERING_SPEED);
		}
	

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// epsilon compare on robot height/limitswitch tripped
		return (Math.abs(Robot.elevator.getHeight() - desiredHeight) < 0.5 ||
				checkDirection());
	}

	// Called once after isFinished returns true
	protected void end() {
		time.start();
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
		Robot.elevator.setSpeed(0);
		brake.setSolenoid(true);
	}
	
	//makes sure we aren't heading in the same way as the switch
	private boolean checkDirection()
	{
		return (elevator.getBottomLim() && 
					desiredHeight < Robot.elevator.getHeight()) || 
				(elevator.getTopLim() &&
						desiredHeight > Robot.elevator.getHeight());
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
