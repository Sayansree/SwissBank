package com.swisbank.bannkapp.entity;

import java.util.List;

public class AccFilter {
	private List<String> states;
	private double minBal;
	private double maxBal;
	public List<String> getStates() {
		return states;
	}
	public void setStates(List<String> states) {
		this.states = states;
	}
	public double getMinBal() {
		return minBal;
	}
	public void setMinBal(double minBal) {
		this.minBal = minBal;
	}
	public double getMaxBal() {
		return maxBal;
	}
	public void setMaxBal(double maxBal) {
		this.maxBal = maxBal;
	}
	public AccFilter(List<String> states, double minBal, double maxBal) {
		super();
		this.states = states;
		this.minBal = minBal;
		this.maxBal = maxBal;
	}
	public AccFilter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
