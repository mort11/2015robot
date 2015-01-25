package org.mort11.subsystems.ee;

import static org.mort11.util.EEConstants.IRVoltsToInches;

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

	AnalogInput ir = new AnalogInput(RobotMap.IRPort);
	double height;
	Talon motor1 = new Talon(1);
	Talon motor2 = new Talon(2);
	DigitalInput elevatorLim = new DigitalInput(1);
	Encoder elevatorEnc = new Encoder(1, 2);

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
		height = ir.getVoltage() * IRVoltsToInches;
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
