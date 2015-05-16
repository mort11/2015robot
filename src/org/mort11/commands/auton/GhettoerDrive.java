package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;

public class GhettoerDrive extends Command {
    Timer timer;
    double timeToDrive;
    double volt;

    public GhettoerDrive(double time, double volt) {
        requires(Robot.left);
        requires(Robot.right);
        this.timeToDrive = time;
        this.volt = volt;
    }

    protected void initialize() {
        timer = new Timer();
        timer.start();
    }

    protected void execute() {
        while (timer.get() < timeToDrive) {
            //System.out.println(Robot.left.getDist() + " left");
            //System.out.println(Robot.right.getDist() + " right");
            Robot.left.set(volt + 0.06);
            Robot.right.set(volt);
        }
    }

    protected boolean isFinished() {
        return (timer.get() > timeToDrive);
    }

    protected void end() {
        Robot.left.set(0);
        Robot.right.set(0);
    }

    protected void interrupted() {
    }
}
