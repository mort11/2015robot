package org.mort11;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	public static final int IRPort = 0; 
	public final int DT_LEFT_PORT = 1;
	public final int DT_RIGHT_PORT = 1;
	public final int DT_ENC_LEFT_A = 1;
	public final int DT_ENC_RIGHT_A = 1;
	public final int DT_ENC_LEFT_B = 1;
	public final int DT_ENC_RIGHT_B = 1;
	public static final int elevatorPortOne = 1;
	public static final int elevatorPortTwo = 2;
	public static final int elevatorEncoderA = 1;
	public static final int elevatorEncoderB = 2;
}