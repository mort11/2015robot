package org.mort11.util;

public class Profiler {
	double maxVel;
	double timeToTarget;
	public Profiler(double maxVel, double timeToTarget)
	{
		this.maxVel = maxVel;
		this.timeToTarget = timeToTarget;
	}
	public double getDesiredVelocity(double currTime)
	{
		//ramp up period(1/3 of TTT)
		if(currTime < timeToTarget/3) {
			System.out.println("ramping");
			//v(t) = 3*(mV/TTT) * t from (0,0) to (TTT/3,mV) 
			return (3 * maxVel/timeToTarget) * currTime;
		} else if(currTime >= timeToTarget/3 && currTime <= (2*timeToTarget/3)){
			System.out.println("coasting");
			return maxVel; //coast
		} else {
			System.out.println("rolling down");
			//v(t) = (-3*(mV/TTT)) * t + 3mV from (2TTT/3,mV) to (TTT,0)
			return ((-3 * maxVel * currTime)/timeToTarget) + 3*maxVel;  
		}
	}
}
