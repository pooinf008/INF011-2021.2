package br.ifba.inf011.cria.builder;

import java.io.PrintStream;

public class SensorAltaTemperatura implements SensorIF{
	
	
	private PrintStream out;
	private double temperaturaLimite;
	private double temperaturaAtual;
	
	public SensorAltaTemperatura(double temperaturaLimite) {
		this.setTemperaturaLimite(temperaturaLimite);
	}
	
	private void alarmar() {
		this.out.println("[Sensor Temperatura] : " + this.temperaturaAtual + "°: [ALARME DE ALTA DE TEMPERATURA]");
	}
	
	public void medir(double temperatura) {
		this.temperaturaAtual = temperatura;
		if(temperatura > this.getTemperaturaLimite())
			this.alarmar();
		else
			this.out.println("[Sensor Temperatura] : " + this.temperaturaAtual + "°");
	}

	public double getTemperaturaLimite() {
		return temperaturaLimite;
	}

	private void setTemperaturaLimite(double temperaturaLimite) {
		this.temperaturaLimite = temperaturaLimite;
	}

	@Override
	public void setLogger(PrintStream log) {
		this.out = log;
	}

}
