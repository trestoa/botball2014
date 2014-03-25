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
		this.toRight();
		this.toMiddle();
	}
	
	public void toLeft() {
		motor.run(50);
		Botball.msleep(2400);
		motor.off();
		POSITON = -1;
	}
	
	public void toMiddle() {
		motor.run(POSITON * 50);
		Botball.msleep(1100);
		motor.off();
		POSITON = 0;
	}
	
	public void toRight() {
		motor.run(-50);
		Botball.msleep(2400);
		motor.off();
		POSITON = 1;
	}
	
	public void stopAll(){
		motor.off();
	}
}
