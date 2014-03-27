package at.shufflebots.modules.testing;

import at.shufflebots.modules.Elevator;
import linkjvm.Botball;
import linkjvm.sensors.buttons.AButton;
import linkjvm.sensors.buttons.ButtonController;
import linkjvm.sensors.buttons.CButton;
import linkjvm.sensors.buttons.SideButton;
import linkjvm.sensors.buttons.XButton;
import linkjvm.sensors.buttons.ZButton;

public class ElevatorTest {
	
	public static void main(String[] args) {
		ButtonController.showExtraButtons();
		AButton a = new AButton();
		a.setText("Up");
		CButton c = new CButton();
		c.setText("Down");
		XButton x = new XButton();
		x.setText("Short Up");
		ZButton z = new ZButton();
		z.setText("Short Down");
		SideButton sb = new SideButton();
		Elevator lift = new Elevator(0, 1, 8, 9);
		while(!sb.isPressed()) {
			if(a.isPressed())
				lift.up();
			if(c.isPressed())
				lift.down();
			if(x.isPressed())
				lift.shortup();
			if(z.isPressed())
				lift.shortdown();
			Botball.msleep(100);
		}
	}
}
