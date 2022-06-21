package br.edu.ifba.inf011.aval3.decorator;

public class Digital extends PrecoDecorator{
	
	public Digital(LivroIF livro) {
		super(livro);
	}
	
	@Override
	public double getPreco() {
		return this.livro.getPreco() * 0.85;
	}	
	
	@Override
	public String getNome() {
		return this.livro.getNome() + " Versão Digital";
	}	
}
