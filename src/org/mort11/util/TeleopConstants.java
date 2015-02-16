package org.mort11.util;

public class TeleopConstants {
	public static final double DEADBAND = 0.035;
	public static final double DEADZONE_EE = 0.3;
	public static final int SCORING_OFFSET_BUTTON = 2;
	public static final int COOP_PLAT_OFFSET_BUTTON = 3;
	public static final int ONE_TOTE_PRESET_BUTTON = 11;
	public static final int TWO_TOTE_PRESET_BUTTON = 12;
	public static final int THREE_TOTE_PRESET_BUTTON = 9;
	public static final int FOUR_TOTE_PRESET_BUTTON = 10;
	public static final int FIVE_TOTE_PRESET_BUTTON= 7;
	public static final int TOGGLE_BREAK_BUTTON = 7;
	public static final int LEFT_JOYSTICK = 1;
	public static final int RIGHT_JOYSTICK = 2;
	public static final int EE_JOYSTICK = 3;
	public static final int CLAW_CLOSE = 2;
	public static final int THROTTLE_FAILSAFE = 3;
	public static final int MANUAL_CONTROL_INIT = 5; //manu joy control only works when pressed (tbd)
	public static final int SCORING_PLAT_HEIGHT = 2;
	public static final double COOP_PLAT_HEIGHT = 6.25;
	public static final double MANUAL_SPEED_LIMIT = 2; //divide joy val by this to limit elevator speed
	// each tote has a dimension of 26.9 inches long, 16.9 inches wide, and 12.1
	// inches tall
}