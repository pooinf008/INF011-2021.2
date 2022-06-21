package br.edu.ifba.inf011.aval3;

import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.Locale;

import br.edu.ifba.inf011.adapter.Webinar;
import br.edu.ifba.inf011.adapter.WebinarAdapter;
import br.edu.ifba.inf011.aval3.builder.CursoBuilder;
import br.edu.ifba.inf011.aval3.decorator.CapaDura;
import br.edu.ifba.inf011.aval3.decorator.Colorida;
import br.edu.ifba.inf011.aval3.decorator.Digital;
import br.edu.ifba.inf011.aval3.decorator.EdicaoProfessor;
import br.edu.ifba.inf011.aval3.decorator.LivroIF;
import br.edu.ifba.inf011.aval3.fm.ProdutoFactory;
import br.edu.ifba.inf011.aval3.fm.TipoProduto;
import br.edu.ifba.inf011.aval3.state.OperacaoInvalida;

public class AplicacaoIII {
	
	private Disciplina createDisciplina(String codigo, String nome)  throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Disciplina disciplina = (Disciplina) 
				ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
						codigo, nome);
		disciplina.setCHTotal(10);
		disciplina.setPreco(10);
		return disciplina;
		
	}
	
	private Curso makeCurso()  throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{

		Disciplina discFacade = this.createDisciplina("DISC_FACADE", "Fa�ade");
		Disciplina discSOLID = this.createDisciplina("DISC_SOLID", "Principios SOLID");
		Disciplina discFacadeJava = this.createDisciplina("DISC_FACADE_JAVA", "Fa�ade em Java"); 
		Disciplina discFlyweightJava = this.createDisciplina("DISC_FLYWEIGHT_JAVA", "Flyweight em Java"); 
		Disciplina discFacadePython = this.createDisciplina("DISC_FACADE_PYTHON", "Fa�ade em Python"); 
		Disciplina discFlyweightPython = this.createDisciplina("DISC_FLYWEIGHT_PYTHON", "Flyweight em Python");

		Curso cursoEstruturaisJava = CursoBuilder.factory()
				  .reset()
				  .setNome("Padr�es Estruturais em Java")
				  .setCodigo("CURSO_EST_JAVA")
				  .addDisciplina((Disciplina)discFacade.prototipar())
				  .addDisciplina(discFacadeJava)
				  .addDisciplina(discFlyweightJava)
				  .build(); 
				
		Curso cursoEstruturaisPython = CursoBuilder.factory()
				  .reset()
				  .setNome("Padr�es Estruturais em Python")
				  .setCodigo("CURSO_EST_PYTHON")
				  .addDisciplina((Disciplina)discFacade.prototipar())
				  .addDisciplina(discFacadePython)
				  .addDisciplina(discFlyweightPython)
				  .build(); 

		Livro livro = (Livro) ProdutoFactory.novoProduto(TipoProduto.LIVRO,
							  "LIVRO_EST", "Padr�es Estruturais de Software");
		livro.setPreco(10);
		
		Curso curso = CursoBuilder.factory()
								  .reset()
								  .setNome("Padr�es Estruturais")
								  .setCodigo("CURSO_EST")
								  .addDisciplina(discSOLID)
								  .addCurso(cursoEstruturaisJava)
								  .addCurso(cursoEstruturaisPython)
								  .addLivro(livro)
								  .build();
		return curso;
	}
	
	private Curso makeCursoIII()  throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{

		Disciplina discFacade = this.createDisciplina("DISC_FACADE", "Fa�ade");
		Disciplina discSOLID = this.createDisciplina("DISC_SOLID", "Principios SOLID");
		Disciplina discFacadeJava = this.createDisciplina("DISC_FACADE_JAVA", "Fa�ade em Java"); 
		Disciplina discFlyweightJava = this.createDisciplina("DISC_FLYWEIGHT_JAVA", "Flyweight em Java"); 
		Disciplina discFacadePython = this.createDisciplina("DISC_FACADE_PYTHON", "Fa�ade em Python"); 
		Disciplina discFlyweightPython = this.createDisciplina("DISC_FLYWEIGHT_PYTHON", "Flyweight em Python");
		Webinar webinar = new Webinar("WEB_DP", "Design Patterns - Webinar", "Erich Gamma", 10, 120, "http://www.dp.edu.");
		WebinarAdapter webDP = new WebinarAdapter(webinar);

		Curso cursoEstruturaisJava = CursoBuilder.factory()
				  .reset()
				  .setNome("Padr�es Estruturais em Java")
				  .setCodigo("CURSO_EST_JAVA")
				  .addDisciplina((Disciplina)discFacade.prototipar())
				  .addDisciplina(discFacadeJava)
				  .addDisciplina(discFlyweightJava)
				  .build(); 
				
		Curso cursoEstruturaisPython = CursoBuilder.factory()
				  .reset()
				  .setNome("Padr�es Estruturais em Python")
				  .setCodigo("CURSO_EST_PYTHON")
				  .addDisciplina((Disciplina)discFacade.prototipar())
				  .addDisciplina(discFacadePython)
				  .addDisciplina(discFlyweightPython)
				  .build(); 

		Livro livro = (Livro) ProdutoFactory.novoProduto(TipoProduto.LIVRO,
							  "LIVRO_EST", "Padr�es Estruturais de Software");
		livro.setPreco(10);
		
		Curso curso = CursoBuilder.factory()
								  .reset()
								  .setNome("Padr�es Estruturais")
								  .setCodigo("CURSO_EST")
								  .addDisciplina(discSOLID)
								  .addDisciplina(webDP)
								  .addCurso(cursoEstruturaisJava)
								  .addCurso(cursoEstruturaisPython)
								  .addLivro(livro)
								  .build();
		return curso;
	}	
	
	
	
	private String formatPreco(double preco) {
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return format.format(preco);
	}
	
	private void rodarQ1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida { 
		Curso curso = this.makeCurso();
		/* Calculo das disciplinas
		 *  DISC_FACADE - 10,00 
		 *  DISC_FACADE_JAVA - 10,00
		 *  DISC_FLYWEIGHT_JAVA - 10,00
		 *  CURSO_EST_JAVA = (10+10+10) * 0.8 = 24
		 *  
		 *  DISC_FACADE - 10,00 
		 *  DISC_FACADE_PYTHON - 10,00
		 *  DISC_FLYWEIGHT_PYTHON - 10,00
		 *  CURSO_EST_PYTHON = (10+10+10) * 0.8 = 24
		 *
		 *  CURSO_EST_JAVA - 24,00
		 *  CURSO_EST_PYTHON - 24,00
		 *  DISC_SOLID - 10,00 
		 *  LIVRO_EST - 10,00 
		 *  CURSO_EST - (24 + 24 + 10) * 0,8 + 10 * 0,9 = 46,4 + 9 = 55,4
		 */
		System.out.println(curso.getNome() + " - " + this.formatPreco(curso.getPreco()));
		for(Disciplina disciplina : curso.getDisciplinas())
			System.out.println("\t" + disciplina.getNome() + " - " + this.formatPreco(disciplina.getPreco()));
		for(LivroIF livros : curso.getLivros())
			System.out.println("\t" + livros.getNome() + " - " + this.formatPreco(livros.getPreco()));
	}
	
	private void rodarQ2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida { 
		Livro livro = (Livro) ProdutoFactory.novoProduto(TipoProduto.LIVRO,
				  "LIVRO_PP", "Padr�es de Projeto Numa Sentada");
		livro.setPreco(100);
		System.out.println("\t" + livro.getNome() + " - " + this.formatPreco(livro.getPreco()));		
		LivroIF livroCapaDura =  new EdicaoProfessor(new CapaDura((LivroIF)livro.prototipar()));
		System.out.println("\t" + livroCapaDura.getNome() + " - " + this.formatPreco(livroCapaDura.getPreco()));		
		LivroIF livroDigitalColorida =  new EdicaoProfessor(new Colorida(new Digital((LivroIF)livro.prototipar())));
		System.out.println("\t" + livroDigitalColorida.getNome() + " - " + this.formatPreco(livroDigitalColorida.getPreco()));		
	}	
	
	private void rodarQ3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida { 
		Curso curso = this.makeCursoIII();
		System.out.println(curso.getNome() + " - " + this.formatPreco(curso.getPreco()));
		for(Disciplina disciplina : curso.getDisciplinas())
			System.out.println("\t" + disciplina.getNome() + " - " + this.formatPreco(disciplina.getPreco()));
		for(LivroIF livros : curso.getLivros())
			System.out.println("\t" + livros.getNome() + " - " + this.formatPreco(livros.getPreco()));
	}		
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida {
		AplicacaoIII app = new AplicacaoIII();
		System.out.println("QUEST�O I");
		app.rodarQ1();
		System.out.println("QUEST�O II");
		app.rodarQ2();	
		System.out.println("QUEST�O III");
		app.rodarQ3();		
	}
	
	

}
