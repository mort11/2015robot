package org.mort11.navigation;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;

public class Nav6 {

	// Global variables
	// private final double gravitationalAccel = 32.17404855643;

	// IMU
	private SerialPort serial_port = new SerialPort(57600, SerialPort.Port.kUSB);
	private final byte update_rate_hz = 50;
	private IMUAdvanced imu = new IMUAdvanced(serial_port, update_rate_hz);

	// Timer
	private double currentTime = 0;
	private double lastTimerVal = 0;
	private double currentTimeChange = 0;

	// Velocity
	private double changedVelocityX;
	private double changedVelocityY;

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

	public double setChangedVelocityX() {
		double xAccel = imu.getWorldLinearAccelX();
		changedVelocityX = currentTimeChange * xAccel;
		return changedVelocityX;
	}

	public double setChangedVelocityY() {
		double yAccel = imu.getWorldLinearAccelY();
		changedVelocityY = currentTimeChange * yAccel;
		return changedVelocityY;
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

		setChangedVelocityX();
		setChangedVelocityY();

		setOrientation();

		// Setup output values
		navState.timerChange = currentTimeChange;
		navState.velXChange = changedVelocityX;
		navState.velYChange = changedVelocityY;
		navState.orientation = orientation;
		return navState;
	}
}