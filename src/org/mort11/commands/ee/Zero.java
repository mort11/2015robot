package org.mort11.commands.ee;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.subsystems.ee.PneumaticSubsystem;
import org.mort11.subsystems.ee.VerticalActuator;
import org.mort11.util.EEConstants;

public class Zero extends Command {
    private VerticalActuator elevator = Robot.elevator;
    private PneumaticSubsystem brake = Robot.brake;
    private PneumaticSubsystem intake = Robot.PneumaticIntake;

    public Zero() {
        requires(elevator);
        requires(brake);
    }

    protected void initialize() {
        Robot.brake.setSolenoid(false);
    }

    protected void execute() {
        Robot.elevator.setSpeed(-EEConstants.LOWERING_SPEED);
        Robot.PneumaticIntake.setSolenoid(true);
        System.out.println(elevator.getBottomLim());
        // if (elevator.getHeight() < EEConstants.OPEN_INTAKE_HIGHT) {
        // intake.setSolenoid(intake.isEngaged() == false);
        // }
    }

    protected boolean isFinished() {
        return elevator.getBottomLim();
    }

    protected void end() {
        elevator.setSpeed(0);
        elevator.resetEnc();
        System.out.println("zeroed");
        brake.setSolenoid(true);
    }

    protected void interrupted() {
    }
}
