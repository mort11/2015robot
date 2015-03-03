package org.mort11.navigation.io;

import org.mort11.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class EncoderHandler {

	public static class encoderState {
		public double distanceLeft;
		public double distanceRight;
		public double speedLeft;
		public double speedRight;
	}

	// Encoders
	// Left DT Encoder
	Encoder encLeft = new Encoder(RobotMap.DT_ENC_LEFT_A,
			RobotMap.DT_ENC_LEFT_B, false, EncodingType.k4X);
	// Right DT Encoder
	Encoder encRight = new Encoder(RobotMap.DT_ENC_RIGHT_A,
			RobotMap.DT_ENC_RIGHT_B, false, EncodingType.k4X);

	private double distanceDTLeft;
	private double distanceDTRight;
	private double dtSpeedLeft;
	private double dtSpeedRight;

	// Encoder steps per revolution is 256
	// Wheel size = 4in
	// pi * wheelsize

	private final double wheelSize = 4; // Diameter
	private final int encoderSteps = 256;
	private final double dtEncoderScaleFactor = (Math.PI * wheelSize)
			/ encoderSteps;

	// Encoder Data handling

	public void initEncoder() {
		encLeft.setDistancePerPulse(dtEncoderScaleFactor);
		encRight.setDistancePerPulse(dtEncoderScaleFactor);
	}

	public void getDistanceDTLeft() {
		distanceDTLeft = encLeft.getDistance(); // / (Math.PI * wheelSize);
		// return distanceDTLeft;
	}

	public void getDistanceDTRight() {
		distanceDTRight = encRight.getDistance(); // / (Math.PI * wheelSize);
		// return distanceDTRight;
	}

	public void getSpeedLeft() {
		dtSpeedLeft = encLeft.getRate();
		// return dtSpeedLeft;
	}

	public void getSpeedRight() {
		dtSpeedRight = encRight.getRate();
		// return dtSpeedRight;
	}

	public encoderState getDistance() {
		// SHOULD ONLY BE CALLED ONCE EVERY TIMESTEP
		encoderState encState = new encoderState();

		// Call position & velocity functions to set internal vars
		initEncoder();
		getDistanceDTLeft();
		getDistanceDTRight();
		getSpeedLeft();
		getSpeedRight();

		// Setup output values
		encState.distanceLeft = distanceDTRight;
		encState.distanceRight = distanceDTRight;
		encState.speedLeft = dtSpeedLeft;
		encState.speedRight = dtSpeedRight;

		return encState;
	}

}
