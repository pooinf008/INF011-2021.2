package br.edu.ifba.inf011.aval3.fm;

import br.edu.ifba.inf011.aval3.Livro;
import br.edu.ifba.inf011.aval3.Produto;

public class LivroFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Livro(codigo, nome);
	}

}
