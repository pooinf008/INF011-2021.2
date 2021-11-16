package br.ifba.inf011.comp.strategy;

import java.util.List;

//CONCRETESTRATEGY em um Strategy
public class StrategyIntegral implements ControladorStrategy{

	@Override
	public double controlar(List<Double> historico, double setpoint, double ganho) {
		int qtdeDisponivel = (historico.size() > Controlador.HISTORICO_VALUES) ?
				  Controlador.HISTORICO_VALUES : historico.size();
		double valorHistorico = 0;
		for(int i = historico.size() - 1, j = 0; j < qtdeDisponivel;
				i--, j++)
			valorHistorico +=  (historico.get(i) - setpoint);
		valorHistorico = valorHistorico / qtdeDisponivel;
		double valorExecucao = -ganho * (valorHistorico);
		System.out.print("Aplicando Integral :" + valorExecucao + " ");
		return valorExecucao; 
	}
}