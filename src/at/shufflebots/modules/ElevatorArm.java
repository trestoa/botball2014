package at.shufflebots.modules;

import linkjvm.motors.Servo;

public class ElevatorArm {

	private Servo left;
	private Servo right;
	
	public ElevatorArm(int left_servo_port, int right_servo_port) {
		left = new Servo(left_servo_port);
		right = new Servo(right_servo_port);
	}
	
	public void up() {
		left.enable();
		right.enable();
		left.setPosition(1500);
		right.setPosition(500);
	}
	
	public void down() {
		left.enable();
		right.enable();
		left.setPosition(600);
		right.setPosition(1400);
	}
	
	public void disable() {
		left.disable();
		right.disable();
	}
}
