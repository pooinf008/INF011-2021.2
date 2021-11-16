package br.ifba.inf011.comp.cor;

import java.util.List;

//CONCRETEHANDLER em um Chain of Responsibility
public class ControladorIntegralHandler extends AbstractControladorHandler{

	public ControladorIntegralHandler(ControladorHandler proximo) {
		super(proximo);
	}
	
	public ControladorIntegralHandler() {
		super();
	}	
	
	
	public double getValorHistorico(List<Double> historico, double setpoint, double ganho){
		int qtdeDisponivel = (historico.size() > Controlador.HISTORICO_VALUES) ?
				  Controlador.HISTORICO_VALUES : historico.size();
		double valorHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeDisponivel;
				i--, j++)
			valorHistorico +=  (historico.get(i) - setpoint);
		valorHistorico = valorHistorico / qtdeDisponivel;
		return valorHistorico;
		
	}
	
	public boolean ehComigo(List<Double> historico, double setpoint, double ganho) {
		return ((Math.abs(this.getValorHistorico(historico, setpoint, ganho)) < (0.5 * setpoint))); 		
	}
	
	public double atuar(List<Double> historico, double setpoint, double ganho) {
		System.out.print("INTEGRAL ");
		return ganho * (-this.getValorHistorico(historico, setpoint, ganho));
	}

}