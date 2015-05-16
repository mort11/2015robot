package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.ActiveIntake;

public class IntakeRight extends Command {

    double speed;
    private ActiveIntake intakeRight = Robot.rightIntake;

    public IntakeRight() {
    }

    public IntakeRight(double speed) {
        this.speed = speed;
    }

    protected void initialize() {
        System.out.println("starting");
    }

    protected void execute() {
        intakeRight.set(speed);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
