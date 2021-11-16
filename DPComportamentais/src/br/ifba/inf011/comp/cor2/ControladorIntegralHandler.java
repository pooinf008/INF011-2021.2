package br.ifba.inf011.comp.cor2;

import java.util.List;

//CONCRETEHANDLER em um Chain of Responsibility
public class ControladorIntegralHandler extends AbstractControladorHandler{

	public ControladorIntegralHandler(ControladorHandler proximo) {
		super(proximo);
	}
	
	public ControladorIntegralHandler() {
		super();
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
		
		if((Math.abs(valorHistorico) < (0.5 * setpoint))) {
			System.out.print("INTEGRAL ");
			return ganho * (-valorHistorico);
		}	
		
		return this.proximo.controlar(historico, setpoint, ganho);
		
	}
}