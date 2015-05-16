package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;

/**
 *
 */
public class CrayTurn extends Command {
    Timer time = new Timer();

    public CrayTurn() {
        requires(Robot.left);
        requires(Robot.right);
    }

    protected void initialize() {
        time.start();
    }

    protected void execute() {
        System.out.println(time.get());
        Robot.left.set(0.82);
        Robot.right.set(0.2);
    }

    protected boolean isFinished() {
        return time.get() > 0.5;
    }

    protected void end() {
        Robot.left.set(0);
        Robot.right.set(0);
    }

    protected void interrupted() {
    }
}
