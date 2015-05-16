package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

public class ElevatorBrake extends Command {
    private boolean isBrakeOn;
    private PneumaticSubsystem brake = Robot.brake;

    //this is bad but i want to test before using this constructor
    public ElevatorBrake(boolean isBrakeOn) {
        this.isBrakeOn = isBrakeOn;
        requires(brake);
    }

    public ElevatorBrake() {

    }

    protected void initialize() {

    }

    protected void execute() {
        brake.setSolenoid(!brake.isEngaged());
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    protected void interrupted() {
    }
}
