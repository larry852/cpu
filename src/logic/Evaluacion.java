package logic;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import gui.MainWindows;

public class Evaluacion {
	
	MainWindows ventanaPrincipal;	
	boolean tipoEvaluacion;//0 evaluaci�n ivan, 1 evaluacion mauricio
	boolean evaluando;//determina si se est� evaluando o no. para que cuano est� evaluando para que los botones no hagan su funcion por defecto
	final int CANTIDAD_PROCESOS = 2;//para hacer un random hasta la cantidad de procesos
	String procesoEnEvaluacion;
	ArrayList<Integer> secuencia = new ArrayList<Integer>();
	
	Evaluador evaluador;
	
	public Evaluacion(MainWindows ventanaPrincipal){
		this.ventanaPrincipal = ventanaPrincipal;
		this.tipoEvaluacion = true;
		this.evaluando = false;
		this.evaluador = new Evaluador(this); 
	}
	
	public void evaluar(){
		this.evaluando = true;
		int random = (int)(Math.random() * 2);
		if (random == 0) {//seleccionamos 
			this.tipoEvaluacion = false;
		}
		else{
			this.tipoEvaluacion = true;
		}
		if (tipoEvaluacion) {
			evaluacionMauricio();
		}else{
			evaluacionIvan();
		}
		
	}
	
	public void llenar(int proceso){
		if (proceso == 0) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
		if (proceso == 1) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
		if (proceso == 2) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
		if (proceso == 3) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
		if (proceso == 4) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
		if (proceso == 5) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
		if (proceso == 6) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
		if (proceso == 7) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
		if (proceso == 8) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
		if (proceso == 9) {
			secuencia.add(1);
			secuencia.add(2);
			secuencia.add(3);
		}
	}
	
	public void comprobar(int dato){
		int aux=0;
		for (int i = 0; i < secuencia.size(); i++) {
			if (dato == secuencia.get(i)) {
				aux++;
			}
		}
		if (aux==1) {
			
		}else{
			JOptionPane.showMessageDialog(null, "componente incorrecto");
		}
	}
	
	public ArrayList<Integer> getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(ArrayList<Integer> secuencia) {
		this.secuencia = secuencia;
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
		evaluador = new Evaluador(this);
		evaluador.evaluarProceso(nombreProceso);
	}
	
	public void evaluacionIvan(){
		JOptionPane.showMessageDialog(null, "Seleccione el proceso que quiera comprobar y luego los componentes que cree");
	}

	public boolean isEvaluando() {
		return evaluando;
	}

	public void setEvaluando(boolean evaluando) {
		this.evaluando = evaluando;
	}

	public boolean getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(boolean tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
	
	
	

}
