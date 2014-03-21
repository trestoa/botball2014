package at.shufflebots.modules;

import linkjvm.Botball;
import linkjvm.motors.Motor;

public class ShufflerArm {

	/**
	 * Postion of the arm
	 *  1 left
	 * 	0 middle
	 * -1 right
	 */
	private int POSITON = 0;
	
	private Motor motor;
	
	public ShufflerArm(int motor_port) {
		motor = new Motor(motor_port);
		this.to_Right();
		this.to_Middle();
	}
	
	public void to_Right() {
		motor.run(50);
		Botball.msleep(2600);
		motor.off();
		POSITON = -1;
	}
	
	public void to_Middle() {
		motor.run(POSITON * 50);
		Botball.msleep(1300);
		motor.off();
		POSITON = 0;
	}
	
	public void to_Left() {
		motor.run(-50);
		Botball.msleep(2600);
		motor.off();
		POSITON = 1;
	}
}
