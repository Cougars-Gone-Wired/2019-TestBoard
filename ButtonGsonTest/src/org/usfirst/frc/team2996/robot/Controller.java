package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {

	Joystick controller;
	private boolean button1;
	private boolean button2;
	private double axis;
	
	public Controller() {
		controller = new Joystick(0);
	}
	
	public void setControllerInputValues() {
		button1 = controller.getRawButton(1);
		button2 = controller.getRawButton(2);
		axis = controller.getRawAxis(1);
	}

	public boolean isButton1() {
		return button1;
	}
	
	public boolean isButton2() {
		return button2;
	}

	public double getAxis() {
		return axis;
	}
	
}
