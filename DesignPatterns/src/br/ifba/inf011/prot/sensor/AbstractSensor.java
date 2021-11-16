package br.ifba.inf011.prot.sensor;

import java.io.PrintStream;

import br.ifba.inf011.prot.Prototipavel;

public abstract class AbstractSensor implements SensorIF{

	protected PrintStream out;
	protected double temperaturaAtual;
	
	@Override
	public void setLogger(PrintStream log) {
		this.out = log;
	}

	public PrintStream getOut() {
		return out;
	}

	public void setOut(PrintStream out) {
		this.out = out;
	}

	public double getTemperaturaAtual() {
		return temperaturaAtual;
	}

	public void setTemperaturaAtual(double temperaturaAtual) {
		this.temperaturaAtual = temperaturaAtual;
	}
}
