package br.ifba.inf011.comp.cor;

import java.util.List;

//HANDLER em um Chain of Responsibility
public interface ControladorHandler {
	//HandleRequest()
	public double controlar(List<Double> historico, double setpoint, double ganho);
	public void setProximo(ControladorHandler proximo); 
}
