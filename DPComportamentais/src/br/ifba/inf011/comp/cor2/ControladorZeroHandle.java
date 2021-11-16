package br.ifba.inf011.comp.cor2;

import java.util.List;

public class ControladorZeroHandle implements ControladorHandler{
	
	@Override
	public double controlar(List<Double> historico, double setpoint, double ganho) {
		System.out.print("ZERO ");
		return 0;
	}

	@Override
	public void setProximo(ControladorHandler proximo) {
		
	}

}
