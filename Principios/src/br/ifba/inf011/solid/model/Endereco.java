package br.ifba.inf011.solid.model;

public class Endereco {
	private String rua;
	private String numero;
	private String cep;
	
	public Endereco(String rua, String numero, String cep) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}
	
	public Endereco() {
		super();
	}
	
	public String getRua() {
		return rua;
	}
	public String getNumero() {
		return numero;
	}
	public String getCep() {
		return cep;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	
	
	
}
