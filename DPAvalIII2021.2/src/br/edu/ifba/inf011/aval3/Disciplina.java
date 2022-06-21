package br.edu.ifba.inf011.aval3;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifba.inf011.aval3.prototype.Prototipavel;

public class Disciplina extends ProdutoAssistivel{
	
	private int chTotal;
	private int chCumprida;
	private double preco;

	public Disciplina(Disciplina disciplina) {
		super(disciplina);
		this.chTotal = disciplina.chTotal;
		this.chCumprida = disciplina.chCumprida;
		this.preco = disciplina.preco;
	}	
	
	public Disciplina(String codigo, String nome) {
		super(codigo, nome);
		this.chCumprida = 0;
	}
	
	public Disciplina(String codigo, String nome, 
					  int chTotal,
					  int chCumprida, double preco) {
		super(codigo, nome);
		this.chTotal = chTotal;
		this.chCumprida = chCumprida;
		this.preco = preco;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}	

	@Override
	public Prototipavel prototipar() {
		return new Disciplina(this);
	}
	
	public void avancar(int ch) {
		if(ch < 0)	return;
		this.chCumprida += ch;
		if(this.chCumprida > this.chTotal)
			this.chCumprida = this.chTotal;
	}
	
	public int getCHTotal() {
		return this.chTotal;
	}
	
	public int getCHCumprida() {
		return this.chCumprida;
	}

	public void setCHTotal(int chTotal) {
		this.chTotal = chTotal;
	}
	
	public String toString() {
		return "[Disciplina] "  + this.getCodigo() + "-" + this.getNome() + 
				" CH Total: " + this.getCHTotal() + " / CH Cumprida :" + 
				this.getCHCumprida(); 
	}

	@Override
	public Set<Disciplina> getDisciplinas() {
		HashSet<Disciplina> setDisciplinas = new HashSet<Disciplina>();
		setDisciplinas.add(this);
		return setDisciplinas;
	}
	
	
}
