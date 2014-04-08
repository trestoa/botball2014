package at.shufflebots.programs;

import linkjvm.motors.Motor;
import linkjvm.motors.Servo;
import linkjvm.sensors.analog.AnalogSensor;
import linkjvm.sensors.buttons.AButton;
import static linkjvm.Botball.*;

public class Nr2_SR {
	
	static int thresholdBottom = 700; //higher when black
	static int thresholdFront = 500; //lower when in front of the cube
	
	static int motorspeedLeft = 80;
	static int motorspeedRight = 85;
	
	public static void main(String[] args) {

		final Motor left = new Motor(3);
		final Motor right = new Motor(2);
		
		AnalogSensor bottom = new AnalogSensor(0);
		AnalogSensor front = new AnalogSensor(1);
		
		final Servo grabbler = new Servo(0);
		
		final AButton button = new AButton();
		button.setText("Stop");
	
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				while(true) {
					if(button.isPressed()) {
						System.out.println("stop");
						left.off();
						right.off();
						grabbler.disable();
						System.exit(0);
					}
				}
			}
		}).start();
		
		//
		
		grabbler.setPosition(0);
		grabbler.enable();
		
		left.run(motorspeedLeft);
		right.run(motorspeedRight);
	
		//Drive to black line
		
		while(bottom.getValue10() < thresholdBottom) msleep(10);
		
//		left.run(-1 * motorspeedLeft);
//		right.run(-1 * motorspeedRight);
//		
//		msleep(100);
		
		//Turn left
		
		msleep(100);
		left.run(-2/3 * motorspeedLeft );
		msleep(2000);
		
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
