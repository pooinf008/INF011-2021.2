package br.edu.ifba.inf011.aval3.builder;

import java.util.LinkedList;
import java.util.List;

import br.edu.ifba.inf011.aval3.Curso;
import br.edu.ifba.inf011.aval3.Disciplina;
import br.edu.ifba.inf011.aval3.Livro;
import br.edu.ifba.inf011.aval3.ProdutoAssistivel;

public abstract class AbstractCursoBuilder<T> implements CursoBuilderIF<T>{

	protected String codigo;
	protected String nome;
	protected List<ProdutoAssistivel> assistiveis;
	protected List<Livro> livros;	
	
	
	public AbstractCursoBuilder() {
		this.reset();
	}
	
	@Override
	public CursoBuilderIF<T> reset() {
		this.codigo = "";
		this.nome = "";
		this.assistiveis= new LinkedList<ProdutoAssistivel>();
		this.livros= new LinkedList<Livro>();
		return this;
	}

	@Override
	public CursoBuilderIF<T> setNome(String nome) {
		this.nome = nome;
		return this;
	}

	@Override
	public CursoBuilderIF<T> setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	@Override
	public CursoBuilderIF<T> addDisciplina(Disciplina disciplina) {
		this.assistiveis.add(disciplina);
		return this;
	}
	
	@Override
	public CursoBuilderIF<T> addCurso(Curso curso) {
		this.assistiveis.add(curso);
		return this;
	}	
	
	@Override
	public CursoBuilderIF<T> addCursavel(ProdutoAssistivel assistivel) {
		this.assistiveis.add(assistivel);
		return this;
	}		

	@Override
	public CursoBuilderIF<T> addLivro(Livro livro) {
		this.livros.add(livro);
		return this;
	}

}
