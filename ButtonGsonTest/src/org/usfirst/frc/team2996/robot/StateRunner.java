package org.usfirst.frc.team2996.robot;

import java.util.List;

public class StateRunner {

	private Talons talons;
	
	List<State> states;
	
	int counter = 0;

	public StateRunner(Robot robot) {
		this.talons = robot.getTalons();
	}

	public void counterInitialize() {
		counter = 0;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public void run() {
		if (counter < states.size()) {
			State s = states.get(counter);
			
			talons.buttonTalon(s.isButton1State(), s.isButton2State());
			talons.axisTalon(s.getAxisState());
			
			counter++;
		}
	}
}
