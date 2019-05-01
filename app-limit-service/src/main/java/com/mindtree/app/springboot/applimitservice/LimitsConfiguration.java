package com.mindtree.app.springboot.applimitservice;

public class LimitsConfiguration {

	int minimum;
	int maximum;

	public LimitsConfiguration(int i, int j) {
		this.minimum = i;
		this.maximum = j;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

}
