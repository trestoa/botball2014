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
		this.toLeft();
	}
	
	public void toLeft() {
		motor.run(-75);
		Botball.msleep(2000);
		motor.run(10);
		Botball.msleep(500);
		motor.off();
		POSITON = 1;
	}
	
	public void toMiddle() {
		motor.run(POSITON * 75);
		Botball.msleep(1100);
		motor.run(0);
		motor.off();
		POSITON = 0;
	}
	
	public void toRight() {
		motor.run(75);
		Botball.msleep(2000);
		motor.run(-10);
		Botball.msleep(500);
		motor.off();
		POSITON = -1;
	}
	
	public void littleLeft(){
		motor.run(-75);
		Botball.msleep(400);
		motor.off();
		POSITON += 1;
	}
	
	public void littleRight(){
		motor.run(75);
		Botball.msleep(800);
		motor.off();
		POSITON -= 1;
	}
	
	
	public void stopAll(){
		motor.off();
	}
}
