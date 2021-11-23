package br.ifba.inf011.estrut.bridge;

import java.util.List;

public interface ControladorHandler {
	public double controlar(List<Double> historico, double setpoint, double ganho);
	public void setProximo(ControladorHandler proximo); 
}
