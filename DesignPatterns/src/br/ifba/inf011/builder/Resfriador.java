package br.ifba.inf011.builder;

import java.io.PrintStream;
import java.util.Random;

public class Resfriador implements AtuadorIF{

	private PrintStream out;
	private double temperaturaLimite;
	
	public Resfriador(double temperaturaLimite) {
		this.setTemperaturaLimite(temperaturaLimite);
	}	
	
	private void setTemperaturaLimite(double temperaturaLimite) {
		this.temperaturaLimite = temperaturaLimite;
	}	
	
	@Override
	public double atuar(double temperatura) {
		Random random = new Random();
		double valor = 0;
		double delta = temperatura - this.temperaturaLimite;
		if(delta > 0) {
			valor = random.nextGaussian();
			valor -= (delta + valor);
		}
		this.out.println("[Atuador] : resfriando " + valor + "°");
		return valor;	
	}

	@Override
	public void setLogger(PrintStream log) {
		this.out = log;
	}	

}
