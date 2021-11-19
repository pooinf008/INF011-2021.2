package br.ifba.inf011.estrut.decorator;

import java.util.List;

public class ControladorIntegralHandler extends AbstractControladorHandler{

	public ControladorIntegralHandler() {
		super();
	}	
	
	public ControladorIntegralHandler(ControladorHandler proximo) {
		super(proximo);
	}

	@Override
	public double controlar(List<Double> historico, double setpoint, double ganho) {

		int qtdeDisponivel = (historico.size() > Controlador.HISTORICO_VALUES) ?
				  Controlador.HISTORICO_VALUES : historico.size();
		double valorHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeDisponivel;
				i--, j++)
			valorHistorico +=  (historico.get(i) - setpoint);
		valorHistorico = valorHistorico / qtdeDisponivel;
		
		double valorAplicacao = ganho * (-valorHistorico); 
		
		if((Math.abs(valorAplicacao) > (0.15 * setpoint))) {
			return valorAplicacao;
		}	
		
		return this.hasProximo() ? 
			   this.proximo.controlar(historico, setpoint, ganho) :
			   0;
	}
}