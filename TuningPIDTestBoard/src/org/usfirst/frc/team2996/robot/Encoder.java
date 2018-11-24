package org.usfirst.frc.team2996.robot;

import com.ctre.phoenix.motorcontrol.SensorCollection;

public class Encoder {

	private SensorCollection sensors;
	
	static double WHEEL_RADIUS = 3;
	static double CIRCUMFRENCE = 2 * Math.PI * WHEEL_RADIUS;
	static double PULSES_PER_REVOLUTION = 1440;
	static double distancePerPulse = CIRCUMFRENCE / PULSES_PER_REVOLUTION;
	
	public Encoder(Robot robot) {
		sensors = robot.getSensors();
	}
	
	public int getCount() {
		return -sensors.getQuadraturePosition();
	}
	
	public double getDistanceInches() {
		return -sensors.getQuadraturePosition() * distancePerPulse;
	}
	
	public double getDistanceFeet() {
		return -(sensors.getQuadraturePosition() * distancePerPulse) / 12;
	}
	
	public void reset() {
		sensors.setQuadraturePosition(0, 10);
	}
}
