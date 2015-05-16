package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.ActiveIntake;
import org.mort11.subsystems.ee.ActiveIntakeLeft;

public class IntakeBoth extends Command {
    double speed;
    private ActiveIntakeLeft intakeLeft = Robot.leftIntake;
    private ActiveIntake intakeRight = Robot.rightIntake;
    boolean initState;

    public IntakeBoth(double speed) {
        requires(intakeLeft);
        requires(intakeRight);
        this.speed = speed;
        this.initState = Robot.PneumaticIntake.isEngaged();
    }

    protected void initialize() {
        setInterruptible(true);
    }

    protected void execute() {
        System.out.println(speed);
        if (/*intakeLeft.getSwitch() && !initState*/false) {
            //Robot.PneumaticIntake.setSolenoid(!Robot.PneumaticIntake.isEngaged());
            intakeLeft.set(0);
            intakeRight.set(0);
            System.out.println("hit");
        } else {
            intakeLeft.set(speed);
            intakeRight.set(speed);
        }
        initState = Robot.PneumaticIntake.isEngaged();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
