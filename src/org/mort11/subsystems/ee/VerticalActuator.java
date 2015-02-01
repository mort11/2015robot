package org.mort11.subsystems.ee;

import org.mort11.RobotMap;
import org.mort11.commands.ee.ElevateByJoystick;

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
	double height;
	Talon motor1;
	Talon motor2 = new Talon(RobotMap.ELEVATOR_TAL2);
	DigitalInput elevatorLim; 
	Encoder elevatorEnc;
	public VerticalActuator()
	{
		motor1 = new Talon(RobotMap.ELEVATOR_TAL1);
		elevatorLim = new DigitalInput(5);
		elevatorEnc = new Encoder(RobotMap.ELEVATOR_ENC_A, RobotMap.ELEVATOR_ENC_B,false, EncodingType.k4X);
		elevatorEnc.reset();
		elevatorEnc.setDistancePerPulse(5.0379/256);
	}
	/**
	 * get height of elevator
	 * 
	 * @return displacement of elevator from origin inches
	 */
	public double getDisplacementInInches() {
		return 0;
	}

	public void zero() {

	}

	public double getHeight() {
		return elevatorEnc.getDistance();
	}

	public void setSpeed(double speed) {
		if(speed > 1) {
			speed = 1;
		} else if (speed < -1) {
			speed = -1;
		}
		//System.out.println(speed+" :speed");
		motor1.set(speed);
		motor2.set(speed);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ElevateByJoystick());
	}

	public boolean getLimSwitch() {
		return elevatorLim.get();
	}

	public void resetEnc() {
		elevatorEnc.reset();
	}
}



