package br.edu.ifba.inf011.aval2;

import java.util.Objects;

import br.edu.ifba.inf011.aval2.prototype.Prototipavel;

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

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	

}
