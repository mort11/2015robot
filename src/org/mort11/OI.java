package org.mort11;

import org.mort11.commands.ee.CloseClaw;
import org.mort11.commands.ee.ElevateToHeight;
import org.mort11.util.TeleopConstants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI extends TeleopConstants
{
	Joystick left = new Joystick(super.LEFT_JOYSTICK);
	Joystick right = new Joystick(super.RIGHT_JOYSTICK);
	Joystick ee = new Joystick(super.EE_JOYSTICK);

	// Button Mapping
	Button scoringOffset = new JoystickButton(ee, super.SCORING_OFFSET);
	Button presetOneTote = new JoystickButton(ee, super.ONE_TOTE_PRESET);
	Button presetTwoTote = new JoystickButton(ee, super.TWO_TOTE_PRESET);
	Button presetThreeTote = new JoystickButton(ee, super.THREE_TOTE_PRESET);
	Button presetFourTote = new JoystickButton(ee, super.FOUR_TOTE_PRESET);
	Button presetFiveTote = new JoystickButton(ee, super.FIVE_TOTE_PRESET);
	Button presetSixTote = new JoystickButton(ee, super.SIX_TOTE_PRESET);
	Button clawClose = new JoystickButton(ee, super.CLAW_CLOSE);

	public OI() 
	{
		// Move to one tote level
		presetOneTote.whenPressed(new ElevateToHeight(0));
		presetTwoTote.whenPressed(new ElevateToHeight(1));
		presetThreeTote.whenPressed(new ElevateToHeight(2));
		presetFourTote.whenPressed(new ElevateToHeight(3));
		presetFiveTote.whenPressed(new ElevateToHeight(4));
		presetSixTote.whenPressed(new ElevateToHeight(5));
		clawClose.whenPressed(new CloseClaw(true));
	}

	public boolean getPlatformOffset() 
	{
		return scoringOffset.get();
	}

	public boolean getSteppeOffset() 
	{
		return ee.getTrigger();
	}
	
	public double getLeftJoy() 
	{
		return doThreshold(left.getY());
	}

	public double getRightJoy()
	{
		return doThreshold(right.getY());
	}
	public double getEEJoy()
	{
		return doThreshold(ee.getY());
	}

	public static double doThreshold(double input) {
		if (Math.abs(input) <= TeleopConstants.DEADBAND) {
			return 0;
		}
		return input / Math.abs(input)
				* (Math.abs(input) - TeleopConstants.DEADBAND)
				/ (1 - TeleopConstants.DEADBAND);
	}
}