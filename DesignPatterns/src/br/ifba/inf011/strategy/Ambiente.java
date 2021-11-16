package br.ifba.inf011.strategy;

import java.util.Random;

	

public class Ambiente{
	
	private static final double TEMP_START = 27.0;
	private static final double TEMP_MAX_VAR = 3.0;
	
	public double ultimaMedicao;
	
	
	public Ambiente() {
		this.ultimaMedicao = Ambiente.TEMP_START;
	}
	
	public double getTemperatura() {
		Random random = new Random();
		double variacao = random.nextDouble() * Ambiente.TEMP_MAX_VAR;
		variacao = random.nextBoolean() ? variacao : -variacao;
		this.ultimaMedicao +=  variacao;
		return this.ultimaMedicao; 
	}
	
	public void modificar(double temperatura) {
		Random random = new Random();
		this.ultimaMedicao += (random.nextDouble() * temperatura);
		System.out.println("[Temperatura após atuação]: " + this.ultimaMedicao);
	}
	
	

}
