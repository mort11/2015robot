package org.mort11.util;

//What's our vector, Victor?
public class Vector2D {
	// internal representation
	private double angle; // using degrees internally
	private double magnitude;

	// Create vector from x and y
	public Vector2D(double xCoord, double yCoord) {
		magnitude = Math.sqrt((xCoord * xCoord) + (yCoord * yCoord));
		angle = Math.atan(yCoord / xCoord);
	}

	// Create a vector from 2 points, x1 and y1 are subtracted from x2 and y2
	public Vector2D(double x1, double y1, double x2, double y2) {
		double x = x2 - x1;
		double y = y2 - y1;
		new Vector2D(x, y);
	}

	// constructor with angle and magnitude
	public Vector2D(Angle angle, double magnitude) {
		this.angle = angle.inDegrees();
		this.magnitude = magnitude;
	}

	// scalar multiply, add subtract, rotate (in degrees)
	public double getMagnitude() {
		return magnitude;
	}

	public double getX() {
		return Math.cos(angle) * magnitude;

	}

	public double getY() {
		return Math.sin(angle) * magnitude;
	}

	public double getAngle() {
		return angle;
	}

	public Vector2D scalarMultiply(double scalar) {
		Angle angle = new Angle(this.angle);
		Vector2D temp = new Vector2D(angle, this.magnitude * scalar);
		return temp;
	}

	public static Vector2D addVectors(Vector2D v1, Vector2D v2) {
		Vector2D addedVector = new Vector2D((v1.getX() + v2.getX()),
				(v1.getY() + v2.getY()));
		return addedVector;
	}

	public Vector2D subtractVectors(Vector2D v1, Vector2D v2) {
		Vector2D subtractedVector = new Vector2D((v1.getX() - v2.getX()),
				(v1.getY() - v2.getY()));
		return subtractedVector;
	}

	public static Vector2D multiplyVectors(Vector2D v1, Vector2D v2) {
		Vector2D multipliedVector = new Vector2D((v1.getX() * v2.getX()),
				(v1.getY() * v2.getY()));
		return multipliedVector;
	}

	public static Vector2D divideVectors(Vector2D v1, Vector2D v2) {
		Vector2D dividedVector = new Vector2D((v1.getX() / v2.getX()),
				(v1.getY() / v2.getY()));
		return dividedVector;
	}

	public static Vector2D scalarDivide(Vector2D v1, int divisor) {
		Vector2D specialDividedVector = new Vector2D((v1.getX() / divisor),
				(v1.getY() / divisor));
		return specialDividedVector;
	}

	// provide a new vector rotated clockwise from this one
	public Vector2D rotateCW(double addAngle) {
		Angle angle = new Angle(this.angle - addAngle);
		Vector2D rotatedVector = new Vector2D(angle, magnitude);
		return rotatedVector;
	}
}
