package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

/**
 * Called in auton after the robot reaches the step
 */
public class ArmsAtStep extends Command {
    private PneumaticSubsystem armUp = Robot.autonArmUp;
    private PneumaticSubsystem leftArm = Robot.autonLeft;
    private PneumaticSubsystem rightArm = Robot.autonRight;

    public ArmsAtStep() {
        requires(armUp);
        requires(leftArm);
        requires(rightArm);
    }

    protected void initialize() {
    }

    protected void execute() {
        armUp.setSolenoid(true);// tbd does true mean the solenoid is
        // being put out?
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
