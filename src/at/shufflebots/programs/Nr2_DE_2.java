package at.shufflebots.programs;

import at.shufflebots.modules.CheckList;
import linkjvm.Botball;
import linkjvm.motors.Motor;
import linkjvm.motors.Servo;
import linkjvm.sensors.analog.AnalogSensor;
import linkjvm.sensors.buttons.SideButton;

public class Nr2_DE_2 {
	
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
		
		Botball.waitForLight(0);
		Botball.shutDownIn(117);
		
		final Motor left = new Motor(3);
		final Motor right = new Motor(2);
		
		AnalogSensor bottom = new AnalogSensor(1);
//		AnalogSensor front = new AnalogSensor(1);
		
		final Servo grabbler = new Servo(0);
		
		//
		
		grabbler.setPosition(1100);
		grabbler.enable();
		
		left.run(90);
		right.run(100);
	
		//Drive to black line
		
		while(bottom.getValue10() < thresholdBottom) Botball.msleep(10);
		
		//Turn left
		
		left.run(-100);
		Botball.msleep(500);
		
		left.run(90);
		
		//Drive to cube
				
		Botball.msleep(1500);
		//left.run(-90);
		//right.run(-100);
		
		
		//turn right
		right.run(-100);
		left.run(90);
		Botball.msleep(500);
		
		
		right.run(100);
		
		/*right.run(100);
		left.run(90);
		msleep(3000);*/
		
		grabbler.setPosition(0);
		
		Botball.msleep(1000);
		
		left.off();
		right.off();
		
		Botball.msleep(200);
		
		grabbler.setPosition(1100);
		
		Botball.msleep(200);
		
		left.run(-90);
		right.run(-100);
		
		Botball.msleep(1000);
		
		right.run(100);
		
		Botball.msleep(500);
		
		left.run(90);
		
		Botball.msleep(4000);
		
		left.run(-90);
		
		Botball.msleep(500);
		
		left.run(90);
		
		Botball.msleep(2000);
		
		left.off();
		right.off();
		System.exit(0);
	}
}
