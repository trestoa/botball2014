package at.shufflebots.modules.testing;

import at.shufflebots.modules.CheckList;

public class CheckListTest {

	public static void main(String[] args) {
		new CheckList<String>(new String[]{"Test Check1","Test Check2"}).performChecks();;
	}
}
