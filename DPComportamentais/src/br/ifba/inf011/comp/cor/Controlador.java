package br.ifba.inf011.comp.cor;

import java.util.LinkedList;
import java.util.List;

//CLIENT em um Chain of Responsibility
public class Controlador {
	
	protected static int HISTORICO_VALUES = 5;
	
	private List<Double> historico;
	private double setpoint;
	private double ganho;
	private ControladorHandler controlador;
	
	public Controlador(double setpoint, double ganho){
		this.historico = new LinkedList<Double>();
		this.setpoint = setpoint;
		this.ganho = ganho;
		this.controlador = new ControladorProporcionalIntegralHandler(
				new ControladorIntegralHandler(
						new ControladorProporcionalHandler()));
	}

	public double executar(double valor){
		this.historico.add(valor);
		
		return this.controlador.controlar(this.historico, this.setpoint, this.ganho);
		 
		
	}

}
