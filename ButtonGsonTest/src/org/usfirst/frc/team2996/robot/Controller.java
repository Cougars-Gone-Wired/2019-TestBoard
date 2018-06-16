package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {

	Joystick controller;
	private boolean button;
	private double axis;
	
	public Controller() {
		controller = new Joystick(0);
	}
	
	public void setControllerInputValues() {
		button = controller.getRawButton(1);
		axis = controller.getRawAxis(1);
	}

	public boolean isButton() {
		return button;
	}

	public double getAxis() {
		return axis;
	}
	
}
