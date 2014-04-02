package at.shufflebots.modules.testing;

import at.shufflebots.modules.ShufflerArm;
import linkjvm.Botball;
import linkjvm.sensors.buttons.AButton;
import linkjvm.sensors.buttons.BButton;
import linkjvm.sensors.buttons.ButtonController;
import linkjvm.sensors.buttons.CButton;
import linkjvm.sensors.buttons.SideButton;
import linkjvm.sensors.buttons.XButton;
import linkjvm.sensors.buttons.ZButton;

public class ShufflerArmTest {

	public static void main(String[] args) {
		
		ButtonController.showExtraButtons();
		XButton x = new XButton();
		x.setText("littleLeft");
		ZButton z = new ZButton();
		z.setText("littleRight");
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
				sarm.toLeft();
			if(b.isPressed())
				sarm.toMiddle();
			if(c.isPressed())
				sarm.toRight();
			if(x.isPressed())
				sarm.littleLeft();
			if(z.isPressed())
				sarm.littleRight();
			Botball.msleep(100);
		}
		sarm.stopAll();
	}
}
