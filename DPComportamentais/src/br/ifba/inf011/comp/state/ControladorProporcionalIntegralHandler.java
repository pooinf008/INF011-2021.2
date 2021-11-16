package br.ifba.inf011.comp.state;

import java.util.List;

//CONCRETEHANDLER em COR
public class ControladorProporcionalIntegralHandler extends AbstractControladorHandler{

	public ControladorProporcionalIntegralHandler() {
		super();
	}	
	
	
	public ControladorProporcionalIntegralHandler(ControladorHandler proximo) {
		super(proximo);
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
		
		double valorAplicacao = (-ganho * delta) + (ganho * (-valorHistorico)); 
		
		if((Math.abs(valorAplicacao) > (0.25 * setpoint))) {
			return valorAplicacao;
		}	
		
		return this.hasProximo() ? 
				   this.proximo.controlar(historico, setpoint, ganho) :
				   0;		
		
	}
}