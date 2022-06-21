package br.edu.ifba.inf011.aval3.decorator;

public class EdicaoProfessor extends PrecoDecorator{
	
	public EdicaoProfessor(LivroIF livro) {
		super(livro);
	}
	
	@Override
	public double getPreco() {
		return this.livro.getPreco() * 0.5;
	}	
	
	@Override
	public String getNome() {
		return this.livro.getNome() + " - Edição do Professor";
	}
}
