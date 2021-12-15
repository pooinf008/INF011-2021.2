package br.edu.ifba.inf011.aval2.fm;

import br.edu.ifba.inf011.aval2.Curso;
import br.edu.ifba.inf011.aval2.Produto;

public class CursoFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Curso(codigo, nome);
	}

}
