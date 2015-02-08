package org.mort11;

import org.mort11.commands.ee.CloseClaw;
import org.mort11.commands.ee.ElevateToHeight;
import org.mort11.util.EEConstants;
import org.mort11.util.TeleopConstants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Joystick left = new Joystick(TeleopConstants.LEFT_JOYSTICK);
	// Joystick right = new Joystick(TeleopConstants.RIGHT_JOYSTICK);
	Joystick left = new Joystick(TeleopConstants.LEFT_JOYSTICK);
	Joystick right = new Joystick(TeleopConstants.RIGHT_JOYSTICK);
	static Joystick ee = new Joystick(TeleopConstants.EE_JOYSTICK);

	// Button Mapping
	Button scoringOffset = new JoystickButton(ee,
			TeleopConstants.SCORING_OFFSET);
	Button coopPlatOffset = new JoystickButton(ee,
			TeleopConstants.COOP_PLAT_OFFSET);
	Button presetOneTote = new JoystickButton(ee,
			TeleopConstants.ONE_TOTE_PRESET);
	Button presetTwoTote = new JoystickButton(ee,
			TeleopConstants.TWO_TOTE_PRESET);
	Button presetThreeTote = new JoystickButton(ee,
			TeleopConstants.THREE_TOTE_PRESET);
	Button presetFourTote = new JoystickButton(ee,
			TeleopConstants.FOUR_TOTE_PRESET);
	Button presetFiveTote = new JoystickButton(ee,
			TeleopConstants.FIVE_TOTE_PRESET);
	Button presetSixTote = new JoystickButton(ee,
			TeleopConstants.SIX_TOTE_PRESET);
	Button clawClose = new JoystickButton(ee, TeleopConstants.CLAW_CLOSE);
	Button manualControl = new JoystickButton(ee,
			TeleopConstants.THROTTLE_FAILSAFE);

	public OI() {
		// Move to one tote level
		presetOneTote.whenPressed(new ElevateToHeight(0 + getPlatformOffset()
				+ getStepOffset(), false));
		presetTwoTote.whenPressed(new ElevateToHeight(1 + getPlatformOffset()
				+ getStepOffset(), false));
		presetThreeTote.whenPressed(new ElevateToHeight(2 + getPlatformOffset()
				+ getStepOffset(), false));
		presetFourTote.whenPressed(new ElevateToHeight(3 + getPlatformOffset()
				+ getStepOffset(), false));
		presetFiveTote.whenPressed(new ElevateToHeight(4 + getPlatformOffset()
				+ getStepOffset(), false));
		presetSixTote.whenPressed(new ElevateToHeight(5 + getPlatformOffset()
				+ getStepOffset(), false));
		clawClose.toggleWhenPressed(new CloseClaw(true));
		manualControl.whileHeld(new ElevateToHeight((getEEJoyThrottle() / 2)
				* EEConstants.MAX_TOTES_NUM, false));
	}

	public double getPlatformOffset() {
		if (coopPlatOffset.get() == true) {
			return TeleopConstants.COOP_PLAT_HEIGHT;
		} else {
			return 0;
		}
	}

	public int getStepOffset() {
		if (scoringOffset.get() == true) {
			return TeleopConstants.SCORING_OFFSET;
		} else {
			return 0;
		}
	}

	public double getLeftJoy() {
		return doThreshold(left.getY());
	}

	public double getRightJoy() {
		return doThreshold(right.getY());
	}

	public static double getEEJoyThrottle() {
		return (-ee.getThrottle() + 1);
	}

	public static double getEEJoy() {
		return deadzoneEE(-ee.getY());
	}

	public static double doThreshold(double input) {
		if (Math.abs(input) <= TeleopConstants.DEADBAND) {
			return 0;
		}
		return input / Math.abs(input)
				* (Math.abs(input) - TeleopConstants.DEADBAND)
				/ (1 - TeleopConstants.DEADBAND);
	}

	public static double deadzoneEE(double input) {
		if (Math.abs(input) <= TeleopConstants.DEADZONE_EE) {
			return 0;
		}
		return input / Math.abs(input)
				* (Math.abs(input) - TeleopConstants.DEADZONE_EE)
				/ (1 - TeleopConstants.DEADZONE_EE);
	}
}