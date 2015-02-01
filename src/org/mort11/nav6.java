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

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;

public class nav6 {

	private static SerialPort serial_port;
	private static IMUAdvanced imu;
	// Timer stuff
	private static double lastTimerVal = 0;
	private static double currentTimeChange = 0;
	// private static double timerMin = 2000;
	// private static double timerMax = -1;
	// private static int counter = 0;
	// Velocity stuff
	private static double changedVelocity;
	private static double currentVelocity = 0;
	private static double lastVelocity = 0;
	// Position stuff
	private static double changedPosition;
	private static double currentPosition;
	private static double lastPosition;

	public class navigationalState {

		// Current velocity in feet per second
		public double currentVelocity;
		public double velX;
		public double velY;
		public double velZ;

		// Position in feet from init
		public double x;
		public double y;
		public double z;

		// In degrees from init
		public double orientation; // Todo
	}

	// Init timer
	public static Timer timer = new Timer();

	// Init IMU unit
	public static void initIMU() {
		try {
			serial_port = new SerialPort(57600, SerialPort.Port.kUSB);
			byte update_rate_hz = 50;
			imu = new IMUAdvanced(serial_port, update_rate_hz);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void setTimerChange() {
		double currentTime = timer.get(); // Get "wall" clock value
		double timerChange = currentTime - lastTimerVal;
		lastTimerVal = currentTime;
		currentTimeChange = timerChange;
	}

	private static void setChangedVelocity() {
		// double timerChange = getTimerChange();
		float xAccel = imu.getWorldLinearAccelX();
		changedVelocity = currentTimeChange * xAccel;

	}

	private static void setCurrentVelocity() {
		lastVelocity = currentVelocity;
		currentVelocity = lastVelocity + changedVelocity;
	}

	private static void setChangedPos() {
		changedPosition = currentVelocity * currentTimeChange;
	}

	private static void setCurrentPos() {
		lastPosition = currentPosition;
		currentPosition = changedPosition + lastPosition;
	}

	public navigationalState getPosition() {
		navigationalState navState = new navigationalState();

		// Setup output values
		navState.currentVelocity = currentVelocity;
		return null;
	}
}