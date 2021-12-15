package br.edu.ifba.inf011.aval2.fm;

import br.edu.ifba.inf011.aval2.Livro;
import br.edu.ifba.inf011.aval2.Produto;

public class LivroFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Livro(codigo, nome);
	}

}
