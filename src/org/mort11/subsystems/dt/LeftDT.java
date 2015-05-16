package org.mort11.subsystems.dt;

import org.mort11.RobotMap;
import org.mort11.commands.dt.DriveLinear;
import org.mort11.commands.dt.DriveLinearLeft;

public class LeftDT extends DTSide {
    public LeftDT() {
        super(RobotMap.DT_LEFT_PORT, RobotMap.DT_ENC_LEFT_A, RobotMap.DT_ENC_LEFT_B, false, false);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveLinearLeft());
    }

    @Override
    protected DriveLinear getLinearDrive() {
        // TODO Auto-generated method stub
        return new DriveLinearLeft();
    }
}

