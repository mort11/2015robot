package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.subsystems.ee.VerticalActuator;

import static org.mort11.Robot.oi;

public class ManualElevate extends Command {
    private VerticalActuator elevator = Robot.elevator;
    private PneumaticSubsystem brake = Robot.brake;
    private PneumaticSubsystem intake = Robot.PneumaticIntake;
    // private OI oi = Robot.oi;
    private double speed; // speed as given by joystick
    // lexi and jakob code

    public ManualElevate() {
        requires(elevator);
    }

    // public ManualElevate(double speed){
    // this.speed = speed;
    // }

    protected void initialize() {
        brake.setSolenoid(false);
        setInterruptible(true);
    }

    protected void execute() {
        System.out.println("execute");
        System.out.println("Joystick val: " + oi.ee.getY());
        speed = oi.getEEJoy();
        // if (elevator.getHeight() < EEConstants.OPEN_INTAKE_HIGHT) {
        // intake.setSolenoid(intake.isEngaged() == false);
        // }
        if (elevator.getHeight() < 0 && speed < 0) {
            System.out.println("below switch");
            elevator.setSpeed(oi.getEEJoy());
        } else {
            elevator.setSpeed(oi.getEEJoy());
        }
    }

    protected boolean isFinished() {
        System.out.println("isFinished");
        if (oi.manuElevOff.get()) {
            return true;
        } else {
            return false;
        }
        // return elevator.getBottomLim();
    }

    protected void end() {
        if (elevator.getBottomLim()) {
            elevator.resetEnc();
            // push out of sketchy zone
            // elevator.setSpeed(EEConstants.PUSHOUT_SPEED);
            // while(time.get() < 0.5);
            // System.out.println("pushing");
        } else if (elevator.getTopLim()) {
            // push out of sketchy zone
            // elevator.setSpeed(-EEConstants.PUSHOUT_SPEED);
            // while(time.get() < 0.5);
        }
        System.out.println("end");
        Robot.elevator.setSpeed(0);
        brake.setSolenoid(true);
    }

    // makes sure we aren't heading in the same way as the switch

    protected void interrupted() {
        // cri
        System.out.println("interrupted");
    }
}
