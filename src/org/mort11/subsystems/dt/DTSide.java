package org.mort11.subsystems.dt;

import org.mort11.commands.dt.DriveLinear;
import org.mort11.util.DTConstants;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public abstract class DTSide extends Subsystem {

	private Encoder enc;
	private Talon motors;
	private double curVal = 0;
	private boolean motorReverse;

	public DTSide(int motorPort, int encAPort, int encBPort,
			boolean motorReverse, boolean encReverse) {
		motors = new Talon(motorPort);
		enc = new Encoder(encAPort, encBPort, encReverse,EncodingType.k4X);
		enc.setDistancePerPulse(DTConstants.INCHES_PER_PULSE);
		this.motorReverse = motorReverse;

	}

	protected abstract DriveLinear getLinearDrive();

	protected void initDefaultCommand() {
		setDefaultCommand(getLinearDrive());
	}

	public void set(double lspeed) {
		//System.out.println("going");
		curVal = lspeed;
		motors.set(lspeed * (motorReverse ? -1 : 1));
		//System.out.println("setting " + motors.getChannel() + " to " + lspeed);
	}

	public double getCurVal() {
		return curVal;
	}

	public double getRate() {
		return enc.getRate();
	}

	public double getDist() {
		return enc.getDistance();
	}

	public void resetEnc() {
		//System.out.println("resetting");
		enc.reset();
	}

}
