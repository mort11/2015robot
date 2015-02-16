package org.mort11.util;

public class Profiler {
	double maxVel;
	double timeToTarget;
	public Profiler(double maxVelocity, double timeToTarget)
	{
		this.maxVel = maxVelocity;
		this.timeToTarget = timeToTarget;
	}
	
	//each leg of the trap is given (1/3)t
	public double getDesiredVelocity(double currTime)
	{
		//ramp up period(1/3 of TTT)
		if(currTime < timeToTarget/3 && currTime > 0) {
			//System.out.println("ramping");
			//v(t) = 3*(mV/TTT) * t from (0,0) to (TTT/3,mV)
			//System.out.println((3 * maxVel/timeToTarget) * currTime);
			return (3 * maxVel/timeToTarget) * currTime;
		} else if(currTime >= timeToTarget/3 && currTime <= (2*timeToTarget/3)){
			//System.out.println("coasting");
			//System.out.println(maxVel);
			return maxVel; //coast
		} else if (currTime >= (2*timeToTarget/3) && currTime < timeToTarget) {
			//System.out.println("rolling down");
			//v(t) = (-3*(mV/TTT)) * t + 3mV from (2TTT/3,mV) to (TTT,0)
			//System.out.println(((-3 * maxVel * currTime)/timeToTarget) + 3*maxVel);
			return ((-3 * maxVel * currTime)/timeToTarget) + 3*maxVel;  
		} else {
			return 0;
		}
	}
}
