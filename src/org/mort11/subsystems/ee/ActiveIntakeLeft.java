package org.mort11.subsystems.ee;

import edu.wpi.first.wpilibj.DigitalInput;
import org.mort11.RobotMap;

public class ActiveIntakeLeft extends ActiveIntake {
    private DigitalInput intakeLim;

    public ActiveIntakeLeft() {
        super(RobotMap.ACTIVE_INTAKE_TAL_LEFT);
        intakeLim = new DigitalInput(RobotMap.INTAKE_SWITCH);
    }

    public boolean getSwitch() {
        return !intakeLim.get();
    }

}
