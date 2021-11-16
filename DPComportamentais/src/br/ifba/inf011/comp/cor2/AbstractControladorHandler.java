package br.ifba.inf011.comp.cor2;

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
	

}
