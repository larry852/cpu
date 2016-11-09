package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import gui.MainWindows;
import persistence.Memory;
import persistence.Step;

public class Processor {

	Timer timer;
	Memory memory = new Memory();

	public void loadProcess(String process) {
		ArrayList<Step> steps = memory.readProcess(process);
		for (int i = 0; i < steps.size(); i++) {
			int element = i;
			timer = new Timer(2000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MainWindows.getInstancia().drawComponents(steps.get(element).getComponet());
					MainWindows.getInstancia().drawInstructions(steps.get(element).getInstruction());

				}
			});
			timer.start();
		}
		timer.stop();
	}
}
