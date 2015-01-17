package org.usfirst.frc.team11.robot;

import org.usfirst.frc.team11.robot.commands.ee.ElevateToHeight;
import org.usfirst.frc.team11.robot.util.TeleopConstants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick left = new Joystick(1);
	Joystick right = new Joystick(2);
	Joystick ee = new Joystick(3);
	Button scoringOffset = new JoystickButton(ee, 2);

	// Move to one tote level
	Button presetOneTote = new JoystickButton(ee, 11);

	// Move to two totes level
	Button presetTwoTote = new JoystickButton(ee, 12);

	// Move to three totes level
	Button presetThreeTote = new JoystickButton(ee, 9);

	// Move to four totes level
	Button presetFourTote = new JoystickButton(ee, 10);

	// Move to five totes level
	Button presetFiveTote = new JoystickButton(ee, 7);

	// Move to six totes level
	Button presetSixTote = new JoystickButton(ee, 8);

	public OI() {
		presetOneTote.whenPressed(new ElevateToHeight(0));
		presetTwoTote.whenPressed(new ElevateToHeight(1));
		presetThreeTote.whenPressed(new ElevateToHeight(2));
		presetFourTote.whenPressed(new ElevateToHeight(3));
		presetFiveTote.whenPressed(new ElevateToHeight(4));
		presetSixTote.whenPressed(new ElevateToHeight(5));
	}

	public boolean getPlatformOffset() {
		return scoringOffset.get();
	}

	public boolean getSteppeOffset() {
		return ee.getTrigger();
	}

	public double getLeftJoy() {
		return left.getY();
	}

	public double getRightJoy() {
		return right.getY();
	}

	public static double doThreshold(double input) {
		if (Math.abs(input) <= TeleopConstants.deadband) {
			return 0;
		}
		return input / Math.abs(input)
				* (Math.abs(input) - TeleopConstants.deadband)
				/ (1 - TeleopConstants.deadband);
	}
}