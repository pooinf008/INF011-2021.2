package br.ifba.inf011.comp.cor;

import java.util.List;

//HANDLER em um Chain of Responsibility
public abstract class AbstractControladorHandler implements ControladorHandler{
	
	protected ControladorHandler proximo;
	
	public AbstractControladorHandler(ControladorHandler proximo){
		this.setProximo(proximo);
	}
	
	public AbstractControladorHandler(){
		this.setProximo(new ControladorZeroHandle());
	}	

	@Override
	public void setProximo(ControladorHandler proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public double controlar(List<Double> historico, double setpoint, double ganho) {
		if(this.ehComigo(historico, setpoint, ganho))
			return this.atuar(historico, setpoint, ganho);
		return this.proximo.controlar(historico, setpoint, ganho);
	}

	protected abstract double atuar(List<Double> historico, double setpoint, double ganho);

	protected abstract boolean ehComigo(List<Double> historico, double setpoint, double ganho);
	
	

}
