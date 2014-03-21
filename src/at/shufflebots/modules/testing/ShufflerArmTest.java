package at.shufflebots.modules.testing;

import at.shufflebots.modules.ShufflerArm;
import linkjvm.Botball;
import linkjvm.sensors.buttons.AButton;
import linkjvm.sensors.buttons.BButton;
import linkjvm.sensors.buttons.CButton;
import linkjvm.sensors.buttons.SideButton;

public class ShufflerArmTest {

	public static void main(String[] args) {
		AButton a = new AButton();
		a.setText("Left");
		BButton b = new BButton();
		b.setText("Middle");
		CButton c = new CButton();
		c.setText("Right");
		SideButton sb = new SideButton();
		ShufflerArm sarm = new ShufflerArm(3);
		while(!sb.isPressed()) {
			if(a.isPressed())
				sarm.to_Left();
			if(b.isPressed())
				sarm.to_Middle();
			if(c.isPressed())
				sarm.to_Right();
			Botball.msleep(100);
		}
	}
}
