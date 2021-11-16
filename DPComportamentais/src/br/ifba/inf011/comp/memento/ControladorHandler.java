package br.ifba.inf011.comp.memento;

import java.util.List;

//HANDLER em COR
public interface ControladorHandler {
	public double controlar(List<Double> historico, double setpoint, double ganho);
	public void setProximo(ControladorHandler proximo); 
}
