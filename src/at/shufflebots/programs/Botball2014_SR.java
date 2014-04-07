package at.shufflebots.programs;

import linkjvm.Botball;
import linkjvm.create.Create;
import at.shufflebots.modules.CheckList;
import at.shufflebots.modules.Elevator;
import at.shufflebots.modules.ElevatorArm;
import at.shufflebots.modules.ShufflerArm;

public class Botball2014_SR {

	public static void main(String[] args) {

		// Checklists:

		new CheckList<String>("Connect Create", "Connect Light on Port 0",
				"Connect left Servo on Port 0",
				"Connect right Servo on Port 2", "Connect top Motor on Port 0",
				"Connect bottom Motor on Port 1,",
				"Connect top sensor on Port 8",
				"Connect bottom sensor on Port 9",
				"Connect shuffler Motor on Port 3").performChecks();

		// Definitions:
		Create create = new Create();
		ElevatorArm arm = new ElevatorArm(0, 2, 0, 1);
		Elevator elev = new Elevator(0, 1, 8, 9);
		ShufflerArm shuffler = new ShufflerArm(3);

		// Create Connetion + Gamestarts:
		create.connect();
		// Botball.waitForLight(0);
		//Botball.shutDownIn(120);

		// Position 1:Turning + adjusting Direction
		create.turn(-85, 150);
		create.driveDirect(-200, -200);
		Botball.msleep(800);
		create.stop();

		// Driving Forward: Until the black tape
		create.driveDirect(300, 300);
		while (create.getLeftFrontCliff() > 500) {
			Botball.msleep(20);
		}
		create.driveDirect(-100, -100);
		Botball.msleep(300);

		// Position 2: Turing + adjust Direction + Drive straightly to the
		// center
		create.turn(85, 100);
		create.driveDirect(-200, -200);
		Botball.msleep(2000);
		create.driveDirect(300, 300);
		Botball.msleep(3650);

		// Position3: Turning + adjust Direction
		create.turn(-82, 100);
		create.driveDirect(-200, -200);
		Botball.msleep(2000);
		create.driveDirect(-100, -100);
		Botball.msleep(1500);
		create.stop();
		arm.up();
		shuffler.toRight();
		elev.up();

		// Driving Forward: Until the black tape*2 :
		create.driveDirect(100, 95);
		shuffler.toLeft();
		shuffler.littleRight();
		while (create.getRightFrontCliff() > 500
				&& create.getRightCliff() > 500)
			Botball.msleep(20);
		Botball.msleep(1000);
		while (create.getRightFrontCliff() > 500)
			Botball.msleep(20);
		Botball.msleep(300);
		create.stop();

		// Shuffler Hand moves:
		elev.shortdown(1100);
		shuffler.toRight();

		/* 75 points!!!!!!!!!!!!!!!! *//* 75 points!!!!!!!!!!!!!!!! */

		// Comes Back to the black line
		create.driveDirect(-100, -100);
		Botball.msleep(1000);
		while (create.getRightCliff() > 500) {
			Botball.msleep(20);
		}
		Botball.msleep(500);
		create.stop();
		elev.down();
		// //////////////////////////////////////////////////////////////////////////////////////
		// Go to the Front again:
		create.driveDirect(70, 70);
		shuffler.toMiddle();
		shuffler.littleLeft();
		Botball.msleep(500);
		while (create.getRightFrontCliff() > 500)
			Botball.msleep(20);
		Botball.msleep(350);
		create.stop();

		// Get the second hanger:
		elev.shortdown(500);
		shuffler.toRight();
		elev.shortup(1300);

		// Comes Back to the black line:
		create.driveDirect(-100, -100);
		shuffler.toRight();
		while (create.getRightCliff() > 500)
			Botball.msleep(20);
		Botball.msleep(500);
		create.stop();
		elev.up();

		// Go to Front again:
		create.driveDirect(70, 70);
		Botball.msleep(1000);
		elev.shortup(500);
		while (create.getRightFrontCliff() > 500)
			Botball.msleep(20);
		Botball.msleep(325);
		create.stop();

		// Drop the second hanger
		elev.shortdown(1100);
		shuffler.toMiddle();
		shuffler.littleLeft();
		
		/* 150 points!!!!!!!!!!!!!!!! *//* 150 points!!!!!!!!!!!!!!!! */
		
//		elev.up();
//		shuffler.toLeft();
//		shuffler.toRight();
//		shuffler.toMiddle();
		
		//Go back to black line:
		create.driveDirect(-100, -100);
		while (create.getRightCliff() > 500)
			Botball.msleep(20);
		create.stop();
		elev.down();

		// Go to Front again:
		create.driveDirect(100, 95);
		while (create.getRightFrontCliff() > 500)
			Botball.msleep(20);
		Botball.msleep(350);
		create.stop();

		// Get thrid hanger:
		shuffler.toLeft();
		elev.shortup(1300);
		
		//Drive in:
		create.driveDirect(70, 70);
		Botball.msleep(500);
		create.stop();
		elev.down();
		
		//Go back to black line
		create.driveDirect(-100, -100);
		while (create.getRightCliff() > 500)
			Botball.msleep(20);
		create.stop();
		
		elev.up();
		elev.shortdown(1500);
		shuffler.toMiddle();
		
		//Goto Front again:
		create.driveDirect(100, 95);
		while (create.getRightFrontCliff() > 500)
			Botball.msleep(20);
		Botball.msleep(600);
		create.stop();
		
		elev.up();
		
		create.driveDirect(-70, -70);
		Botball.msleep(400);
		create.stop();
		
		elev.shortdown(1100);

		/*
		 * create.driveDirect(-100,-100); Botball.msleep(1500); create.turn(3,
		 * 50); create.driveDirect(-200,-200); Botball.msleep(5000);
		 * create.stop(); elev.down(); arm.disable();
		 * System.out.println("finish");
		 */
	}
}
