package org.mort11.navigation;

import org.mort11.navigation.Nav6.navigationalState;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;

public class Navigation {
	
	// Global variables
	// IMU initilization
		private static SerialPort serial_port = new SerialPort(57600, SerialPort.Port.kUSB);
		private final static byte update_rate_hz = 50;
		private static IMUAdvanced imu = new IMUAdvanced(serial_port, update_rate_hz);

	// Nav accel & compass heading values
		private static double nav_xAccel;
		private static double nav_yAccel;
		private static double nav_zAccel;
		
		private static double compassHeading;
		
	// RoboRio on-board accelerometer values
		private static BuiltInAccelerometer rio_accel = new BuiltInAccelerometer();
		
		private static double rio_xAccel;
		private static double rio_yAccel;
		private static double rio_zAccel;
	
	// Encoder values	
		private static Encoder enc = new Encoder(0,1,false,EncodingType.k4X);
		
		private static double distance;
		
	// Nav6 Data handling
	
	private static double compassHeading(){
		compassHeading = imu.getCompassHeading();
		return imu.getCompassHeading();
	}
	private static double nav_xAccel(){
		nav_xAccel = imu.getWorldLinearAccelX();
		return imu.getWorldLinearAccelX();
	}
	private static double nav_yAccel(){
		nav_yAccel = imu.getWorldLinearAccelY();
		return imu.getWorldLinearAccelY();
	}
	private static double nav_zAccel(){
		nav_zAccel = imu.getWorldLinearAccelZ();
		return imu.getWorldLinearAccelZ();
	}
	
	
	// RoboRIO Data handling
	
	private static double roborio_xAccel(){
		rio_xAccel = rio_accel.getX();
		return rio_accel.getX();
	}
	private static double roborio_yAccel(){
		rio_yAccel = rio_accel.getY();
		return rio_accel.getY();
	}
	private static double roborio_zAccel(){
		rio_zAccel = rio_accel.getZ();
		return rio_accel.getZ();
	}
	
	
	// Encoder Data handling
	
	private static double getDistance(){
		distance = enc.getDistance();
		return enc.getDistance();
	}
	
	// Data fusion
	
	private static void dataFuzer(){
		if(nav_xAccel-rio_xAccel > .230){
			// nav6 or rio aren't reading properly
		}
	
		navigationalState navState = new navigationalState();
		navState.
	}
}
