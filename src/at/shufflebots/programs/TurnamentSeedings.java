package at.shufflebots.programs;

import at.shufflebots.modules.CheckList;
import at.shufflebots.modules.VArms;
import linkjvm.Botball;
import linkjvm.create.Create;
import linkjvm.sensors.buttons.SideButton;

public class TurnamentSeedings {
	public static void main(String[] args) {
		new CheckList<String>("Create up",
				"Shuffler-Arm| 3", 
				"Elev-Motor  | top: 1, bottom: 0", 
				"Elev-Sensor | top: 8, bottom: 9", 
				"Elev-Arm    | left: 1, right: 3",
				"V-Arm       | left: 0, right: 2",
				"Light		 | 0").performChecks();
		Create create = new Create();
		VArms vArms = new VArms();
		create.connect();
		Botball.waitForLight(0);
		vArms.open();
		create.driveDirect(150, -150);
		Botball.msleep(750);
		create.driveDirect(-200, -200);
		SideButton b = new SideButton();
		while(!b.isPressed()){
			Botball.msleep(20);
		}
		create.stop();
	}
}
