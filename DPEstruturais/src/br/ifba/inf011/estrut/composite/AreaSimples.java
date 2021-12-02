package br.ifba.inf011.estrut.composite;

import java.util.Random;

public class AreaSimples implements Area{
	
	public double ultimaMedicao;
	
	public AreaSimples() {
		this.ultimaMedicao = 35;
	}
	
	public double getTemperatura() {
		return this.ultimaMedicao;
	}
	
	public void atuar(double temperatura) {
		this.ultimaMedicao += temperatura;
	}
	
	public void perturbar() {
		Random random = new Random();
		double variacao = 20 + (random.nextDouble() * 20);
		variacao = random.nextBoolean() ? variacao : -variacao;
		this.ultimaMedicao -=  variacao;
	}	

}
