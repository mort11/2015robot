package org.mort11.subsystems.ee;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ActiveIntake extends Subsystem {

    private Talon motors;

    public void initDefaultCommand() {
    }

    public ActiveIntake() {

    }

    public ActiveIntake(int talPort) {
        motors = new Talon(talPort);
    }

    public void set(double speed) {
        motors.set(speed);
        //System.out.println(this.getCurrentCommand());
    }

}
