/*       __  __  ____  _____ _______   __ __
        |  \/  |/ __ \|  __ \__   __| /_ /_ |
        | \  / | |  | | |__) | | |     | || |
        | |\/| | |  | |  _  /  | |     | || |
        | |  | | |__| | | \ \  | |     | || |
        |_|  |_|\____/|_|  \_\ |_|     |_||_|
 
           FRC Team 11, Flanders NJ 07836
 
        Copyright (c) 2015 Mount Olive Robotics Team
 */

package org.mort11;

import java.io.PrintStream;

import org.mort11.commands.auton.OneTote;
import org.mort11.commands.ee.ElevatorBrake;
import org.mort11.commands.ee.Zero;
import org.mort11.subsystems.dt.DTSide;
import org.mort11.subsystems.dt.LeftDT;
import org.mort11.subsystems.dt.RightDT;
import org.mort11.subsystems.ee.ActiveIntakeLeft;
import org.mort11.subsystems.ee.ActiveIntakeRight;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.subsystems.ee.VerticalActuator;

import com.elevendustries.firecracker.Firecracker;
import com.elevendustries.firecracker.RGBChannel;
import com.elevendustries.firecracker.UpdateChannels;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	public static VerticalActuator elevator;
	public static DTSide left;
	public static RightDT right;
	public static OI oi;
	public static PneumaticSubsystem PneumaticIntake;
	public static PneumaticSubsystem brake;
	public static PneumaticSubsystem autonArmUp;
	public static PneumaticSubsystem autonLeft;
	public static PneumaticSubsystem autonRight;
	public static Firecracker firecracker;
	public static PrintStream logfile;
	public static ActiveIntakeLeft leftIntake;
	public static ActiveIntakeRight rightIntake;
	//Diagnostics diagnostics = new Diagnostics();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() { 
		PneumaticIntake = new PneumaticSubsystem(RobotMap.CLAW_CLOSED, RobotMap.CLAW_OPEN);
		// Change console output to write to file
		//System.setOut(logfile);

		elevator = new VerticalActuator();
		 //claw = new PneumaticSubsystem(RobotMap.CLAW_CLOSED,
		 //RobotMap.CLAW_OPEN);
		brake = new PneumaticSubsystem(RobotMap.BRAKE_ENGAGED,
				RobotMap.BRAKE_DISENGAGED);
		right = new RightDT();
		left = new LeftDT();
		leftIntake = new ActiveIntakeLeft();
		rightIntake = new ActiveIntakeRight();
		// firecracker = new Firecracker();
		oi = new OI();
		/**
		 * autonArmUp = new PneumaticSubsystem(RobotMap.CENTER_PISTON_ENGAGED,
		 * RobotMap.CENTER_PISTON_NOT_ENGAGED); autonLeft = new
		 * PneumaticSubsystem(RobotMap.LEFT_PISTON_ENGAGED,
		 * RobotMap.LEFT_PISTON_NOT_ENGAGED); autonRight = new
		 * PneumaticSubsystem(RobotMap.RIGHT_PISTON_ENGAGED,
		 * RobotMap.RIGHT_PISTON_NOT_ENGAGED); System.out.println("starting");
		 **/
		/**
		// Gotta write the logs
		try {
			diagnostics.writeLogs(logfile);
		} catch (IOException e) {
		}**/
	}

	public void autonomousInit() {
		// Change console output to write to file
		//System.setOut(logfile);

		// new ElevateToHeight(2, true).start();// tbd
		System.out.println("auton started");
		// tal1.set(0.5); tal2.set(0.5);
		new ElevatorBrake(false).start();
		//new Zero().start();
		new OneTote().start();
		/**
		// Gotta write the logs
		try {
			diagnostics.writeLogs(logfile);
		} catch (IOException e) {
		}**/
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		// Change console output to write to file
		//System.setOut(logfile);
		//Robot.left.set(1);
    	//Robot.right.set(1);
		Scheduler.getInstance().run();

		/**
		 // Gotta write the logs
		try {
			diagnostics.writeLogs(logfile);
		} catch (IOException e) {
		}**/
	}

	public void teleopInit() {
		// Change console output to write to file
		//System.setOut(logfile);

		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// System.out.println(left.getCurrentCommand());
		// System.out.println(right.getCurrentCommand());
		new ElevatorBrake(false).start();
		new Zero().start();

		/**
		// Gotta write the logs
		try {
			diagnostics.writeLogs(logfile);
		} catch (IOException e) {
		}**/
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		// Change console output to write to file
		//System.setOut(logfile);

		Scheduler.getInstance().run();
		/**
		// Gotta write the logs
		try {
			diagnostics.writeLogs(logfile);
		} catch (IOException e) {
		}**/
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		// Change console output to write to file
		//System.setOut(logfile);

		//LiveWindow.run();
		/**
		// Gotta write the logs
		try {
			diagnostics.writeLogs(logfile);
		} catch (IOException e) {
		}**/
	}

	public void writeColor(byte r, byte g, byte b) {
		RGBChannel thing = new RGBChannel(1, 2, 3, firecracker);
		thing.setRGB(255, 255, 0);
		new UpdateChannels(firecracker);
	}

}