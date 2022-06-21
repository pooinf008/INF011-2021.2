package br.edu.ifba.inf011.aval3.decorator;

public class Colorida extends PrecoDecorator{
	
	public Colorida(LivroIF livro) {
		super(livro);
	}
	
	@Override
	public double getPreco() {
		return this.livro.getPreco() * 1.05;
	}	
	
	@Override
	public String getNome() {
		return this.livro.getNome() + " Edição à Cores";
	}	
}
