package br.edu.ifba.inf011.aval1.fm;

import br.edu.ifba.inf011.aval1.Produto;

public abstract class ProdutoFactory {
	
	public static Produto novoProduto(TipoProduto tipo, String codigo, String nome) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ProdutoFactory factory = 
				(ProdutoFactory) (Class.forName(tipo.getFactoryName()).newInstance());
		return factory.createProduto(codigo, nome);
	}

	public abstract  Produto createProduto(String codigo, String nome);
}
