/*
 * This is just some boilerplate code for nav6 stuff
 */
package org.mort11;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class nav6 {

	SerialPort serial_port;
	// IMU imu; // Uncomment this to use less-featured IMU
	IMUAdvanced imu;
	boolean first_iteration;

	public nav6() {

		try {

			// Create the port we're listening on
			serial_port = new SerialPort(57600, SerialPort.Port.kUSB);

			// You can add a second parameter to modify the
			// update rate (in hz) from 4 to 100. The default is 100.
			// If you need to minimize CPU load, you can set it to a
			// lower value, as shown here, depending upon your needs.

			// You can also use the IMUAdvanced class for advanced features

			// How often we're checking the IMU unit
			byte update_rate_hz = 50;
			
			// imu = new IMU(serial_port,update_rate_hz); // Use this if using IMU and not IMUAdvanced
			imu = new IMUAdvanced(serial_port, update_rate_hz);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void putData() {

		// This method (putData) should be called during the autonomous period
		// and the teleop period

		// Update the smartdashboard with status and orientation data from the
		// nav6 IMU

		// Smartdasboard is only usable if the end-user has smartdashboard installed
		// Below code is completely optional and is really for debugging purposes

		SmartDashboard.putBoolean("IMU_Connected", imu.isConnected());
		SmartDashboard.putBoolean("IMU_IsCalibrating", imu.isCalibrating());
		SmartDashboard.putNumber("IMU_Yaw", imu.getYaw());
		SmartDashboard.putNumber("IMU_Pitch", imu.getPitch());
		SmartDashboard.putNumber("IMU_Roll", imu.getRoll());
		SmartDashboard.putNumber("IMU_CompassHeading", imu.getCompassHeading());
		SmartDashboard.putNumber("IMU_Update_Count", imu.getUpdateCount());
		SmartDashboard.putNumber("IMU_Byte_Count", imu.getByteCount());

		// If you are using the IMUAdvanced class, you can also access the following
		// additional functions, at the expense of some extra processing
		// that occurs on the processor

		SmartDashboard.putNumber("IMU_Accel_X", imu.getWorldLinearAccelX());
		SmartDashboard.putNumber("IMU_Accel_Y", imu.getWorldLinearAccelY());
		SmartDashboard.putBoolean("IMU_IsMoving", imu.isMoving());
		SmartDashboard.putNumber("IMU_Temp_C", imu.getTempC());

		// Wait before repeating
		Timer.delay(0.2);
	}
}