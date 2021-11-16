package br.ifba.inf011.comp.cor2;

import java.util.List;

//CONCRETEHANDLER em um Chain of Responsibility
public class ControladorProporcionalHandler extends AbstractControladorHandler{

	public ControladorProporcionalHandler(ControladorHandler proximo) {
		super(proximo);
	}
	
	public ControladorProporcionalHandler() {
		super();
	}	

	@Override
	public double controlar(List<Double> historico, double setpoint, double ganho) {
		double valor = historico.get(historico.size() - 1);
		double delta = valor - setpoint;
		System.out.print("PROPORCIONAL");
		return - ganho * delta;
	}
}