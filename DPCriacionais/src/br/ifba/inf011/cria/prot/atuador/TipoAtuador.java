package br.ifba.inf011.cria.prot.atuador;

public enum TipoAtuador {
	
	RESFRIADOR("br.ifba.inf011.prot.atuador.AtuadorResfriadorFactory"),
	ESTABILIZADOR("br.ifba.inf011.prot.atuador.AtuadorEstabilizadorFactory");
	
	String className;
	
	private TipoAtuador(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}
	

}
