package at.shufflebots.modules.testing;

import linkjvm.Botball;
import linkjvm.create.Create;

public class CreateTest {
	public static void main(String[] args) {
		//Botball.waitForLight(0);
		Create c = new Create();
		c.connect();
		c.driveDirect(200, 200);
		Botball.msleep(5000);
		c.stop();
		c.disconnect();
	}
}