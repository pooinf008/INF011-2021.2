package br.ifba.inf011.comp.base;

import java.util.LinkedList;
import java.util.List;

public class Controlador {
	
	private static int HISTORICO_VALUES = 5;
	
	private List<Double> historico;
	private double setpoint;
	private double ganho;
	
	public Controlador(double setpoint, double ganho){
		this.historico = new LinkedList<Double>();
		this.setpoint = setpoint;
		this.ganho = ganho;
	}

	public double executar(TipoControle tipo, double valor){
		this.historico.add(valor);
		if(tipo == TipoControle.PROPORCIONAL) {
			double delta = valor - this.setpoint; 
			return - ganho * delta; 
		}
		if(tipo == TipoControle.INTEGRAL) {
			int qtdeDisponivel = (this.historico.size() > Controlador.HISTORICO_VALUES) ?
								  Controlador.HISTORICO_VALUES : this.historico.size();
			double valorHistorico = 0;
			for(int i = this.historico.size() - 1, j = 0; j < qtdeDisponivel;
				i--, j++)
				valorHistorico +=  (this.historico.get(i) - this.setpoint);
			valorHistorico = valorHistorico / qtdeDisponivel;
			return ganho * (-valorHistorico);
			
		}else if (tipo == TipoControle.PROPORCIONAL_INTEGRAL) {
			double delta = valor - this.setpoint; 
			int qtdeDisponivel = (this.historico.size() > Controlador.HISTORICO_VALUES) ?
					  Controlador.HISTORICO_VALUES : this.historico.size();
			double valorHistorico = 0;
			for(int i = this.historico.size() - 1, j = 0; j < qtdeDisponivel;
				i--, j++)
			valorHistorico +=  (this.historico.get(i) - this.setpoint);
			valorHistorico = valorHistorico / qtdeDisponivel;
			return (-ganho * delta) + (ganho * (-valorHistorico));
		}
		return 0;
	}

}
