package br.ifba.inf011.comp.cor2;

import java.util.List;

//CONCRETEHANDLER em um Chain of Responsibility
public class ControladorProporcionalIntegralHandler extends AbstractControladorHandler{

	public ControladorProporcionalIntegralHandler(ControladorHandler proximo) {
		super(proximo);
	}
	
	public ControladorProporcionalIntegralHandler() {
		super();
	}	

	@Override
	public double controlar(List<Double> historico, double setpoint, double ganho) {

		double valor = historico.get(historico.size() - 1);
		double delta = valor - setpoint; 
		int qtdeDisponivel = (historico.size() > Controlador.HISTORICO_VALUES) ?
				  Controlador.HISTORICO_VALUES : historico.size();
		double valorHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeDisponivel;
			i--, j++)
		valorHistorico +=  (historico.get(i) - setpoint);
		valorHistorico = valorHistorico / qtdeDisponivel;
		
		if((Math.abs(valorHistorico) < (0.1 * setpoint))) {
			System.out.print("PROPORCIONAL INTEGRAL");
			return (-ganho * delta) + (ganho * (-valorHistorico));
		}	
		
		return this.proximo.controlar(historico, setpoint, ganho);
		
	}
}