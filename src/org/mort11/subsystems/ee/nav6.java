package org.mort11.subsystems.ee;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class nav6 extends Subsystem {

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

	public void initDefaultCommand() {
		org.mort11.nav6 nav6 = new org.mort11.nav6();
	}

	public static void initIMU() {
		try {
			serial_port = new SerialPort(57600, SerialPort.Port.kUSB);
			byte update_rate_hz = 50;
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

	public static void setTimerChange() {
		double currentTime = timer.get(); // Get "wall" clock value
		double timerChange = currentTime - lastTimerVal;
		lastTimerVal = currentTime;
		currentTimeChange = timerChange;
	}

	public static void stopTimer() {
		timer.stop();
	}

	public static void setChangedVelocity() {
		float xAccel = imu.getWorldLinearAccelX();
		changedVelocity = currentTimeChange * xAccel;
	}

	public static void setCurrentVelocity() {
		lastVelocity = currentVelocity;
		currentVelocity = lastVelocity + changedVelocity;
	}

	public static void setChangedPos() {
		changedPosition = currentVelocity * currentTimeChange;
	}

	public static void setCurrentPos() {
		lastPosition = currentPosition;
		currentPosition = changedPosition + lastPosition;
	}

}
