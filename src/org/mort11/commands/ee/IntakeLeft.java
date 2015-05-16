package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.ActiveIntake;

public class IntakeLeft extends Command {
    double speed;
    private ActiveIntake intakeLeft = Robot.leftIntake;

    public IntakeLeft(double speed) {
        this.speed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
        intakeLeft.set(speed);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
