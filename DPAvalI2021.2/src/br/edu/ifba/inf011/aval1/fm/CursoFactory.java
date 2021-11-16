package br.edu.ifba.inf011.aval1.fm;

import br.edu.ifba.inf011.aval1.Curso;
import br.edu.ifba.inf011.aval1.Produto;

public class CursoFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Curso(codigo, nome);
	}

}
