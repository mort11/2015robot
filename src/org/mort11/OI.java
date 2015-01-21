package org.mort11;

import org.mort11.commands.ee.ElevateToHeight;
import org.mort11.util.TeleopConstants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI extends TeleopConstants { //for some reason this let the constants be used, even though they are public
	// Joystick Mapping
	Joystick left = new Joystick(super.leftJoystickPortNum);
	Joystick right = new Joystick(super.rightJoystickPortNum);
	Joystick ee = new Joystick(super.eeJoystickPortNum);

	// Button Mapping
	Button scoringOffset = new JoystickButton(ee, super.scoringOffsetButton);
	Button presetOneTote = new JoystickButton(ee, super.presetOneToteButton);
	Button presetTwoTote = new JoystickButton(ee, super.presetTwoToteButton);
	Button presetThreeTote = new JoystickButton(ee, super.presetThreeToteButton);
	Button presetFourTote = new JoystickButton(ee, super.presetFourToteButton);
	Button presetFiveTote = new JoystickButton(ee, super.presetFiveToteButton);
	Button presetSixTote = new JoystickButton(ee, super.presetSixToteButton);

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