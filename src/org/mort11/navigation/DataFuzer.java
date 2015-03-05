package org.mort11.navigation;

import java.util.Timer;
import java.util.TimerTask;

import org.mort11.navigation.io.interfaces.Encoders.encoderState;
import org.mort11.navigation.io.interfaces.Nav6;
import org.mort11.util.Vector2D;

public class DataFuzer {

	// ALL VALUES ARE GIVEN IN FEET
	public static class dataFuzer {

		// Retrieved from Nav6
		public double orientation;
		public double speedLeft;
		public double speedRight;
		public Vector2D position;

		// Retrieved from Encoders
		public double distanceDTLeft;
		public double distanceDTRight;
	}

	public static class navigationRunner extends TimerTask {

		public void run() {
			getPosition();
		}

	}

	public static double orientation;
	public static double speedLeft;
	public static double speedRight;
	public static Vector2D position;
	public static double distanceDTLeft;
	public static double distanceDTRight;

	// Velocity
	private static double deltaVelocityX;
	private static double deltaVelocityY;

	private static double currentVelocityX;
	private static double currentVelocityY;

	private static double lastVelocityX;
	private static double lastVelocityY;

	// Position
	private static double changedPositionX;
	private static double changedPositionY;

	protected static double currentPositionX;
	protected static double currentPositionY;

	private static double lastPositionX;
	private static double lastPositionY;

	// Instantiate the objects
	private static Nav6 nav6 = new Nav6();
	private static encoderState encoder = new encoderState();
	private static Timer timer = new Timer();

	/*
	 * private static Vector2D vector = new Vector2D(currentPositionX,
	 * currentPositionY);
	 */

	public static void run() {
		timer.schedule(new navigationRunner(), 0, 20);
	}

	private static void navRunner() {
		// Return orientation
		orientation = nav6.getPosition().orientation;
		// Return speed
		speedLeft = encoder.speedLeft;
		speedRight = encoder.speedRight;
		// Todo position
	}

	private static void generatePosVector() {
		position = new Vector2D(currentPositionX, currentPositionY);
	}

	public static dataFuzer getPosition() {
		// SHOULD ONLY BE CALLED ONCE EVERY TIMESTEP
		// navigationalState navState = new navigationalState();
		dataFuzer dataHandler = new dataFuzer();

		// Calls to roborio and encoders

		navRunner();
		generatePosVector();

		dataHandler.orientation = orientation;
		dataHandler.speedLeft = speedLeft;
		dataHandler.speedRight = speedRight;
		dataHandler.distanceDTLeft = distanceDTLeft;
		dataHandler.distanceDTRight = distanceDTRight;
		dataHandler.position = position;

		return dataHandler;
	}
}
