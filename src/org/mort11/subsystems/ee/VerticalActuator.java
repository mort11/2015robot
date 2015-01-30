package org.mort11.subsystems.ee;

import org.mort11.RobotMap;
import org.mort11.commands.ee.Elevate;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VerticalActuator extends Subsystem {
	double height;
	Talon motor1 = new Talon(RobotMap.ELEVATOR_TAL1);
	Talon motor2 = new Talon(RobotMap.ELEVATOR_TAL2);
	DigitalInput elevatorLim = new DigitalInput(1); 
	Encoder elevatorEnc = new Encoder(RobotMap.ELEVATOR_ENC_A, RobotMap.ELEVATOR_ENC_B);

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
		return height;
	}

	public void setSpeed(double speed) {
		motor1.set(speed);
		motor2.set(speed);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Elevate());
	}

	public boolean getLimSwitch() {
		return elevatorLim.get();
	}

	public void resetEnc() {
		elevatorEnc.reset();
	}
}
