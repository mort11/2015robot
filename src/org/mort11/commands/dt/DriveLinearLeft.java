package org.mort11.commands.dt;

import static org.mort11.Robot.left;
import static org.mort11.Robot.oi;

/**
 * @author gridbug
 */
public class DriveLinearLeft extends DriveLinear {

    public DriveLinearLeft() {
        super(left);
    }

    protected double getSpeed() {
        return oi.getLeftJoy();
    }


}
