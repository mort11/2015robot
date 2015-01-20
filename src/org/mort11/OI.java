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
	// Joystick Mapping
	Joystick left = new Joystick(1);
	Joystick right = new Joystick(2);
	Joystick ee = new Joystick(3);

	// Button Mapping
	Button scoringOffset = new JoystickButton(ee, 2);
	Button presetOneTote = new JoystickButton(ee, 11);
	Button presetTwoTote = new JoystickButton(ee, 12);
	Button presetThreeTote = new JoystickButton(ee, 9);
	Button presetFourTote = new JoystickButton(ee, 10);
	Button presetFiveTote = new JoystickButton(ee, 7);
	Button presetSixTote = new JoystickButton(ee, 8);

	public OI() {
		// Move to one tote level
		presetOneTote.whenPressed(new ElevateToHeight(0));
		// Move to two totes level
		presetTwoTote.whenPressed(new ElevateToHeight(1));
		// Move to three totes level
		presetThreeTote.whenPressed(new ElevateToHeight(2));
		// Move to four totes level
		presetFourTote.whenPressed(new ElevateToHeight(3));
		// Move to five totes level
		presetFiveTote.whenPressed(new ElevateToHeight(4));
		// Move to six totes level
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