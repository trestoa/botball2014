package at.shufflebots.modules.testing;

import linkjvm.Botball;
import linkjvm.sensors.buttons.AButton;
import linkjvm.sensors.buttons.CButton;
import linkjvm.sensors.buttons.SideButton;
import at.shufflebots.modules.VArms;

public class VArmsTest {
	public static void main(String[] args) {
		VArms arms = new VArms();
		SideButton sideButton = new SideButton();
		AButton aButton = new AButton();
		aButton.setText("Open");
		CButton cButton = new CButton();
		cButton.setText("Close");
		while(!sideButton.getValue()){
			if(cButton.isPressed()){
				arms.close();
			} else if(aButton.isPressed()){
				arms.open();
			}
			Botball.msleep(20);
		}
	}
}
