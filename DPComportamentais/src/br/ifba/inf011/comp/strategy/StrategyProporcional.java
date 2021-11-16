package br.ifba.inf011.comp.strategy;

import java.util.List;

//CONCRETESTRATEGY em um Strategy
public class StrategyProporcional implements ControladorStrategy{

	@Override
	public double controlar(List<Double> historico, double setpoint, double ganho) {
		double valor = historico.get(historico.size() - 1);
		double delta = valor - setpoint; 
		double valorExecucao = - ganho * delta;
		System.out.print("Aplicando Proporcional :" + valorExecucao + " ");
		return valorExecucao; 
	}
}