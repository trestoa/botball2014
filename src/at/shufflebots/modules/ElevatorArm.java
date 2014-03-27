package at.shufflebots.modules;

import linkjvm.Botball;
import linkjvm.motors.Motor;
import linkjvm.motors.Servo;

public class ElevatorArm {

	private Servo left;
	private Servo right;
	private Motor top;
	private Motor bottom;
	
	public ElevatorArm(int left_servo_port, int right_servo_port, int top_servo_port, int bottom_servo_port) {
		left = new Servo(left_servo_port);
		right = new Servo(right_servo_port);
		top = new Motor(top_servo_port);
		bottom = new Motor(bottom_servo_port);
		left.setPosition(700);
		right.setPosition(1200);
	}
	
	public void up() {
		top.run(-100);
		bottom.run(-100);
		left.enable();
		right.enable();
		left.setPosition(1600);
		right.setPosition(300);
		Botball.msleep(4000);
		top.off();
		bottom.off();
	}
	
	public void down() {
		left.enable();
		right.enable();
		left.setPosition(700);
		right.setPosition(1200);
		Botball.msleep(3000);
	}
	
	public void disable() {
		left.disable();
		right.disable();
	}
}
