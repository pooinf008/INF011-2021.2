package br.edu.ifba.inf011.aval2;

import br.edu.ifba.inf011.aval2.prototype.Prototipavel;

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
		this.pcCumprido = 0;
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

	@Override
	public Prototipavel prototipar() {
		return new Disciplina(this);
	}
	
	public void avancar(double pct) {
		if(pct < 0)	return;
		this.pcCumprido += pct;
		if(this.pcCumprido > 1)
			this.pcCumprido = 1;
	}
	
	public int getCHTotal() {
		return this.chTotal;
	}
	
	public double getCHCumprida() {
		return this.getCHTotal() * this.getPctCumprido();
	}

	public double getPctCumprido() {
		return this.pcCumprido;
	}

	public void setCHTotal(int chTotal) {
		this.chTotal = chTotal;
	}
	
	public String toString() {
		return "[Disciplina] "  + this.getCodigo() + "-" + this.getNome() + 
				"CH Total: " + this.getCHTotal() + " / CH Cumprida :" + 
				this.getCHCumprida(); 
	}
	
	
}
