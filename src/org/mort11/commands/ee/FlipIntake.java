package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

public class FlipIntake extends Command {

    boolean isClosed = true; //idk
    private PneumaticSubsystem intake = Robot.PneumaticIntake;

    public FlipIntake(boolean isClosed) {
        this.isClosed = isClosed;
        requires(intake);
    }

    public FlipIntake() {
        System.out.println("contructed");
        requires(intake);
        this.isClosed = !intake.isEngaged();
    }

    protected void initialize() {
        System.out.println("init");
    }

    protected void execute() {
        System.out.println(isClosed);
        System.out.println("called");
        System.out.println(intake.isEngaged() + " intake eng");
        intake.setSolenoid(!intake.isEngaged());
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
