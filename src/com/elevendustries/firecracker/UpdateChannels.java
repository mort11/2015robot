package com.elevendustries.firecracker;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class UpdateChannels extends Command {

    private final Firecracker firecracker;
    private final Timer timer;

    private static final double UPDATE_HERTZ = 30;

    public UpdateChannels(Firecracker firecracker) {
        requires(firecracker);
        setInterruptible(false);
        this.firecracker = firecracker;
        this.timer = new Timer();
    }

    protected void initialize() {
        timer.start();
    }

    protected void execute() {
        if (timer.get() > 1 / UPDATE_HERTZ) {
            firecracker.updateAllChannels();
            timer.reset();
        }

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
