package br.edu.ifba.inf011.aval2.fm;

import java.lang.reflect.InvocationTargetException;

import br.edu.ifba.inf011.aval2.Produto;

public abstract class ProdutoFactory {
	
	public static Produto novoProduto(TipoProduto tipo, String codigo, String nome) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ProdutoFactory factory = 
				(ProdutoFactory) Class.forName(tipo.getFactoryName()).getConstructor().newInstance();
		return factory.createProduto(codigo, nome);
	}

	public abstract  Produto createProduto(String codigo, String nome);
}
