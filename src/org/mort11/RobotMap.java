package org.mort11;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int DT_LEFT_PORT = 1;
	public static final int DT_RIGHT_PORT = 2;
	public static final int DT_ENC_LEFT_A = 2;
	public static final int DT_ENC_RIGHT_A = 3;
	public static final int DT_ENC_LEFT_B = 4;
	public static final int DT_ENC_RIGHT_B = 5;

	public static final int ELEVATOR_TAL1 = 9;
	public static final int ELEVATOR_TAL2 = 4;
	public static final int ELEVATOR_ENC_A = 0;
	public static final int ELEVATOR_ENC_B = 1;
	public static final int ELEVATOR_TOP_LIM = 6;

	public static final int CLAW_CLOSED = 6;
	public static final int CLAW_OPEN = 5;
	public static final int BRAKE_ENGAGED = 7;
	public static final int BRAKE_DISENGAGED = 8;
	public static final int CENTER_PISTON_ENGAGED = 4; // tbd, picked a random
														// number for now
	public static final int CENTER_PISTON_NOT_ENGAGED = 5; // tbd, picked a
															// random number for
															// now
	public static final int LEFT_PISTON_ENGAGED = 6; // tbd, picked a random
	// number for now
	public static final int LEFT_PISTON_NOT_ENGAGED = 7; // tbd, picked a
	// random number for
	// now
	public static final int RIGHT_PISTON_ENGAGED = 8; // tbd, picked a random
	// number for now
	public static final int RIGHT_PISTON_NOT_ENGAGED = 9; // tbd, picked a
	// random number for
	// now

}