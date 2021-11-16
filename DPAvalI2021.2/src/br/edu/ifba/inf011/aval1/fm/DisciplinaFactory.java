package br.edu.ifba.inf011.aval1.fm;

import br.edu.ifba.inf011.aval1.Disciplina;
import br.edu.ifba.inf011.aval1.Produto;

public class DisciplinaFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Disciplina(codigo, nome);
	}

}
