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
	// private static double timerMin = 2000;
	// //private static double timerMax = -1;
	private static int counter = 0;
	// Velocity stuff
	private static double changedVelocity;
	private static double currentVelocity;
	private static double lastVelocity = 0;
	// Position stuff
	private static double changedPosition;
	private static double currentPosition;
	private static double lastPosition;

	public static void initIMU() {
		try {
			serial_port = new SerialPort(57600, SerialPort.Port.kUSB);

			// You can add a second parameter to modify the
			// update rate (in hz) from 4 to 100. The default is 100.
			// If you need to minimize CPU load, you can set it to a
			// lower value, as shown here, depending upon your needs.

			// You can also use the IMUAdvanced class for advanced
			// features.

			byte update_rate_hz = 50;
			// imu = new IMU(serial_port,update_rate_hz);
			imu = new IMUAdvanced(serial_port, update_rate_hz);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static Timer timer = new Timer();

	// Handling methods

	public static void initTimer() {
		timer.start(); // Counts from 0 in seconds
	}

	public static double getTimerChange() {
		double currentTime = timer.get(); // Get "wall" clock value
		double timerChange = currentTime - lastTimerVal;
		lastTimerVal = currentTime;
		return timerChange;
	}

	public static void stopTimer() {
		timer.stop();
	}

	public static void getChangedVelocity() {
		double timerChange = getTimerChange();
		float xAccel = imu.getWorldLinearAccelX();
		changedVelocity = timerChange * xAccel;
		// System.out.println(timerChange * xAccel);
		/*
		 * System.out.println(timerChange); if (timerChange > timerMax) {
		 * timerMax = timerChange; }
		 * 
		 * if (timerChange < timerMin) { timerMin = timerChange; }
		 * 
		 * if (counter == 50) { System.out.println("Min: " + timerMin);
		 * System.out.println("Max: " + timerMax); counter = 0; }
		 */
		counter++;
		lastVelocity = currentVelocity;
	}

	public static void getCurrentVelocity() {
		currentVelocity = lastVelocity + changedVelocity;
	}

	public static void getChangedPos() {
		double timerChange = getTimerChange();
		changedPosition = currentVelocity * timerChange;
	}

	public static void getCurrentPos() {
		currentPosition = changedPosition + lastPosition;
	}
}
