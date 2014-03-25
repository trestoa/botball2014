package at.shufflebots.programs;

import linkjvm.Botball;
import linkjvm.create.Create;
import at.shufflebots.modules.CheckList;
import at.shufflebots.modules.Elevator;
import at.shufflebots.modules.ElevatorArm;
import at.shufflebots.modules.ShufflerArm;

public class ShufflerMain {

	public static void main(String[] args) {
		
		new CheckList<>("Create up",
						"Shuffler-Arm| 3", 
						"Elev-Motor  | top: 1, bottom: 0", 
						"Elev-Sensor | top: 8, bottom: 9", 
						"Elev-Arm    | left: 1, right: 3",
						"V-Arm       | left: 0, right: 2").performChecks();
		
		//Expect shuffler is standing in the right position in front of the hanger rack
		
		final ShufflerArm arm = new ShufflerArm(3);
		//motor 3
		final Elevator elevator = new Elevator(1, 0, 8, 9);  
		//motor oben 1, motor unten 0, sensor oben 8, sensor unten 9 
		final Create create = new Create();
		final ElevatorArm elevatorArm = new ElevatorArm(1, 3); 
		//servo links 0, servo rechts 1
		elevatorArm.enable();
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				elevatorArm.stopAll();
				elevator.stopAll();
				create.stop();
				arm.stopAll();
			}
		}));
		
		create.connect();
		
		System.out.println("down");
		elevator.down();
		
		System.out.println("left");
		arm.toLeft();
		System.out.println("shortup");
		elevator.shortup();
		System.out.println("back");
		create.driveDirect(100, 100);
		Botball.msleep(2000);
		create.stop();
		
		System.out.println("elevator up");
		elevator.up();
		System.out.println("move forward");
		create.driveDirect(-100, -100);
		Botball.msleep(2100);
		create.stop();

		System.out.println("shortdown");
		elevator.shortdown();
		System.out.println("right");
		arm.toRight();
		
		System.out.println("back");
		create.driveDirect(100, 100);
		Botball.msleep(2000);
		create.stop();
		
		System.out.println("down");
		elevator.down();
		System.out.println("middle");
		arm.toMiddle();

		create.disconnect();
	}
}
