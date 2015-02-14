package org.mort11.navigation;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class EncoderHandler {

	public static class encoderState {
		public double distanceLeft;
		public double distanceRight;
		public double speed;
	}

	// Encoders
	// Left DT Encoder
	Encoder encLeft = new Encoder(0, 1, false, EncodingType.k4X);
	// Right DT Encoder
	Encoder encRight = new Encoder(0, 1, false, EncodingType.k4X);

	private double distanceDTLeft;
	private double distanceDTRight;
	private double speed;

	// Encoder steps per revolution is 256
	// Wheel size = 4in
	// pi * wheelsize

	private final int wheelSize = 4;
	private final int encoderSteps = 256;
	private final double dtEncoderScaleFactor = (Math.PI * wheelSize)
			/ encoderSteps;

	// Encoder Data handling

	private void initEncoder() {
		encLeft.setDistancePerPulse(dtEncoderScaleFactor);
		encRight.setDistancePerPulse(dtEncoderScaleFactor);
	}

	private double getDistanceDTLeft() {
		distanceDTLeft = encLeft.getDistance() / (Math.PI * wheelSize);
		return distanceDTLeft;
	}

	private double getDistanceDTRight() {
		distanceDTRight = encRight.getDistance() / (Math.PI * wheelSize);
		return distanceDTRight;
	}

	private double getSpeed() {
		return speed;
	}

	public encoderState getDistance() {
		// SHOULD ONLY BE CALLED ONCE EVERY TIMESTEP
		encoderState encState = new encoderState();

		// Call position & velocity functions to set internal vars
		initEncoder();
		getDistanceDTLeft();
		getDistanceDTRight();

		// Setup output values
		encState.distanceLeft = distanceDTRight;
		encState.distanceRight = distanceDTRight;
		encState.speed = speed;

		return encState;
	}

}
