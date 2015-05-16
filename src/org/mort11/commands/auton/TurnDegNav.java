package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;

public class TurnDegNav extends Command {

    private double desiredYaw;

    public TurnDegNav(double desiredYaw) {
        this.desiredYaw = desiredYaw;
        requires(Robot.left);
        requires(Robot.right);
    }

    protected void initialize() {
    }

    private double error;

    protected void execute() {
        error = desiredYaw - Robot.imu.getYaw();
        Robot.left.set(error * 0.1);
        Robot.right.set(-error * 0.1);
    }

    protected boolean isFinished() {
        return (error < 0.5 && error > -0.5);
    }

    protected void end() {
        Robot.left.set(0);
        Robot.right.set(0);
    }

    protected void interrupted() {
    }
}
