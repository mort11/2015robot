package org.mort11.util;

public class EEConstants {
    public static final double TOTES_TO_INCHES = 11;
    public static final double ELEVATOR_P = 1;
    public static final double TIME_PER_LEVEL = 2;
    public static final int EE_CPR = 256;
    public static final double EE_HEIGHT_PER_TURN = 5.0379; // inches
    public static final double INCHES_PER_PULSE = EE_HEIGHT_PER_TURN / EE_CPR;
    public static final double ESCALATION_SPEED = 0.8;
    public static final double LOWERING_SPEED = 0.8;
    public static final double PUSHOUT_SPEED = 0.25;
    public static final double ZERO_OFFSET = 12 / TOTES_TO_INCHES;
    // public static final double PUSHOUT_SPEED = 0.05;
    public static final double INTAKE_IN_SPEED = 0.5;
    public static final double INTAKE_OUT_SPEED = 0.5;
    public static final double OPEN_INTAKE_HIGHT = 7; // TBD
}
