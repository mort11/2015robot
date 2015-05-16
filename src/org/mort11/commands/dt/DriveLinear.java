package org.mort11.commands.dt;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.subsystems.dt.DTSide;

public abstract class DriveLinear extends Command {

    protected DTSide side;

    protected DriveLinear(DTSide dt) {
        side = dt;
        requires(dt);
        setInterruptible(true);
    }

    protected void initialize() {
    }

    protected abstract double getSpeed();

    protected void execute() {
        side.set(getSpeed());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
