/*       __  __  ____  _____ _______   __ __
        |  \/  |/ __ \|  __ \__   __| /_ /_ |
        | \  / | |  | | |__) | | |     | || |
        | |\/| | |  | |  _  /  | |     | || |
        | |  | | |__| | | \ \  | |     | || |
        |_|  |_|\____/|_|  \_\ |_|     |_||_|
 
           FRC Team 11, Flanders NJ 07836
 
        Copyright (c) 2015 Mount Olive Robotics Team
 */

package org.mort11;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int DT_LEFT_PORT = 1;
	public static final int DT_RIGHT_PORT = 1;
	public static final int DT_ENC_LEFT_A = 1;
	public static final int DT_ENC_RIGHT_A = 1;
	public static final int DT_ENC_LEFT_B = 1;
	public static final int DT_ENC_RIGHT_B = 1;

	public static final int ELEVATOR_TAL1 = 1;
	public static final int ELEVATOR_TAL2 = 2;
	public static final int ELEVATOR_ENC_A = 1;
	public static final int ELEVATOR_ENC_B = 2;

	public static final int CLAW_CLOSED = 1; // probably gonna delete
	public static final int CLAW_OPEN = 2; // probably gonna delete

	public static final int BRAKE_ENGAGED = 1; // probably gonna delete
	public static final int BRAKE_DISENGAGED = 2; // probably gonna delete

	public static final int CLAW_IN = 1;
	public static final int CLAW_OUT = 2;

	public static final int BREAK_IN = 1;
	public static final int BREAK_OUT = 2;

}