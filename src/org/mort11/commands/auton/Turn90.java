package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;

public class Turn90 extends Command {
    Timer time;
    double error;

    public Turn90() {
        requires(Robot.left);
        requires(Robot.right);
    }

    protected void initialize() {
        time = new Timer();
        time.start();
    }

    protected void execute() {
        /**System.out.println(error + " turn error");
         error = 21 + Robot.right.getDist();
         Robot.left.set(error * 0.2);
         Robot.right.set(-error * 0.2);**/
        Robot.left.set(0.8);
        Robot.right.set(-0.8);
        System.out.println(Robot.left.getDist());
    }

    protected boolean isFinished() {
        // return Math.abs(error) < 0.03;
        return time.get() > 0.8;
    }

    protected void end() {
        Robot.left.set(0);
        Robot.right.set(0);
    }

    protected void interrupted() {
    }
}
