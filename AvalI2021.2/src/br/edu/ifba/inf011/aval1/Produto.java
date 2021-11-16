package br.edu.ifba.inf011.aval1;

public abstract class Produto {
	
	private String codigo;
	private String nome;
	
	public Produto(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}
	
	public abstract double getPreco();

}
