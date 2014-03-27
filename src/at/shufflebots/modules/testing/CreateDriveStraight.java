package at.shufflebots.modules.testing;

import linkjvm.Botball;
import linkjvm.create.Create;

public class CreateDriveStraight {

	public static void main(String[] args) {
		Create c = new Create();
		c.connect();
		c.driveDirect(200, 200);
		Botball.msleep(5500);
		c.stop();
	}
}
