package br.edu.ifba.inf011.aval2.fm;

import br.edu.ifba.inf011.aval2.Disciplina;
import br.edu.ifba.inf011.aval2.Produto;

public class DisciplinaFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Disciplina(codigo, nome);
	}

}
