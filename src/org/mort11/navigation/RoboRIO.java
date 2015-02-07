package org.mort11.navigation;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;

public class RoboRIO {
	private static void getXAccel() {
		BuiltInAccelerometer roborio = new BuiltInAccelerometer();
		roborio.getX();
	}
}
