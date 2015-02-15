package org.mort11.util;

public class LineSegment {
	private double initialX;
	private double initialY;
	private double endX;
	private double endY;
	private double angle;
	
	public LineSegment (double initialX, double initialY, double endX, double 
			endY, double angle)
	{
		this.initialX = initialX;
		this.initialY = initialY;
		this.endX = endX;
		this.endY = endY;
		this.angle = angle;
	}
	

	public double getInitialX() {
		return initialX;
	}


	public void setInitialX(double initialX) {
		this.initialX = initialX;
	}


	public double getInitialY() {
		return initialY;
	}


	public void setInitialY(double initialY) {
		this.initialY = initialY;
	}


	public double getEndX() {
		return endX;
	}


	public void setEndX(double endX) {
		this.endX = endX;
	}


	public double getEndY() {
		return endY;
	}


	public void setEndY(double endY) {
		this.endY = endY;
	}

	public double getAngle() {
		return angle;
	}


	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public void findIntersect(LineSegment seg1, LineSegment seg2) {
	    double angle1, angle2, slope1, slope2, dummyValue = 0;
		
	    LineSegment temp1 = new LineSegment(0, 0, (seg1.getEndX() - 
		  seg1.getInitialX()), (seg1.getEndY() - seg1.getInitialY()), 
		    dummyValue);
		
	    LineSegment temp2 = new LineSegment( (seg2.getInitialX() - 
	      seg1.getInitialX()), (seg2.getInitialY() - seg1.getInitialY()), 
	        (seg2.getEndX() - seg1.getInitialX()), (seg2.getEndY() - 
	          seg1.getInitialY()), dummyValue);
	
	    slope1 = (temp1.getEndY() - temp1.getInitialY()) / (temp1.getEndX() - 
	      temp1.getInitialX());
	    slope2 = (temp2.getEndY() - temp2.getInitialY()) / (temp2.getEndX() - 
	  	      temp2.getInitialX());
	    angle1 = Math.atan(slope1);
	    angle2 = Math.atan(slope2);
	    
	    temp1.setAngle(angle1 - angle1);
	    temp2.setAngle(angle2 - angle1);
	    
	    if (temp2.) //unfinished
	}

}
