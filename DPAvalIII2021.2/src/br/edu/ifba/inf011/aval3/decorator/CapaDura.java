package br.edu.ifba.inf011.aval3.decorator;

public class CapaDura extends PrecoDecorator{
	
	public CapaDura(LivroIF livro) {
		super(livro);
	}
	
	@Override
	public double getPreco() {
		return this.livro.getPreco() * 1.2;
	}	
	
	@Override
	public String getNome() {
		return this.livro.getNome() + " Capa Dura";
	}	
	
	
}
