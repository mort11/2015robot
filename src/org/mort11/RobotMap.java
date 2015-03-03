package org.mort11;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// dt talons and encs
	public static final int DT_LEFT_PORT = 0;
	public static final int DT_RIGHT_PORT = 2;
	public static final int DT_ENC_LEFT_A = 0; // DIO
	public static final int DT_ENC_LEFT_B = 1; // DIO
	public static final int DT_ENC_RIGHT_A = 2; // DIO
	public static final int DT_ENC_RIGHT_B = 3; // DIO
	// ee talons and encs
	public static final int ELEVATOR_TAL1 = 4; // PWM
	public static final int ACTIVE_INTAKE_TAL_LEFT = 8; // TBD
	public static final int ACTIVE_INTAKE_TAL_RIGHT = 9; // TBD
	public static final int ELEVATOR_ENC_A = 4; // DIO
	public static final int ELEVATOR_ENC_B = 5; // DIO
	public static final int ELEVATOR_BOTTOM_LIM = 6;
	public static final int ELEVATOR_TOP_LIM = 7;
	public static final int INTAKE_SWITCH = 8;
	// pneumatics
	public static final int CLAW_CLOSED = 0;
	public static final int CLAW_OPEN = 1;
	public static final int BRAKE_ENGAGED = 7;
	public static final int BRAKE_DISENGAGED = 6;
	// auton grabber
	//public static final int CENTER_PISTON_ENGAGED = 0;
	//public static final int CENTER_PISTON_NOT_ENGAGED = 1;
	/**
	 * public static final int LEFT_PISTON_ENGAGED = 6; public static final int
	 * LEFT_PISTON_NOT_ENGAGED = 7; public static final int RIGHT_PISTON_ENGAGED
	 * = 8; public static final int RIGHT_PISTON_NOT_ENGAGED = 9;
	 **/

}