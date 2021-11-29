package br.ifba.inf011.estrut.flyweight.report;

public enum DeltaTemperatura {
	ACIMA_MAIOR5("^5"), ACIMA_MAIOR1("^1"), ABAIXO_MAIOR5("v5"), ABAIXO_MAIOR1("v1"), FAIXA("<>"); 
	
	String simbolo;
	
	private DeltaTemperatura(String simbolo) {
		this.simbolo = simbolo;
	}
	
	public String getSimbolo() {
		return this.simbolo;
	}
	 
	
}
