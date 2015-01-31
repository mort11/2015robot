
package org.mort11;

import org.mort11.subsystems.dt.LeftDT;
import org.mort11.subsystems.dt.RightDT;
import org.mort11.subsystems.ee.Claw;
import org.mort11.subsystems.ee.VerticalActuator;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

//	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static VerticalActuator elevator;
	public static Claw claw;
	public static LeftDT left;
	public static RightDT right;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public void robotInit() 
    {
		oi = new OI();
		elevator = new VerticalActuator();
		claw = new Claw();
		left = new LeftDT();
		right = new RightDT();
    }

    public void autonomousInit() 
    {
        // schedule the autonomous command 
    }

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}