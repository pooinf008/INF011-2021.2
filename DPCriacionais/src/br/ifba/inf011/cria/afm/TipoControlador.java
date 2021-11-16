package br.ifba.inf011.cria.afm;

public enum TipoControlador {
	
	ALTA("br.ifba.inf011.afm.ControladorAltaTemperaturaFactory"), 
	FAIXA("br.ifba.inf011.afm.ControladorFaixaTemperaturaFactory");
	
	String className;
	
	private TipoControlador(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}
	

}
