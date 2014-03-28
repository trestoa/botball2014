package at.shufflebots.programs;

import linkjvm.Botball;
import linkjvm.create.Create;

public class LinkJVMTest {
	public static void main(String[] args) {
		Create create = new Create();
		create.connect();
		create.driveDirect(200, 200);
		Botball.shutDownIn(4);
	}
}
