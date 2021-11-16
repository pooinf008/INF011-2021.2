package br.ifba.inf011.comp.tm;

import java.util.List;

//ABSTRACTCLASS em Template Method
public abstract class AbstractControladorHandler implements ControladorHandler{
	
	protected ControladorHandler proximo;
	
	public AbstractControladorHandler(){
		this.setProximo(null);
	}
	
	public AbstractControladorHandler(ControladorHandler proximo){
		this.setProximo(proximo);
	}	
	
	public boolean hasProximo() {
		return this.proximo != null; 
				
	}

	@Override
	public void setProximo(ControladorHandler proximo) {
		this.proximo = proximo;
	}
	
	@Override
	//TEMPLATEMETHOD em Template Method 
	public double controlar(List<Double> historico, double setpoint, double ganho) {

		if(this.aplicavel(historico, setpoint, ganho))
			return this.valorAtuacao(historico, setpoint, ganho);
		return this.hasProximo() ? 
			   this.proximo.controlar(historico, setpoint, ganho) :
			   0;
	}

	//PRIMITIVEOPERATION em Template Method 
	protected abstract double valorAtuacao(List<Double> historico, double setpoint, double ganho);

	//PRIMITIVEOPERATION em Template Method 
	protected abstract boolean aplicavel(List<Double> historico, double setpoint, double ganho);	
	

}
