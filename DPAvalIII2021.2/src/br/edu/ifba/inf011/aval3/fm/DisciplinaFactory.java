package br.edu.ifba.inf011.aval3.fm;

import br.edu.ifba.inf011.aval3.Disciplina;
import br.edu.ifba.inf011.aval3.Produto;

public class DisciplinaFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Disciplina(codigo, nome);
	}

}
