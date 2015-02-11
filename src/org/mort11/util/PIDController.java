package org.mort11.util;

public class PIDController 
{
	double setpoint;
	double PConst;
	double IConst;
	public PIDController(double setpoint, double PConst, double IConst )
	{
		this.setpoint = setpoint;
		this.PConst = PConst;
		this.IConst = IConst;
	}
	public double getOutput(int currpos)
	{
		return 0;
	}
}
