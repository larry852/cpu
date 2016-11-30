package logic;

import java.util.ArrayList;

import gui.MainWindows;
import persistence.Memory;
import persistence.Step;
import sun.management.resources.agent_it;

public class Processor {

	Thread thread;
	Memory memory = new Memory();

	public void loadProcess(String process) {
		thread = new Thread() {
			public void run() {
				ArrayList<Step> steps = memory.readProcess(process);
				for (int i = 0; i < steps.size(); i++) {
					MainWindows.getInstancia().drawComponents(steps.get(i).getComponet());
					MainWindows.getInstancia().drawInstructions(
							steps.get(i).getInstruction() + " (" + process.charAt(process.length() - 1) + ")");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				}
				MainWindows.getInstancia().Again();
				thread.interrupt();
			}
		};
		thread.start();

	}

}