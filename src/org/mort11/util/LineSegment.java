package org.mort11.util;

public class LineSegment {
	private double initialX;
	private double initialY;
	private double endX;
	private double endY;
	
	public LineSegment (double initialX, double initialY, double endX, double 
			endY)
	{
		this.initialX = initialX;
		this.initialY = initialY;
		this.endX = endX;
		this.endY = endY;	
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


	public void findIntersect(LineSegment seg1, LineSegment seg2){
	    LineSegment temp1 = new LineSegment(0, 0, (seg1.getEndX() - 
		  seg1.getInitialX()), (seg1.getEndY() - seg1.getInitialY()));
		
	    LineSegment temp2 = new LineSegment( (seg2.getInitialX() - 
	      seg1.getInitialX()), (seg2.getInitialY() - seg1.getInitialY()), 
	      (seg2.getEndX() - seg1.getInitialX()), (seg2.getEndY() - 
	      seg1.getInitialY()));
	
	
	
	}
}
