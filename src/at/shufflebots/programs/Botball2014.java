package at.shufflebots.programs;

import at.shufflebots.modules.CheckList;
import at.shufflebots.modules.Elevator;
import at.shufflebots.modules.ElevatorArm;
import at.shufflebots.modules.ShufflerArm;
import linkjvm.Botball;
import linkjvm.create.Create;

public class Botball2014 {

	public static void main(String[] args) {
		
		//Checklists:
		new CheckList<String>("Connect Create",
				"Connect Light on Port 0",
				"Connect left Servo on Port 0",
				"Connect right Servo on Port 2",
				"Connect top Motor on Port 0",
				"Connect bottom Motor on Port 1,",
				"Connect top sensor on Port 8",
				"Connect bottom sensor on Port 9",
				"Connect shuffler Motor on Port 3").performChecks();
		
		//Definitions:
		Create create = new Create();
		ElevatorArm arm = new ElevatorArm(0, 2, 0, 1);
		Elevator elev = new Elevator(0, 1, 8, 9);
		ShufflerArm shuffler = new ShufflerArm(3);
		
		//Create Connetion + Gamestarts:
		create.connect();
			//Botball.waitForLight(0);
		
		//shuffler hand adjusting:
		shuffler.toLeft();
		
		//Position 1:Turning + adjusting Direction
		create.turn(-85, 50);
		create.driveDirect(-50, -50);
		Botball.msleep(3000);
		
		//Driving Forward: Until the black tape
		create.driveDirect(200, 200);
		while(create.getLeftFrontCliff() > 500){
			Botball.msleep(20);
		}
		create.driveDirect(-100, -100);
		Botball.msleep(300);
		
		//Position 2: Turing + adjust Direction + Drive straightly to the center
		create.turn(85, 50);
		create.driveDirect(-100, -100);
		Botball.msleep(5000);
		create.driveDirect(200, 200);
		Botball.msleep(5590);
		
		//Position3: Turning + adjust Direction
		create.turn(-85, 50);
		create.driveDirect(-130, -130);
		Botball.msleep(5000);
		create.stop();
		
		//Robot Arm up + elevator up
		arm.up();
		elev.up();
		
		//Driving Forward: Until the black tape*2 :
		create.driveDirect(100, 100);
		while(create.getRightFrontCliff() > 500 && create.getRightCliff() > 500) Botball.msleep(20);
		Botball.msleep(1000);
		while(create.getRightFrontCliff() > 500) Botball.msleep(20);
		Botball.msleep(700);
		create.stop();
		
		//Shuffler Hand moves:
		Botball.msleep(500);
		elev.shortdown();
		Botball.msleep(500);
		shuffler.toRight();
		
		
	}
}
