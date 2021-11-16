package br.ifba.inf011.afm;

import java.util.Random;

//CONCRETEPRODUCT em um Abstract Factory
public class Estabilizador implements AtuadorIF{

	private double temperaturaAltaLimite;
	private double temperaturaBaixaLimite;
	
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
			valor = Math.abs(random.nextGaussian());
			valor = -(delta * valor);
			System.out.println("[Atuador] resfriando: " + valor + "°");
		}else if(temperatura < this.temperaturaBaixaLimite) {
			delta = this.temperaturaBaixaLimite - temperatura;
			valor = Math.abs(random.nextGaussian());
			valor = (delta * valor);
			System.out.println("[Atuador] aquecendo: " + valor + "°");
		}else
			System.out.println("[Atuador] : " + valor + "°");
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
	
}
