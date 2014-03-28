package at.shufflebots.modules;

import linkjvm.Botball;
import linkjvm.motors.Servo;

public class VArms {
	private Servo rightServo, leftServo;
	
	public VArms(){
		rightServo = new Servo(2);
		leftServo = new Servo(0);
	}
	
	public void close(){
		rightServo.setPosition(2047);
		rightServo.enable();
		
		leftServo.setPosition(350);
		leftServo.enable();
		Botball.msleep(1500);
		
		rightServo.disable();
		leftServo.disable();
	}
	
	public void open(){
		rightServo.setPosition(600);
		rightServo.enable();
		
		leftServo.setPosition(1800);
		leftServo.enable();
		Botball.msleep(1500);
		
		leftServo.disable();
		rightServo.disable();
	}
}
