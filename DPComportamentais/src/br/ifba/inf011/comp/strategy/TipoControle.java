package br.ifba.inf011.comp.strategy;

import java.util.List;

public enum TipoControle implements ControladorStrategy{
	PROPORCIONAL{
		@Override
		public double controlar(List<Double> historico, double setpoint, double ganho) {
			double valor = historico.get(historico.size() - 1);
			double delta = valor - setpoint; 
			double valorExecucao = - ganho * delta;
			System.out.print("Aplicando Proporcional :" + valorExecucao + " ");
			return valorExecucao; 
		}
	}, INTEGRAL{
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
	}, PROPORCIONAL_INTEGRAL{
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
			double valorExecucao = (-ganho * delta) + (ganho * (-valorHistorico));
			System.out.print("Aplicando Proporcional-Integral :" + valorExecucao + " ");
			return valorExecucao; 
		}		
	};
}