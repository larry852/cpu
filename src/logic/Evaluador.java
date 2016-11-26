package logic;

import gui.MainWindows;

import java.util.ArrayList;

import persistence.Memory;
import persistence.Step;

public class Evaluador extends Thread{
	
	Memory memory;
	boolean mostrando;
	String nombreProceso;
	
	public Evaluador(){
		memory = new Memory();
		mostrando = true;
	}
	
	public void evaluarProceso(String process){	
		this.nombreProceso = process;
		this.start();
	}

	public boolean isMostrando() {
		return mostrando;
	}

	public void setMostrando(boolean mostrando) {
		this.mostrando = mostrando;
	}
	
	@Override
	public void run() {
		while(mostrando){
			ArrayList<Step> steps = memory.readProcess(nombreProceso);
			for (int i = 0; i < steps.size(); i++) {
				MainWindows.getInstancia().drawComponents(
						steps.get(i).getComponet());				
				MainWindows.getInstancia().drawInstructions(steps.get(i).getInstruction());
				if (!mostrando) {
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
			MainWindows.getInstancia().instruccionVacia();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
