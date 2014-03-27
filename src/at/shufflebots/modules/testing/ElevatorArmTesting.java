package at.shufflebots.modules.testing;

import at.shufflebots.modules.ElevatorArm;
import linkjvm.Botball;
import linkjvm.sensors.buttons.AButton;
import linkjvm.sensors.buttons.CButton;
import linkjvm.sensors.buttons.SideButton;

public class ElevatorArmTesting {

	public static void main(String[] args) {
		Botball.waitForLight(0);
		AButton a = new AButton();
		a.setText("Up");
		CButton c = new CButton();
		c.setText("Down");
		SideButton sb = new SideButton();
		ElevatorArm arm = new ElevatorArm(2, 3,0 , 0);
		while(!sb.isPressed()) {
			if(a.isPressed())
				arm.up();
			if(c.isPressed())
				arm.down();
			Botball.msleep(100);
		}
		arm.disable();
	}
}
