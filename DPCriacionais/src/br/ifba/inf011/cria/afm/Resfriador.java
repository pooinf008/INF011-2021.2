package br.ifba.inf011.cria.afm;

import java.util.Random;

//CONCRETEPRODUCT em um Abstract Factory
public class Resfriador implements AtuadorIF{

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
		System.out.println("[Atuador] : resfriando " + valor + "°");
		return valor;	
	}

}
