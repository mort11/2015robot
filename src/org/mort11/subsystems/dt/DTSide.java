package org.mort11.subsystems.dt;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public abstract class DTSide extends Subsystem
{
    
	private final Encoder enc;
    private final Talon motors;
    private double curVal = 0;	
    private final boolean motorReverse; 

    public DTSide(int motorPort, int encAPort, int encBPort, boolean
    			  motorReverse, boolean encReverse)
    {
    	motors = new Talon(motorPort);
    	enc = new Encoder(encAPort, encBPort, encReverse);
    	this.motorReverse = motorReverse; 
    	
    }
    
    public void set(double lspeed)
    {
        curVal = lspeed;
        motors.set(lspeed * (motorReverse ? -1 : 1));
    }
    
    public double getCurVal()
    {
    	return curVal;		
    }
    
    public double getRate()
    {
    	return enc.getRate();
    }
    
    public double getDist()
    {
    	return enc.getDistance();
    }
    
    
}

		