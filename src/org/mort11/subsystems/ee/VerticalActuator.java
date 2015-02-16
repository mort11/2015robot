package org.mort11.subsystems.ee;

import org.mort11.RobotMap;
import org.mort11.commands.ee.ManualElevate;
import org.mort11.util.EEConstants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VerticalActuator extends Subsystem {
	private double height;
	private Talon elevator;
	private DigitalInput elevatorLimBotton;
	private DigitalInput elevatorLimTop;
	private Encoder elevatorEnc;
	private double speed;
	public VerticalActuator()
	{
		elevator = new Talon(RobotMap.ELEVATOR_TAL1);
		elevatorLimBotton = new DigitalInput(RobotMap.ELEVATOR_BOTTOM_LIM);
		elevatorLimTop = new DigitalInput(RobotMap.ELEVATOR_TOP_LIM);
		elevatorEnc = new Encoder(RobotMap.ELEVATOR_ENC_A, 
				RobotMap.ELEVATOR_ENC_B,true, EncodingType.k4X);
		elevatorEnc.reset();
		elevatorEnc.setDistancePerPulse(EEConstants.INCHES_PER_PULSE);
		speed = 0;
	}
	
	public double getHeight() {
		return elevatorEnc.getDistance();
	}

	public void setSpeed(double speed) {
		elevator.set(speed);
		System.out.println(this.getCurrentCommand());
	}

	public void initDefaultCommand() {
		//setDefaultCommand(new ManualElevate());
	}

	public boolean getBottomLim() {
		return !elevatorLimBotton.get();
	}
	
	public boolean getTopLim() {
		return !elevatorLimTop.get();
	}

	public void resetEnc() {
		elevatorEnc.reset();
		System.out.println(this.getCurrentCommand());
	}
}



