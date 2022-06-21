package br.edu.ifba.inf011.aval3;

import java.util.Set;

public abstract class ProdutoAssistivel extends Produto{
	
	public ProdutoAssistivel(ProdutoAssistivel produto) {
		super(produto);
	}
	
	public ProdutoAssistivel(String codigo, String nome) {
		super(codigo, nome);
	}
	
	public abstract int getCHCumprida();
	public abstract int getCHTotal();
	public abstract Set<Disciplina> getDisciplinas();
	
	public double getPctCHCumprida() {
		return ((double) this.getCHCumprida())/ this.getCHTotal();
	}
}
