package org.mort11.navigation;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;

public class Nav6Backup {

	// IMU
	private static SerialPort serial_port = new SerialPort(57600,
			SerialPort.Port.kUSB);
	private static byte update_rate_hz = 50;
	private static IMUAdvanced imu = new IMUAdvanced(serial_port,
			update_rate_hz);

	private static double distanceFromWorldX;
	public final double distanceDeadband = .250;
	public static double compassHeading;

	public static void getXAxisOffset() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double currentXOffset = imu.getYaw();
		distanceFromWorldX = currentXOffset;
		System.out.println(distanceFromWorldX);
	}

	public void courseCorrect() {
		if (distanceFromWorldX <= distanceDeadband) {
			// Rotate right
		} else if (distanceFromWorldX >= distanceDeadband) {
			// Rotate left
		}
	}
}
