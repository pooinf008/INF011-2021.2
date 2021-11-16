package br.edu.ifba.inf011.aval1;

import br.edu.ifba.inf011.aval1.prototype.Prototipavel;

public class Disciplina extends Produto{
	private int chTotal;
	private double pcCumprido;
	private double preco;

	public Disciplina(Disciplina disciplina) {
		super(disciplina);
		this.chTotal = disciplina.chTotal;
		this.pcCumprido = disciplina.pcCumprido;
		this.preco = disciplina.preco;
	}	
	
	public Disciplina(String codigo, String nome) {
		super(codigo, nome);
	}
	
	public Disciplina(String codigo, String nome, 
					  int chTotal,
					  double pcCumprido, double preco) {
		super(codigo, nome);
		this.chTotal = chTotal;
		this.pcCumprido = pcCumprido;
		this.preco = preco;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}
	
	public String toString() {
		return "#Disciplina#" + super.toString();
	}

	@Override
	public Prototipavel prototipar() {
		return new Disciplina(this);
	}
	
	
	
}
