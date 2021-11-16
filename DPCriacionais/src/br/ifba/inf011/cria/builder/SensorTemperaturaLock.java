package br.ifba.inf011.cria.builder;

import java.io.PrintStream;

public class SensorTemperaturaLock implements SensorIF{

	private double temperaturaLimite;
	private double temperaturaAtual;
	private boolean lock;
	private PrintStream out;
	
	public SensorTemperaturaLock(double temperaturaLimite2) {
		this.setTemperaturaLimite(temperaturaLimite2);
		this.lock = false;
	}
	
	public SensorTemperaturaLock() {
		this.lock = false;
	}	
	
	
	private void alarmar() {
		this.out.println("[Sensor Temperatura Lock] : " + this.temperaturaAtual + "°: [ALARME DE ALTA DE TEMPERATURA]");
		this.lock = true;
	}
	
	
	public void medir(double temperatura) {
		this.temperaturaAtual = temperatura;
		if(temperatura > this.getTemperaturaLimite() || this.lock)
			this.alarmar();
		else
			this.out.println("[Sensor Temperatura Lock] : " + this.temperaturaAtual + "°");
	}


	public double getTemperaturaLimite() {
		return temperaturaLimite;
	}


	private void setTemperaturaLimite(double temperaturaLimite) {
		this.temperaturaLimite = temperaturaLimite;
	}

	public void reset() {
		this.lock = false;
	}
	
	public void ajuste(double temperaturaLimite) {
		this.setTemperaturaLimite(temperaturaLimite);
	}

	@Override
	public void setLogger(PrintStream log) {
		this.out = log;
		
	}
	
}
