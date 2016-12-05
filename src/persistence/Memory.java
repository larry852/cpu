package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Memory {

	public ArrayList<Step> readProcess(String process) {
		ArrayList<Step> steps = new ArrayList<Step>();
		String line;
		FileReader f;
		try {
			File jarFile = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
			f = new FileReader(jarFile.getParentFile()+"/procesos/" + process);
			BufferedReader b = new BufferedReader(f);
			while ((line = b.readLine()) != null) {
				String[] parts = line.split("-");
				String componet = parts[0];
				String instruction = parts[1];
				steps.add(new Step(componet, instruction));
			}
			b.close();
		} catch (Exception e) {
			System.err.println("Error al leer: " + process);
			System.err.println("Error: " + e);
			JOptionPane.showMessageDialog(null, "Error al leer el " + process + ". Verifique su estado.");
		}

		return steps;
	}

}
