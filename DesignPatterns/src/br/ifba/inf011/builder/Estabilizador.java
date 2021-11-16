package br.ifba.inf011.builder;

import java.io.PrintStream;
import java.util.Random;

public class Estabilizador implements AtuadorIF{

	private double temperaturaAltaLimite;
	private double temperaturaBaixaLimite;
	private PrintStream out;
	
	public Estabilizador(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		this.ajuste(temperaturaBaixaLimite, temperaturaAltaLimite);
	}
	
	
	@Override
	public double atuar(double temperatura) {
		Random random = new Random();
		double valor = 0;
		double delta; 
		if(temperatura > this.temperaturaAltaLimite) {
			delta = temperatura - this.temperaturaAltaLimite;
			valor = random.nextGaussian();
			valor = -(delta + valor);
			this.out.println("[Atuador] RESFRIANDO: " + valor + "°");
		}else if(temperatura < this.temperaturaBaixaLimite) {
			delta = this.temperaturaBaixaLimite - temperatura;
			valor = random.nextGaussian();
			valor = (delta + valor);
			this.out.println("[Atuador] AQUECENDO: " + valor + "°");
		}else	
			this.out.println("[Atuador] : " + valor + "°");
		return valor;	
	}
	
	private void setTemperaturaAltaLimite(double temperaturaLimite) {
		this.temperaturaAltaLimite = temperaturaLimite;
	}
	
	private void setTemperaturaBaixaLimite(double temperaturaLimite) {
		this.temperaturaBaixaLimite = temperaturaLimite;
	}
	


	public void ajuste(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		this.setTemperaturaAltaLimite(temperaturaAltaLimite);
		this.setTemperaturaBaixaLimite(temperaturaBaixaLimite);
	}


	@Override
	public void setLogger(PrintStream out) {
		this.out = out;
		
	}
	

}
