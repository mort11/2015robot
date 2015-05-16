package org.mort11.subsystems.dt;

import org.mort11.RobotMap;
import org.mort11.commands.dt.DriveLinear;
import org.mort11.commands.dt.DriveLinearRight;

public class RightDT extends DTSide {
    public RightDT() {
        super(RobotMap.DT_RIGHT_PORT, RobotMap.DT_ENC_RIGHT_A, RobotMap.DT_ENC_RIGHT_B, true, false);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveLinearRight());
    }

    @Override
    protected DriveLinear getLinearDrive() {
        // TODO Auto-generated method stub
        return new DriveLinearRight();
    }
}