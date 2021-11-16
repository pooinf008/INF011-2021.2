package br.ifba.inf011.comp.tm;

import java.util.List;

//CONCRETECLASS em Template Method
public class ControladorProporcionalHandler extends AbstractControladorHandler{

	public ControladorProporcionalHandler() {
		super();
	}	
	
	public ControladorProporcionalHandler(ControladorHandler proximo) {
		super(proximo);
	}

	@Override
	//PRIMITIVEOPERATION em Template Method 
	protected double valorAtuacao(List<Double> historico, double setpoint, double ganho) {
		double valor = historico.get(historico.size() - 1);
		double delta = valor - setpoint; 
		return - ganho * delta;	
	}

	@Override
	//PRIMITIVEOPERATION em Template Method 
	protected boolean aplicavel(List<Double> historico, double setpoint, double ganho) {
		return true;
	}
}