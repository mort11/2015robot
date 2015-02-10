package org.mort11.navigation;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class Navigation {

	// RoboRio on-board accelerometer values
	private static BuiltInAccelerometer rio_accel = new BuiltInAccelerometer();

	private static double rio_xAccel;
	private static double rio_yAccel;
	private static double rio_zAccel;

	// Encoder values
	private static Encoder enc = new Encoder(0, 1, false, EncodingType.k4X);

	private static double distance;

	// RoboRIO Data handling

	private static double roborio_xAccel() {
		rio_xAccel = rio_accel.getX();
		return rio_accel.getX();
	}

	private static double roborio_yAccel() {
		rio_yAccel = rio_accel.getY();
		return rio_accel.getY();
	}

	private static double roborio_zAccel() {
		rio_zAccel = rio_accel.getZ();
		return rio_accel.getZ();
	}

	// Encoder Data handling

	public static void getDistance() {
		distance = enc.getDistance();
		System.out.println(distance);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
