package br.ifba.inf011.comp.strategy;

import java.util.LinkedList;
import java.util.List;


//CONTEXT em um Strategy
public class Controlador2 {
	
	protected static int HISTORICO_VALUES = 5;
	
	private List<Double> historico;
	private double setpoint;
	private double ganho;
	private TipoControle strategy;
	
	public void setStrategy(TipoControle strategy) {
		this.strategy = strategy;
	}

	public Controlador2(double setpoint, double ganho){
		this.historico = new LinkedList<Double>();
		this.setpoint = setpoint;
		this.ganho = ganho;
	}

	public double executar(double valor){
		this.historico.add(valor);
		return this.strategy.controlar(this.historico, this.setpoint, this.ganho);
	}





}
