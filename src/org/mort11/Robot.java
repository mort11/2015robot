package org.mort11;

import com.elevendustries.firecracker.Firecracker;
import com.elevendustries.firecracker.RGBChannel;
import com.elevendustries.firecracker.UpdateChannels;
import com.kauailabs.nav6.frc.IMUAdvanced;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.mort11.commands.auton.*;
import org.mort11.commands.ee.ElevatorBrake;
import org.mort11.commands.ee.FlipIntake;
import org.mort11.subsystems.dt.DTSide;
import org.mort11.subsystems.dt.LeftDT;
import org.mort11.subsystems.dt.RightDT;
import org.mort11.subsystems.ee.ActiveIntakeLeft;
import org.mort11.subsystems.ee.ActiveIntakeRight;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.subsystems.ee.VerticalActuator;

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
    public static PneumaticSubsystem canArms;
    public static Firecracker firecracker;
    public static ActiveIntakeLeft leftIntake;
    public static ActiveIntakeRight rightIntake;
    public static IMUAdvanced imu;


    SendableChooser autonChooser;

    public void robotInit() {
        PneumaticIntake = new PneumaticSubsystem(RobotMap.CLAW_CLOSED,RobotMap.CLAW_OPEN);

        elevator = new VerticalActuator();
        brake = new PneumaticSubsystem(RobotMap.BRAKE_ENGAGED, RobotMap.BRAKE_DISENGAGED);
        right = new RightDT();
        left = new LeftDT();
        leftIntake = new ActiveIntakeLeft();
        rightIntake = new ActiveIntakeRight();
        canArms = new PneumaticSubsystem(4, 5);
        oi = new OI();

        autonChooser = new SendableChooser();
        autonChooser.addDefault("Drive Straight", new GhettoerDrive(3.5, 0.45));
        autonChooser.addObject("One Can/Tote", new OneTote());
        autonChooser.addObject("Do Nothing", new WaitTime(1));
        autonChooser.addObject("3 TOTE MLG", new ThreeTote());
        autonChooser.addObject("Test", new GhettoerDrive(5, 0.45));
        autonChooser.addObject("2 can", new TwoCan());
        autonChooser.addObject("Pickup Can", new PickupCan());
        SmartDashboard.putData("Autonomous Mode", autonChooser);
    }

    Command autonCommand = new WaitTime(0);

    public void autonomousInit() {
        System.out.println("auton started");
        new ElevatorBrake(false).start();
        autonCommand = (Command) autonChooser.getSelected();
        System.out.println(autonCommand);
        autonCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        autonCommand.cancel();
        new ElevatorBrake(false).start();
        new FlipIntake().start();

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    int i = 0;

    public void testPeriodic() {
        if (i == 0)
            System.out.println("called");
        new FlipIntake().start();
        i++;
        System.out.println(PneumaticIntake.isEngaged());
    }

    public void writeColor(byte r, byte g, byte b) {
        RGBChannel thing = new RGBChannel(1, 2, 3, firecracker);
        thing.setRGB(255, 255, 0);
        new UpdateChannels(firecracker);
    }
}