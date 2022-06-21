package br.edu.ifba.inf011.aval3.decorator;

import br.edu.ifba.inf011.aval3.prototype.Prototipavel;

public class PrecoDecorator implements LivroIF{

	protected LivroIF livro;

	public PrecoDecorator(LivroIF livro) {
		this.livro = livro;
	}
	
	@Override
	public double getPreco() {
		return this.livro.getPreco();
	}

	@Override
	public void setPreco(double preco) {
		this.livro.setPreco(preco);
	}

	@Override
	public String getIsbn() {
		return this.livro.getIsbn();
	}

	@Override
	public void setIsbn(String isbn) {
		this.livro.setIsbn(isbn);
	}

	@Override
	public String getNome() {
		return this.livro.getNome();
	}

	@Override
	public String getCodigo() {
		return this.livro.getCodigo();
	}

	@Override
	public Prototipavel prototipar() {
		return livro.prototipar();
	}
	
}
