package edu.stem.indoor4j;

public class Point {
	private double x;
	private double y;
	private double z;
	
	public Point(double x, double y, double z) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point(double x, double y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.z = 0.0;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public double getDistance(Point point) {
		return Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
	}
	
	@Override
	public String toString() {
		return "[" + x + ", " + y + ", " + z + "]";
	}
}
