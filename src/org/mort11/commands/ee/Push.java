package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

public class Push extends Command {
    /**
     * @author SaltNPeppa
     */
    private PneumaticSubsystem coOpPush = Robot.canArms;

    public Push() {
        requires(coOpPush);
    }

    protected void initialize() {
    }

    protected void execute() {
        coOpPush.setSolenoid(!coOpPush.isEngaged());
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
