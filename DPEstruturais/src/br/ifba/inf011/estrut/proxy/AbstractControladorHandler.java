package br.ifba.inf011.estrut.proxy;

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
	

}
