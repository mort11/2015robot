package org.mort11.util;

public class Angle {
	//internal representation
	private double localAngleInDegrees;
	
	public Angle(double degrees){
		localAngleInDegrees = degrees;
	}
	
	public void setAngleRadians(double radians){
		localAngleInDegrees = radians*(180/(Math.PI));
	}
	public void setAngleDegrees(double degrees){
		localAngleInDegrees = degrees;
	}
	
	public double inRadians(){
		return localAngleInDegrees * (Math.PI)/180;
	}
	
	public double inDegrees(){
		return localAngleInDegrees;
	}
}