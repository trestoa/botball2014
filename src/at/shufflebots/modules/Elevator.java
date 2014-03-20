package at.shufflebots.modules;

import linkjvm.motors.Motor;

public class Elevator {

	private Motor top;
	private Motor bottom;
	
	public Elevator(int top_motor_port, int bottom_motor_port) {
		top = new Motor(top_motor_port);
		bottom = new Motor(bottom_motor_port);
	}
	
	public void up() {
		top.run(-100);
		bottom.run(7);
	}
	
	public void stop() {
		top.off();
		bottom.off();
	}
	
	public void down() {
		top.run(7);
		bottom.run(-100);
	}
}
