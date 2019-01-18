package com.battery.common.utils;

public class DataPoint {
	/** the x value */
	public double x;

	/** the y value */
	public double y;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            the x value
	 * @param y
	 *            the y value
	 */
	public DataPoint(double x, double y) {
		this.x = x;
		this.y = y;
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
}
