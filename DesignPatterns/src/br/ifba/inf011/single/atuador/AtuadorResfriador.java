package br.ifba.inf011.single.atuador;

import java.util.Random;
import br.ifba.inf011.single.Prototipavel;

//CONCRETEPROTOTYPE em Prototype
public class AtuadorResfriador extends AbstractAtuador implements AtuadorIF{

	private double temperaturaLimite;
	
	public AtuadorResfriador(double temperaturaLimite) {
		this.setTemperaturaLimite(temperaturaLimite);
	}	
	
	public AtuadorResfriador(AtuadorResfriador atuadorResfriador) {
		this(atuadorResfriador.temperaturaLimite);
		this.setLogger(atuadorResfriador.getLogger());		
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
		this.out.println("[Atuador-Resfriador] : resfriando " + valor + "°");
		return valor;	
	}

	@Override
	public void ajuste(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		this.setTemperaturaLimite(temperaturaAltaLimite);
	}
	
	@Override
	public Prototipavel prototipar() {
		return new AtuadorResfriador(this);
	}
	



}
