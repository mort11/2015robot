package org.mort11.navigation;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;

public class Nav6 {

	// Global variables
	private final static double gravitationalAccel = 32.17404855643;

	// IMU
	private static SerialPort serial_port = new SerialPort(57600,
			SerialPort.Port.kUSB);
	private static final byte update_rate_hz = 50;
	private static IMUAdvanced imu = new IMUAdvanced(serial_port,
			update_rate_hz);

	// Timer
	private double currentTime = 0;
	private double lastTimerVal = 0;
	private double currentTimeChange = 0;

	// Velocity
	private double deltaVelocityX;
	private double deltaVelocityY;

	// Orientation
	private double orientation;

	// private double currentVal = 0;

	public class navigationalUpdate {
		public double timerChange;
		public double velXChange;
		public double velYChange;

		// In degrees from init
		public double orientation;
	}

	// Init timer
	public Timer timer = new Timer();

	public double setTimerChange() {
		currentTime = timer.get(); // Get "wall" clock value
		double timerChange = currentTime - lastTimerVal;
		lastTimerVal = currentTime;
		currentTimeChange = timerChange;
		return currentTimeChange;
	}

	public static void zero() {
		imu.zeroYaw();
	}

	public double setDeltaVelocityX() {
		double xAccel = imu.getWorldLinearAccelX() * gravitationalAccel;
		deltaVelocityX = currentTimeChange * xAccel;
		return deltaVelocityX;
	}

	public double setDeltaVelocityY() {
		double yAccel = -imu.getWorldLinearAccelY() * gravitationalAccel;
		deltaVelocityY = currentTimeChange * yAccel;
		return deltaVelocityY;
	}

	public double setOrientation() {
		// In degrees clockwise
		orientation = imu.getYaw();
		return orientation;
	}

	public navigationalUpdate getPosition() {
		// SHOULD ONLY BE CALLED ONCE EVERY TIMESTEP
		navigationalUpdate navState = new navigationalUpdate();

		// Call position & velocity functions to set internal vars
		setTimerChange();

		setDeltaVelocityX();
		setDeltaVelocityY();

		setOrientation();

		// Setup output values
		navState.timerChange = currentTimeChange;
		navState.velXChange = deltaVelocityX;
		navState.velYChange = deltaVelocityY;
		navState.orientation = orientation;
		return navState;
	}
}