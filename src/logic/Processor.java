package logic;

import java.util.ArrayList;

import gui.MainWindows;
import persistence.Memory;
import persistence.Step;

public class Processor {

	Thread thread;
	Memory memory = new Memory();

	public void loadProcess(final String process) {
		thread = new Thread() {
			public void run() {
				ArrayList<Step> steps = memory.readProcess(process);
				for (int i = 0; i < steps.size(); i++) {
					MainWindows.getInstancia().drawComponents(
							steps.get(i).getComponet());
					MainWindows.getInstancia().drawInstructions(
							steps.get(i).getInstruction());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				}
			}
		};
		thread.start();

	}
}