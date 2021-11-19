package br.ifba.inf011.estrut.decorator;

import java.util.List;

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