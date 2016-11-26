package logic;

import javax.swing.JOptionPane;

import gui.MainWindows;

public class Evaluacion {
	
	MainWindows ventanaPrincipal;	
	boolean tipoEvaluacion;//0 evaluación ivan, 1 evaluacion mauricio
	boolean evaluando;//determina si se está evaluando o no. para que cuano esté evaluando para que los botones no hagan su funcion por defecto
	final int CANTIDAD_PROCESOS = 2;//para hacer un random hasta la cantidad de procesos
	String procesoEnEvaluacion;
	Evaluador evaluador;
	
	public Evaluacion(MainWindows ventanaPrincipal){
		this.ventanaPrincipal = ventanaPrincipal;
		this.tipoEvaluacion = true;
		this.evaluando = false;
		this.evaluador = new Evaluador(); 
	}
	
	public void evaluar(){
		this.evaluando = true;
		if (tipoEvaluacion) {
			evaluacionMauricio();
		}else{
			evaluacionIvan();
		}
		
	}
	
	public void responder(String proceso){
		if (this.procesoEnEvaluacion.equals(proceso)) {
			this.evaluador.setMostrando(false);
			JOptionPane.showMessageDialog(null, "Excelente!! \n ha escogido el proceso correcto!");
		}
		else{
			JOptionPane.showMessageDialog(null, "Incorreco!! \n ha escogido un proceso incorrecto!");
		}
		
	}
	
	public void evaluacionMauricio(){
		JOptionPane.showMessageDialog(null, "Por favor seleccione el proceso que corresponde con la secuencia \nque se muestra en el diagrama");
		int procesoEvaluar = (int)(Math.random() * (CANTIDAD_PROCESOS));
		String nombreProceso = "proceso " + procesoEvaluar;
		this.procesoEnEvaluacion = nombreProceso;
		evaluador = new Evaluador();
		evaluador.evaluarProceso(nombreProceso);
	}
	
	public void evaluacionIvan(){
		
	}

	public boolean isEvaluando() {
		return evaluando;
	}

	public void setEvaluando(boolean evaluando) {
		this.evaluando = evaluando;
	}
	
	
	

}
