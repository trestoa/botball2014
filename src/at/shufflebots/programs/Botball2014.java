package at.shufflebots.programs;

import at.shufflebots.modules.CheckList;
import at.shufflebots.modules.Elevator;
import at.shufflebots.modules.ElevatorArm;
import linkjvm.Botball;
import linkjvm.create.Create;

public class Botball2014 {

	public static void main(String[] args) {
		new CheckList<String>("Connect Create",
				"Connect Light on Port 0",
				"Connect left Servo on Port 0",
				"Connect right Servo on Port 2",
				"Connect top Motor on Port 0",
				"Connect bottom Motor on Port 1,",
				"Connect top sensor on Port 8",
				"Connect bottom sensor on Port 9").performChecks();
		Create create = new Create();
		create.connect();
		//Botball.waitForLight(0);
		ElevatorArm arm = new ElevatorArm(0, 2, 0, 1);
		Elevator elev = new Elevator(0, 1, 8, 9);
		create.turn(-85, 50);
		create.driveDirect(-50, -50);
		Botball.msleep(3000);
		create.driveDirect(200, 200);
		while(create.getLeftFrontCliff() > 500){
			Botball.msleep(20);
		}
		create.driveDirect(-100, -100);
		Botball.msleep(300);
		create.turn(85, 50);
		create.driveDirect(-100, -100);
		Botball.msleep(5000);
		create.driveDirect(200, 200);
		Botball.msleep(5590);
		create.turn(-82, 50);
		create.driveDirect(-130, -130);
		Botball.msleep(5000);
		create.stop();
		arm.up();
		elev.up();
		create.driveDirect(100, 100);
		while(create.getRightFrontCliff() > 500 && create.getRightCliff() > 500) Botball.msleep(20);
		Botball.msleep(1000);
		while(create.getRightFrontCliff() > 500) Botball.msleep(20);
		create.stop();
	}
}
