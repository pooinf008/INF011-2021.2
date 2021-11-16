package br.ifba.inf011.builder;

public enum TipoAtuador {
	
	RESFRIADOR("br.ifba.inf011.afm.pre.ResfriadorFactory"),
	ESTABILIZADOR("br.ifba.inf011.afm.pre.EstabilizadorFactory");
	
	String className;
	
	private TipoAtuador(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}
	

}
