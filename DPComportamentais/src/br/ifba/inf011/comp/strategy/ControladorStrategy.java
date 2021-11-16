package br.ifba.inf011.comp.strategy;

import java.util.List;

//STRATEGY em um Strategy
public interface ControladorStrategy {
	public double controlar(List<Double> historico, double setpoint, double ganho);
	
}
