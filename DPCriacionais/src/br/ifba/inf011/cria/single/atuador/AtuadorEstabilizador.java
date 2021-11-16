package br.ifba.inf011.cria.single.atuador;

import java.util.Random;

import br.ifba.inf011.cria.single.Prototipavel;

//CONCRETEPROTOTYPE em Prototype
public class AtuadorEstabilizador extends AbstractAtuador implements AtuadorIF{

	private double temperaturaAltaLimite;
	private double temperaturaBaixaLimite;
	
	public AtuadorEstabilizador(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		this.ajuste(temperaturaBaixaLimite, temperaturaAltaLimite);
	}
	
	public AtuadorEstabilizador(AtuadorEstabilizador atuador) {
		this.ajuste(atuador.temperaturaBaixaLimite, atuador.temperaturaAltaLimite);
		this.setLogger(atuador.getLogger());
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
			this.out.println("[Atuador-Estabilizador] RESFRIANDO: " + valor + "°");
		}else if(temperatura < this.temperaturaBaixaLimite) {
			delta = this.temperaturaBaixaLimite - temperatura;
			valor = random.nextGaussian();
			valor = (delta + valor);
			this.out.println("[Atuador-Estabilizador] AQUECENDO: " + valor + "°");
		}else	
			this.out.println("[Atuador-Estabilizador] : " + valor + "°");
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
	public Prototipavel prototipar() {
		return new AtuadorEstabilizador(this);
	}
	

}
