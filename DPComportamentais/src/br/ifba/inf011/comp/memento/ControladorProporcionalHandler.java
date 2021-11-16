package br.ifba.inf011.comp.memento;

import java.util.List;

//CONCRETEHANDLER em COR
public class ControladorProporcionalHandler extends AbstractControladorHandler{

	public ControladorProporcionalHandler() {
		super();
	}	
	
	public ControladorProporcionalHandler(ControladorHandler proximo) {
		super(proximo);
	}

	@Override
	public double controlar(List<Double> historico, double setpoint, double ganho) {
		double valor = historico.get(historico.size() - 1);
		double delta = valor - setpoint; 
		return - ganho * delta;	
	}
}