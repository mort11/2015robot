package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class WaitTime extends Command {
    Timer time;
    double timeToWait;

    public WaitTime(double timeToWait) {
        time = new Timer();
        this.timeToWait = timeToWait;
    }

    protected void initialize() {
        time.start();
    }

    protected void execute() {
        //partay
    }

    protected boolean isFinished() {
        return (time.get() > timeToWait);
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
