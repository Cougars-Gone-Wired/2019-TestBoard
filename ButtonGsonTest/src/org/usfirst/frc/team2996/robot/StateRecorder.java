package org.usfirst.frc.team2996.robot;

import java.util.ArrayList;
import java.util.List;

public class StateRecorder {

	List<State> states;

	public void initialize() {
		states = new ArrayList<>();
	}
	
	public void record(Controller controller) {
		State s = new State();
		
		s.setButton1State(controller.isButton1());
		s.setButton1State(controller.isButton2());
		s.setAxisState(controller.getAxis());
		
		states.add(s);
	}

	public List<State> getStates() {
		return states;
	}
}
