package at.shufflebots.programs;

import linkjvm.create.Create;
import at.shufflebots.modules.Elevator;
import at.shufflebots.modules.ShufflerArm;

public class ShufflerMain {

	public static void main(String[] args) {

		//Expect shuffler is standing in the right position in front of the hanger rack

		ShufflerArm arm = new ShufflerArm(3);
		Elevator elevator = new Elevator(1, 0, 8, 9);
		Create create = new Create();
		
		arm.toLeft();
		elevator.shortup();
		create.move(35000, -80);
		
		elevator.up();
		create.move(35000, 80);
		elevator.shortdown();
		arm.toMiddle();
		
		create.move(35000, -80);
	}
}
