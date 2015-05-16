package org.mort11.commands.dt;

import static org.mort11.Robot.oi;
import static org.mort11.Robot.right;

/**
 * @author gridbug
 */
public class DriveLinearRight extends DriveLinear {

    public DriveLinearRight() {
        super(right);
    }

    protected double getSpeed() {
        return oi.getRightJoy();
    }

}
