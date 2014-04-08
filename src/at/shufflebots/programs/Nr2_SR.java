package at.shufflebots.programs;

import static linkjvm.Botball.*;
import linkjvm.Botball;
import linkjvm.motors.Motor;
import linkjvm.motors.Servo;
import linkjvm.sensors.analog.AnalogSensor;
import linkjvm.sensors.buttons.SideButton;
import at.shufflebots.modules.CheckList;

public class Nr2_SR {
	
	static int thresholdBottom = 700; //higher when black
	static int thresholdFront = 500; //lower when in front of the cube
	
	static int motorspeedLeft = 100;
	static int motorspeedRight = 100;
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				SideButton b = new SideButton();
				while(!b.isPressed())Botball.msleep(20);
				System.exit(0);
			}
		}).start();
		
		new CheckList<String>("Greifarm fixieren").performChecks();
		
		final Motor left = new Motor(3);
		final Motor right = new Motor(2);
		
		AnalogSensor bottom = new AnalogSensor(0);
		AnalogSensor front = new AnalogSensor(1);
		
		final Servo grabbler = new Servo(0);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		// GAME START // GAME START // GAME START // GAME START // GAME START // GAME START // GAME START // 
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		waitForLight(2);
		shutDownIn(117);
		
		grabbler.setPosition(0);
		grabbler.enable();
		
		left.run(motorspeedLeft);
		right.run(motorspeedRight);
	
		//Drive to black line
		
		while(bottom.getValue10() < thresholdBottom) msleep(10);
		
		//Turn left
		
		left.run(-1 * motorspeedLeft);
		msleep(800);
		
		left.run(motorspeedLeft);
		
		//Drive to cube
		
		while(front.getValue10() > thresholdFront) msleep(10);
		
		//grab cube
		
		grabbler.setPosition(1200);
		
		msleep(2000);
		
		//turn left

		left.freeze();
		msleep(700);

		//Drive to the end
		
		right.run(motorspeedRight);
		left.run(motorspeedLeft);
		
		msleep(5000);
		
		left.freeze();
		right.freeze();
		grabbler.disable();
	}	
}
