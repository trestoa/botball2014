package at.shufflebots.modules.testing;

import at.shufflebots.modules.Elevator;
import linkjvm.Botball;
import linkjvm.sensors.buttons.AButton;
import linkjvm.sensors.buttons.BButton;
import linkjvm.sensors.buttons.CButton;
import linkjvm.sensors.buttons.SideButton;

public class ElevatorTest {
	
	public static void main(String[] args) {
		AButton a = new AButton();
		a.setText("Up");
		BButton b = new BButton();
		b.setText("Stop");
		CButton c = new CButton();
		c.setText("Down");
		SideButton sb = new SideButton();
		Elevator lift = new Elevator(1, 0);
		while(!sb.isPressed()) {
			if(a.isPressed())
				lift.up();
			if(b.isPressed())
				lift.stop();
			if(c.isPressed())
				lift.down();
			Botball.msleep(100);
		}
		lift.stop();
	}
}
