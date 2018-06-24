package org.usfirst.frc.team2996.robot;

public class State {

	private boolean button1State;
	private boolean button2State;
	private double axisState;
	
	public boolean isButton1State() {
		return button1State;
	}
	public void setButton1State(boolean button1State) {
		this.button1State = button1State;
	}
	public boolean isButton2State() {
		return button2State;
	}
	public void setButton2State(boolean button2State) {
		this.button2State = button2State;
	}
	public double getAxisState() {
		return axisState;
	}
	public void setAxisState(double axisState) {
		this.axisState = axisState;
	}
	
}
