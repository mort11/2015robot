package org.mort11.util;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;

public class nav6 {

	// IMU
	private static SerialPort serial_port;
	private static IMUAdvanced imu;

	// Timer
	private static double lastTimerVal = 0;
	private static double currentTimeChange = 0;

	// Velocity
	private static double changedVelocityX;
	private static double changedVelocityY;
	private static double changedVelocityZ;

	private static double currentVelocityX = 0;
	private static double currentVelocityY = 0;
	private static double currentVelocityZ = 0;
	private static double lastVelocityX = 0;
	private static double lastVelocityY = 0;
	private static double lastVelocityZ = 0;

	// Position
	private static double changedPositionX;
	private static double changedPositionY;
	private static double changedPositionZ;

	private static double currentPositionX;
	private static double currentPositionY;
	private static double currentPositionZ;

	private static double lastPositionX;
	private static double lastPositionY;
	private static double lastPositionZ;

	// Orientation
	private static double orientation;

	private static long elapsedTime;

	public static double[] array = new double[500];

	public class navigationalState {

		// Current velocity in feet per second
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

	private static void setChangedVelocityX() {
		float xAccel = imu.getWorldLinearAccelX();
		changedVelocityX = currentTimeChange * xAccel;
	}

	private static void setChangedVelocityY() {
		float yAccel = imu.getWorldLinearAccelY();
		changedVelocityY = currentTimeChange * yAccel;
	}

	private static void setChangedVelocityZ() {
		float zAccel = imu.getWorldLinearAccelZ();
		changedVelocityZ = currentTimeChange * zAccel;
	}

	private static void setCurrentVelocityX() {
		lastVelocityX = currentVelocityX;
		currentVelocityX = lastVelocityX + changedVelocityX;
	}

	private static void setCurrentVelocityY() {
		lastVelocityY = currentVelocityY;
		currentVelocityY = lastVelocityY + changedVelocityY;
	}

	private static void setCurrentVelocityZ() {
		lastVelocityZ = currentVelocityZ;
		currentVelocityZ = lastVelocityZ + changedVelocityZ;
	}

	private static void setChangedPosX() {
		changedPositionX = ((currentVelocityX + lastVelocityX) / 2)
				* currentTimeChange;
	}

	private static void setChangedPosY() {
		changedPositionY = ((currentVelocityY + lastVelocityY) / 2)
				* currentTimeChange;
	}

	private static void setChangedPosZ() {
		changedPositionZ = ((currentVelocityZ + lastVelocityZ) / 2)
				* currentTimeChange;
	}

	private static void setCurrentPosX() {
		lastPositionX = currentPositionX;
		currentPositionX = changedPositionX + lastPositionX;
	}

	private static void setCurrentPosY() {
		lastPositionY = currentPositionY;
		currentPositionY = changedPositionY + lastPositionY;
	}

	private static void setCurrentPosZ() {
		lastPositionZ = currentPositionZ;
		currentPositionZ = changedPositionZ + lastPositionZ;
	}

	private static void setOrientation() {
		// In degrees clockwise
		orientation = imu.getYaw();
	}

	public navigationalState getPosition() {
		navigationalState navState = new navigationalState();

		// Call position & velocity functions to set internal vars
		setTimerChange();

		setChangedVelocityX();
		setChangedVelocityY();
		setChangedVelocityZ();

		setCurrentVelocityX();
		setCurrentVelocityY();
		setCurrentVelocityZ();

		setChangedPosX();
		setChangedPosY();
		setChangedPosZ();

		setCurrentPosX();
		setCurrentPosY();
		setCurrentPosZ();

		setOrientation();

		// Setup output values
		navState.velX = currentVelocityX;
		navState.velY = currentVelocityY;
		navState.velZ = currentVelocityZ;

		navState.x = currentPositionX;
		navState.y = currentPositionY;
		navState.z = currentPositionZ;

		navState.orientation = orientation;
		return navState;
	}

	public static void populateData() {
		long startTime = System.currentTimeMillis();

		System.out.println("running");
		for (int i = 0; i < array.length; i++) {
			array[i] = imu.getWorldLinearAccelX();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("done");
		long endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
	}

	public static void printData() {

		for (int i = 0; i < array.length; i++) {
			System.out.println(i + ": " + (array[i]));
		}

		System.out.println("Running time was " + (elapsedTime / 1000)
				+ " seconds");
	}
}