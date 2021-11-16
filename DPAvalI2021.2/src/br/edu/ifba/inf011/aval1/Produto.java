package br.edu.ifba.inf011.aval1;

import br.edu.ifba.inf011.aval1.prototype.Prototipavel;

public abstract class Produto implements Prototipavel{
	
	private String codigo;
	private String nome;
	
	public Produto(Produto produto) {
		this.codigo = produto.codigo;
		this.nome = produto.nome;
	}
	
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
	
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public abstract double getPreco();
	
	public String toString() {
		return "[" + this.getCodigo() + "] - " + this.getNome(); 
	}

}
