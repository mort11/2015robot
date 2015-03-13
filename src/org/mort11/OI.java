package org.mort11;

import org.mort11.commands.ee.ElevateToHeight;
import org.mort11.commands.ee.FlipIntake;
import org.mort11.commands.ee.IntakeBoth;
import org.mort11.commands.ee.ManualElevate;
import org.mort11.commands.ee.Push;
import org.mort11.commands.ee.Zero;
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
	Joystick left = new Joystick(TeleopConstants.LEFT_JOYSTICK);
	Joystick right = new Joystick(TeleopConstants.RIGHT_JOYSTICK);
	public Joystick ee = new Joystick(TeleopConstants.EE_JOYSTICK);

	public Button manuElevOff = 
			new JoystickButton(ee, TeleopConstants.MANU_ELEV_TURN_OFF_BUTTON);
	/**Button scoringOffset = new JoystickButton(ee,
		TeleopConstants.SCORING_OFFSET_BUTTON);	
	Button coopPlatOffset = new JoystickButton(ee,
		TeleopConstants.COOP_PLAT_OFFSET_BUTTON);**/
	Button presetOneTote = new JoystickButton(ee,
		TeleopConstants.ONE_TOTE_PRESET_BUTTON);
	Button presetTwoTote = new JoystickButton(ee,
		TeleopConstants.TWO_TOTE_PRESET_BUTTON);
	Button presetThreeTote = new JoystickButton(ee,
		TeleopConstants.THREE_TOTE_PRESET_BUTTON);
	Button presetFourTote = new JoystickButton(ee,
		TeleopConstants.FOUR_TOTE_PRESET_BUTTON);
	Button presetFiveTote = new JoystickButton(ee,
			TeleopConstants.FIVE_TOTE_PRESET_BUTTON);
	Button presetSixTote = new JoystickButton(ee, TeleopConstants.SIX_TOTE_PRESET_BUTTON);
		
	Button stopIntake = new JoystickButton(ee, TeleopConstants.STOP_INTAKE);
	/**Button throttleFailsafe = new JoystickButton(ee,
			TeleopConstants.THROTTLE_FAILSAFE);**/
	Button intakeEng = new JoystickButton(ee,TeleopConstants.TOGGLE_BREAK_BUTTON);
	Button manualJoyFailsafe = new JoystickButton(ee,
			TeleopConstants.MANUAL_CONTROL_INIT);
	Button eeIntakeIn = new JoystickButton(ee, TeleopConstants.EE_INTAKE_IN);
	Button eeIntakeOut = new JoystickButton(ee, TeleopConstants.EE_INTAKE_OUT);
	Button driverIntakeIn = new JoystickButton(right,
			TeleopConstants.DRIVER_INTAKE);
	Button driverIntakeOut = new JoystickButton(left,
			TeleopConstants.DRIVER_INTAKE);
	Button flipDriverIn = new JoystickButton(right,
			2);
	Button pushCoOp = new JoystickButton(right,3);
	public OI() {
		// Move to one tote level
		presetOneTote.whenPressed(new Zero());
		presetTwoTote.whenPressed(new ElevateToHeight(1));
		presetThreeTote.whenPressed(new ElevateToHeight(2));
		presetFourTote.whenPressed(new ElevateToHeight(3));
		presetFiveTote.whenPressed(new ElevateToHeight(4));
		presetSixTote.whenPressed(new ElevateToHeight(5));
		intakeEng.whenPressed(new FlipIntake());

		/**manualControl.whileHeld(new ElevateToHeight((getEEJoyThrottle() / 2)
				* EEConstants.MAX_TOTES_NUM, true));**/
		stopIntake.whenPressed(new IntakeBoth(0));
		
		eeIntakeIn.whileHeld(new IntakeBoth(-EEConstants.INTAKE_IN_SPEED));
		eeIntakeIn.whenReleased(new IntakeBoth(0));
		eeIntakeOut.whenReleased(new IntakeBoth(0));
		eeIntakeOut.whileHeld(new IntakeBoth(EEConstants.INTAKE_OUT_SPEED));
		driverIntakeIn.whileHeld(new IntakeBoth(EEConstants.INTAKE_IN_SPEED));
		driverIntakeOut.whileHeld(new IntakeBoth(EEConstants.INTAKE_OUT_SPEED));
		driverIntakeIn.whenReleased((new IntakeBoth(0)));
		driverIntakeOut.whenReleased(new IntakeBoth(0));
		flipDriverIn.whenPressed(new FlipIntake());
		//pushCoOp.whenPressed(new Push());
		/**
		 * throttleFailsafe.whileHeld(new ElevateToHeight((getEEJoyThrottle() /
		 * 2) EEConstants.MAX_TOTES_NUM, true));
		 **/
		manualJoyFailsafe.whenPressed(new ManualElevate());

	}

	// increments all presets by the height of the platform
	public double getPlatformOffset() {
		/**if (coopPlatOffset.get()) {
			return TeleopConstants.COOP_PLAT_HEIGHT;
		} else {
			return 0;
		}**/
		return 0;
	}

	// increments all presets by t8he height of the steppe
	public int getStepOffset() {
		/**if (scoringOffset.get()) {
			return TeleopConstants.SCORING_OFFSET_BUTTON;
		} else {
			return 0;
		}**/
		return 0;
	}

	public double getLeftJoy() {
		return doThreshold(-left.getY());
	}

	public double getRightJoy() {
		return doThreshold(-right.getY());
	}

	public double getEEJoyThrottle() {
		return (-ee.getThrottle() + 1);
	}

	public double getEEJoy() { 
		System.out.println("oi: " + -ee.getY());
		return -ee.getY();
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