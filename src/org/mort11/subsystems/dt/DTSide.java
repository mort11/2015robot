package org.mort11.subsystems.dt;

import org.mort11.commands.dt.DriveLinear;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public abstract class DTSide extends Subsystem {

	private static Encoder enc;
	private static Talon motors;
	private static double curVal = 0;
	private static boolean motorReverse;

	public DTSide(int motorPort, int encAPort, int encBPort,
			boolean motorReverse, boolean encReverse) {
		motors = new Talon(motorPort);
		enc = new Encoder(encAPort, encBPort, encReverse);
		this.motorReverse = motorReverse;

	}

	protected abstract DriveLinear getLinearDrive();

	protected void initDefaultCommand() {
		setDefaultCommand(getLinearDrive());
	}

	public static void set(double lspeed) {
		curVal = lspeed;
		motors.set(lspeed * (motorReverse ? -1 : 1));
	}

	public double getCurVal() {
		return curVal;
	}

	public double getRate() {
		return enc.getRate();
	}

	public static double getDist() {
		return enc.getDistance();
	}

	public static void resetEnc() {
		enc.reset();
	}

}
