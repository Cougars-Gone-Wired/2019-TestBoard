package org.usfirst.frc.team2996.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Talons {

	WPI_TalonSRX talon1;
	WPI_TalonSRX talon2;
	
	public Talons() {
		talon1 = new WPI_TalonSRX(0);
		talon2 = new WPI_TalonSRX(1);
	}
	
	public void buttonTalon(boolean button) {
		if (button) {
			talon1.set(1);
		} else {
			talon1.set(0);
		}
	}
	
	public void axisTalon(double axis) {
		if (axis > 0.15 || axis < 0.15) {
			talon2.set(axis);
		} else {
			talon2.set(0);
		}
	}
}
