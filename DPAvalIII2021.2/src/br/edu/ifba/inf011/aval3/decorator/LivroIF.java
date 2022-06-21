package br.edu.ifba.inf011.aval3.decorator;

import br.edu.ifba.inf011.aval3.prototype.Prototipavel;

public interface LivroIF extends Prototipavel{

	public void setPreco(double preco);
	public double getPreco();
	public String getIsbn();
	public void setIsbn(String isbn);
	public String getNome();
	public String getCodigo();

}
