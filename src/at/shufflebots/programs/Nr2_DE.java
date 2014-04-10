package at.shufflebots.programs;

import static linkjvm.Botball.*;
import linkjvm.Botball;
import linkjvm.motors.Motor;
import linkjvm.motors.Servo;
import linkjvm.sensors.analog.AnalogSensor;
import linkjvm.sensors.buttons.SideButton;
import at.shufflebots.modules.CheckList;

public class Nr2_DE {
	
	static int thresholdBottom = 700; //higher when black
	static int thresholdFront = 800; //lower when in front of the cube
	
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
		
		waitForLight(0);
		shutDownIn(117);

		final Motor left = new Motor(3);
		final Motor right = new Motor(2);
		
		AnalogSensor bottom = new AnalogSensor(1);
//		AnalogSensor front = new AnalogSensor(1);
		
		final Servo grabbler = new Servo(0);
		
		//
		
		grabbler.setPosition(0);
		grabbler.enable();
		
		left.run(90);
		right.run(100);
	
		//Drive to black line
		
		while(bottom.getValue10() < thresholdBottom) msleep(10);
		
		//Turn left
		
		left.run(-100);
		msleep(700);
		
		left.run(90);
		
		//Drive to cube
				
		msleep(4000);
		//left.run(-90);
		//right.run(-100);
		
		grabbler.setPosition(900);
		
		right.run(-100);
		left.run(90);
		msleep(900);
		
		
		right.run(100);
		
		/*right.run(100);
		left.run(90);
		msleep(3000);*/
		
		msleep(5000);
		
		left.off();
		right.off();
		System.exit(0);
		
		
		msleep(2000);
		
		//turn left

		left.freeze();
		msleep(800);

		//Drive to the end
		
		right.run(100);
		left.run(100);
		
		msleep(5000);
		
		left.freeze();
		right.freeze();
		grabbler.disable();
	}	
}
