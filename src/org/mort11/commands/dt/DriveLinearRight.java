/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.commands.dt;

import static org.mort11.Robot.*;
/**
 *
 * @author gridbug
 */
public class DriveLinearRight extends DriveLinear
{

    public DriveLinearRight()
    {
        super(right);
    }

    protected double getSpeed()
    {
        return oi.getRightJoy();
    }

}
