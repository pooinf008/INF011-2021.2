package br.ifba.inf011.comp.tm;

import java.util.List;

//CONCRETECLASS em Template Method
public class ControladorIntegralHandler extends AbstractControladorHandler{

	public ControladorIntegralHandler() {
		super();
	}	
	
	public ControladorIntegralHandler(ControladorHandler proximo) {
		super(proximo);
	}


	@Override
	//PRIMITIVEOPERATION em Template Method 
	protected double valorAtuacao(List<Double> historico, double setpoint, double ganho) {
		int qtdeDisponivel = (historico.size() > Controlador.HISTORICO_VALUES) ?
				  Controlador.HISTORICO_VALUES : historico.size();
		double valorHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeDisponivel;
				i--, j++)
			valorHistorico +=  (historico.get(i) - setpoint);
		valorHistorico = valorHistorico / qtdeDisponivel;
		return ganho * (-valorHistorico);
	}

	@Override
	//PRIMITIVEOPERATION em Template Method 
	protected boolean aplicavel(List<Double> historico, double setpoint, double ganho) {
		int qtdeDisponivel = (historico.size() > Controlador.HISTORICO_VALUES) ?
				  Controlador.HISTORICO_VALUES : historico.size();
		double valorHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeDisponivel;
				i--, j++)
			valorHistorico +=  (historico.get(i) - setpoint);
		valorHistorico = valorHistorico / qtdeDisponivel;
		
		double valorAplicacao = ganho * (-valorHistorico);
		return Math.abs(valorAplicacao) > (0.15 * setpoint);
	}
}