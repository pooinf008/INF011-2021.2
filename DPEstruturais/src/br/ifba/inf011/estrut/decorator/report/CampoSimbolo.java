package br.ifba.inf011.estrut.decorator.report;


//CONCRETEDECORATOR em um Decorator
public class CampoSimbolo extends LinhaDecorator{
	
	public CampoSimbolo(LinhaIF decorado) {
		super(decorado);
	}
	
	public String conteudo(double setpoint, double temperatura) {
		DeltaTemperatura deltaTemperatura = new DeltaTemperatura(setpoint, temperatura);
		return this.decorado.conteudo(setpoint, temperatura) + " " + deltaTemperatura.getSimbolo();
	};
}
