package org.usfirst.frc.team2996.robot;

public class State {

	private boolean buttonState;
	private double axisState;
	
	public boolean isButtonState() {
		return buttonState;
	}
	public void setButtonState(boolean buttonState) {
		this.buttonState = buttonState;
	}
	public double getAxisState() {
		return axisState;
	}
	public void setAxisState(double axisState) {
		this.axisState = axisState;
	}
	
}
