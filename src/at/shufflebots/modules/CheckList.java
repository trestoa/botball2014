package at.shufflebots.modules;

import java.util.LinkedList;

import linkjvm.sensors.buttons.BButton;

public class CheckList<E> {

	private LinkedList<E> list;
	private BButton b;
	
	@SafeVarargs
	public CheckList (E... checks) {
		this.list = new LinkedList<>();
		this.b = new BButton();
		for(E check : checks)
			list.add(check);
	}
	
	public void performChecks() {
		String oldText = b.getText();
		b.setText("Check");
		for(E check : list) {
			System.out.println(check);
			while(!b.isPressed());
			while(b.isPressed());
			System.out.print("\f");
		}
		b.setText(oldText);
	}
}
