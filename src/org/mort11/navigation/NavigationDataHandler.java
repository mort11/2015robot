package org.mort11.navigation;

import org.mort11.navigation.EncoderHandler.encoderState;
import org.mort11.util.Vector2D;

public class NavigationDataHandler {

	public class dataFuzer {

		// Retrieved from Nav6
		public double orientation;
		public double speed;
		public Vector2D position;

		// Retrieved from Encoders
		public double distanceDTLeft;
		public double distanceDTRight;
	}

	public static double orientation;
	public static double speed;
	public static Vector2D position;
	public static double distanceDTLeft;
	public static double distanceDTRight;

	// Velocity
	private static double changedVelocityX;
	private static double changedVelocityY;

	private static double currentVelocityX;
	private static double currentVelocityY;

	private static double lastVelocityX;
	private static double lastVelocityY;

	// Position
	private static double changedPositionX;
	private static double changedPositionY;

	private static double currentPositionX;
	private static double currentPositionY;

	private static double lastPositionX;
	private static double lastPositionY;

	// Instantiate the objects
	private static Nav6 nav6 = new Nav6();
	private static encoderState encoder = new encoderState();

	/*
	 * private static Vector2D vector = new Vector2D(currentPositionX,
	 * currentPositionY);
	 */

	private static void navRunner() {
		// Return orientation
		orientation = nav6.setOrientation();
		// Return speed
		speed = encoder.speed;
		// Todo position
	}

	private static void setCurrentVelocityX() {
		lastVelocityX = currentVelocityX;
		currentVelocityX = lastVelocityX + changedVelocityX;
	}

	private static void setCurrentVelocityY() {
		lastVelocityY = currentVelocityY;
		currentVelocityY = lastVelocityY + changedVelocityY;
	}

	private static void setChangedPosX() {
		changedPositionX = ((currentVelocityX + lastVelocityX) / 2)
				* nav6.setTimerChange();
	}

	private static void setChangedPosY() {
		changedPositionY = ((currentVelocityY + lastVelocityY) / 2)
				* nav6.setTimerChange();
	}

	private static void setCurrentPosX() {
		lastPositionX = currentPositionX;
		currentPositionX = changedPositionX + lastPositionX;
	}

	private static void setCurrentPosY() {
		lastPositionY = currentPositionY;
		currentPositionY = changedPositionY + lastPositionY;
	}

	private static void setCurrentEncoderDistance() {
		distanceDTLeft = encoder.distanceLeft;
		distanceDTRight = encoder.distanceRight;
	}

	private static void generatePosVector() {
		position = new Vector2D(currentPositionX, currentPositionY);
	}

	public dataFuzer getPosition() {
		// SHOULD ONLY BE CALLED ONCE EVERY TIMESTEP
		// navigationalState navState = new navigationalState();
		dataFuzer dataHandler = new dataFuzer();
		// Calls to roborio and encoders

		dataHandler.orientation = orientation;
		dataHandler.speed = speed;
		dataHandler.distanceDTLeft = distanceDTLeft;
		dataHandler.distanceDTRight = distanceDTRight;
		dataHandler.position = position;

		return dataHandler;
	}
}
