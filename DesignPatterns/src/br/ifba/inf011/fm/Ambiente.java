package br.ifba.inf011.fm;

import java.util.Random;

public class Ambiente{
	
	public double ultimaMedicao = 27;
	
	public double getTemperatura() {
		Random random = new Random();
		double variacao = random.nextDouble() * 2;
		variacao = random.nextBoolean() ? variacao : -variacao;
		this.ultimaMedicao -=  variacao;
		return this.ultimaMedicao; 
	}
	
	

}
