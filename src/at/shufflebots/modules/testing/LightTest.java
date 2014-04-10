package at.shufflebots.modules.testing;

import linkjvm.sensors.analog.AnalogSensor;
import linkjvm.sensors.buttons.SideButton;

public class LightTest {
	public static void main(String[] args) {
		SideButton sb = new SideButton();
		AnalogSensor sen = new AnalogSensor(0);
		int maxValue = 1024;
		while(!sb.isPressed()){
			int val = sen.getValue();
			if(val < maxValue){
				maxValue = val;
				System.out.println(maxValue);
			}
		}
	}
}
