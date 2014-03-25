package at.shufflebots.modules;

import linkjvm.Botball;
import linkjvm.low.Servo;

public class VArms {
	private Servo rightServo, leftServo;
	
	public VArms(){
		rightServo = new Servo(0);
		leftServo = new Servo(1);
	}
	
	public void close(){
		rightServo.enable();
		rightServo.setPosition(350);
		Botball.msleep(500);
		rightServo.disable();
		
		leftServo.enable();
		leftServo.setPosition(350);
		Botball.msleep(500);
		leftServo.disable();
	}
	
	public void open(){
		rightServo.enable();
		rightServo.setPosition(2048);
		Botball.msleep(500);
		rightServo.disable();
		
		leftServo.enable();
		leftServo.setPosition(2048);
		Botball.msleep(500);
		leftServo.disable();
	}
}
