package br.ifba.inf011.single.atuador;

public enum TipoAtuador {
	
	RESFRIADOR("br.ifba.inf011.single.atuador.AtuadorResfriadorFactory"),
	ESTABILIZADOR("br.ifba.inf011.single.atuador.AtuadorEstabilizadorFactory");
	
	String className;
	
	private TipoAtuador(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}
	

}
