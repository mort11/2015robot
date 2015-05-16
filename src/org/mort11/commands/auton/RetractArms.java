package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;

/**
 * Called after robot has moved backwards, at the end of autonomous
 */
public class RetractArms extends Command {

    private PneumaticSubsystem armUp = Robot.autonArmUp;
    private PneumaticSubsystem leftArm = Robot.autonLeft;
    private PneumaticSubsystem rightArm = Robot.autonRight;
    Timer time = new Timer();

    public RetractArms() {
        requires(armUp);
        requires(leftArm);
        requires(rightArm);
    }

    protected void initialize() {
    }

    protected void execute() {
        armUp.setSolenoid(false);
        time.start();
        if (time.get() >= .5) {
            leftArm.setSolenoid(false);
            rightArm.setSolenoid(false);
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
