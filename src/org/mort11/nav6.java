package org.mort11;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;

public class nav6 {

	private static SerialPort serial_port;
	private static IMUAdvanced imu;
	private static double lastTimerVal = 0;

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
		// System.out.println(timerChange * xAccel);
		System.out.println(xAccel);
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static double getCurrentVelocity() {
		return 0;
	}

	public static double getChangedPos() {
		return 0;
	}

	public double getCurrentPos() {
		return 0;
	}
}
