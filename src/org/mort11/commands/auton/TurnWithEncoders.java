package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.dt.LeftDT;

public class TurnWithEncoders extends Command {
    double speed;

    public TurnWithEncoders(double speed) {
        this.speed = speed;
        requires(Robot.left);
        requires(Robot.right);
    }

    protected void initialize() {
        LeftDT.resetEnc();
    }

    protected void execute() {
        Robot.left.set(-speed);
        Robot.right.set(speed);
        System.out.println(LeftDT.getDist());
    }

    protected boolean isFinished() {
        if (LeftDT.getDist() >= -10)
            return false;
        else
            return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
