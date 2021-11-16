package br.ifba.inf011.comp.cor;

import java.util.List;

//CONCRETEHANDLER em um Chain of Responsibility
public class ControladorProporcionalHandler extends AbstractControladorHandler{

	public ControladorProporcionalHandler(ControladorHandler proximo) {
		super(proximo);
	}
	
	public ControladorProporcionalHandler() {
		super();
	}	

	public double atuar(List<Double> historico, double setpoint, double ganho) {
		double valor = historico.get(historico.size() - 1);
		double delta = valor - setpoint;
		System.out.print("PROPORCIONAL");
		return - ganho * delta;
	}

	public boolean ehComigo(List<Double> historico, double setpoint, double ganho) {
		return true;
	}	
}