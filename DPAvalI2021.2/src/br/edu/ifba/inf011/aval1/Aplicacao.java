package br.edu.ifba.inf011.aval1;

import java.lang.reflect.InvocationTargetException;

import br.edu.ifba.inf011.aval1.builder.CursoBuilder;
import br.edu.ifba.inf011.aval1.builder.EmentaBuilder;
import br.edu.ifba.inf011.aval1.fm.ProdutoFactory;
import br.edu.ifba.inf011.aval1.fm.TipoProduto;
import br.edu.ifba.inf011.aval1.prototype.CatalogoCursos;

public class Aplicacao {
	
	private void rodarQ1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Produto prod01 = ProdutoFactory.novoProduto(TipoProduto.LIVRO,
												   "BOOK_CRIA01", 
												   "Factory Method");
		System.out.println(prod01);
		
		Produto prod02 = ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
				   									"DISC_CRIA01", 
				   									"Factory Method");
		System.out.println(prod02);

		Produto prod03 = ProdutoFactory.novoProduto(TipoProduto.CURSO,
													"CURSO_CRIA01", 
													"Factory Method");
		System.out.println(prod03);
	}
	
	private void rodarQ2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Produto prod01 = ProdutoFactory.novoProduto(TipoProduto.LIVRO,
												   "BOOK_CRIA01", 
												   "Factory Method");
		Produto prod02 = ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
				   									"DISC_CRIA01", 
				   									"Factory Method");
		Produto prod03 = ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
													"DISC_CRIA02", 
													"Builder");
		
		Curso curso = CursoBuilder.factory()
								  .reset()
								  .addDisciplina((Disciplina)prod03)
								  .addLivro((Livro)prod01)
								  .setNome("Padrões Criacionais")
								  .setCodigo("CURSO_CRIALL")
								  .addDisciplina((Disciplina)prod02)
								  .build();
		
		System.out.println(curso);
		
		Ementa ementa = EmentaBuilder.factory()
				  					 .reset()
				  					 .addDisciplina((Disciplina)prod03)
				  					 .addLivro((Livro)prod01)
				  					 .setNome("Padrões Criacionais")
				  					 .setCodigo("CURSO_CRIALL")
				  					 .addDisciplina((Disciplina)prod02)
				  					 .build();
		
		System.out.println(ementa);		
		
	}
	
	private void rodarQ3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Produto prod01 = ProdutoFactory.novoProduto(TipoProduto.LIVRO,
												   "BOOK_CRIA01", 
												   "Factory Method");
		Produto prod02 = ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
				   									"DISC_CRIA01", 
				   									"Factory Method");
		Produto prod03 = ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
													"DISC_CRIA02", 
													"Builder");
		
		Curso curso = CursoBuilder.factory()
								  .reset()
								  .addDisciplina((Disciplina)prod03)
								  .addLivro((Livro)prod01)
								  .setNome("Padrões Criacionais")
								  .setCodigo("CURSO_CRIALL")
								  .addDisciplina((Disciplina)prod02)
								  .build();
		
		CatalogoCursos.getCatalogo().registrar(curso);
		Curso cursoA = CatalogoCursos.getCatalogo().recuperar("CURSO_CRIALL");
		Curso cursoB = CatalogoCursos.getCatalogo().recuperar("CURSO_CRIALL");
		
		
		System.out.println(cursoA);
		cursoA.setNome("MUDEI A");
		System.out.println(cursoA);
		System.out.println(cursoB);
		
	}	
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Aplicacao app = new Aplicacao();
		app.rodarQ1();
		app.rodarQ2();
		app.rodarQ3();
	}


}
