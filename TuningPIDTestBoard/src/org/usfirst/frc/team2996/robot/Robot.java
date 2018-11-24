/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2996.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

	double P = 0;
	double I = 0;
	double D = 0;
	
	double desiredFeet = 0;
	double desiredInches = 0;
	double desiredPulses = 0;
	
	boolean zeroEncoder = false;
	boolean enable = false;
	
	double motorSpeed = 0;
	boolean zeroSpeed = false;
	
	private WPI_TalonSRX masterMotor;
	private WPI_TalonSRX slaveMotor;
	
	private SensorCollection sensors;
	private Encoder encoder;
	
	@Override
	public void robotInit() {
		masterMotor = new WPI_TalonSRX(0);
		slaveMotor = new WPI_TalonSRX(1);
		
		masterMotor.setSensorPhase(true);
		masterMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		masterMotor.configClosedLoopPeakOutput(0, .75, 10);
		
		slaveMotor.follow(masterMotor);
		
		sensors = new SensorCollection(masterMotor);
		encoder = new Encoder(this);
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopInit() {
		SmartDashboard.putNumber("P", P);
		SmartDashboard.putNumber("I", I);
		SmartDashboard.putNumber("D", D);
		
		SmartDashboard.putNumber("desired feet", desiredFeet);
		
		SmartDashboard.putBoolean("Zero Encoder", zeroEncoder);
		SmartDashboard.putBoolean("Enable", false);
		
		SmartDashboard.putNumber("Motors", motorSpeed);
		SmartDashboard.putBoolean("Zero Speed", zeroSpeed);
	}
	
	@Override
	public void teleopPeriodic() {
		desiredFeet = SmartDashboard.getNumber("desired feet", 0);
		desiredInches = desiredFeet * 12;
		desiredPulses = (desiredFeet * 12) / Encoder.distancePerPulse;
		
		SmartDashboard.putNumber("desired inches", desiredInches);
		SmartDashboard.putNumber("desired pulses", desiredPulses);
		
		SmartDashboard.putNumber("encoder feet", encoder.getDistanceFeet());
		SmartDashboard.putNumber("encoder inches", encoder.getDistanceInches());
		SmartDashboard.putNumber("encoder pulses", encoder.getCount());
		
		P = SmartDashboard.getNumber("P", 0);
		I = SmartDashboard.getNumber("I", 0);
		D = SmartDashboard.getNumber("D", 0);
		
		zeroEncoder = SmartDashboard.getBoolean("Zero Encoder", false);
		enable = SmartDashboard.getBoolean("Enable", false);
		
		motorSpeed = SmartDashboard.getNumber("Motors", 0);
		zeroSpeed = SmartDashboard.getBoolean("Zero Speed", false);
		
		if (zeroEncoder) {
			sensors.setQuadraturePosition(0, 10);
		}
		
		if (zeroSpeed) {
			motorSpeed = 0;
			SmartDashboard.putNumber("Motors", motorSpeed);
		}
		
		if (enable) {
			masterMotor.config_kP(0, P, 10);
			masterMotor.config_kI(0, I, 10);
			masterMotor.config_kD(0, D, 10);
			masterMotor.set(ControlMode.Position, desiredPulses);
		} else {
			masterMotor.set(motorSpeed);
		}
	}

	@Override 
	public void disabledInit() {
		encoder.reset();
	}
	
	@Override
	public void disabledPeriodic() {
	}
	
	@Override
	public void testInit() {
	}
	
	@Override
	public void testPeriodic() {
	}
	
	public SensorCollection getSensors() {
		return sensors;
	}
}
