package org.mort11.subsystems.ee;

import org.mort11.RobotMap;
import org.mort11.commands.ee.Elevate;

import static org.mort11.util.EEConstants.*;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VerticalActuator extends Subsystem 
{
    
	AnalogInput ir = new AnalogInput(RobotMap.IRPort);
	double height;
	
	/**
	 * get height of elevator
	 * @return displacement of elevator from origin inches
	 */
	public double getDisplacementInInches()
	{
		return 0;
	}
	public void zero()
	{
		
	}
	public double getHeight()
	{
		height = ir.getVoltage()*IRVoltsToInches;
		return height;
	}
	public void setSpeed(double speed)
	{
		
	}
    public void initDefaultCommand()
	{
       setDefaultCommand(new Elevate());
    }
}

