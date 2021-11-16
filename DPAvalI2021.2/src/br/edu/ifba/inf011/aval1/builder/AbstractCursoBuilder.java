package br.edu.ifba.inf011.aval1.builder;

import java.util.LinkedList;
import java.util.List;

import br.edu.ifba.inf011.aval1.Disciplina;
import br.edu.ifba.inf011.aval1.Livro;

public abstract class AbstractCursoBuilder<T> implements CursoBuilderIF<T>{

	protected String codigo;
	protected String nome;
	protected List<Disciplina> disciplinas;
	protected List<Livro> livros;	
	
	
	public AbstractCursoBuilder() {
		this.reset();
	}
	
	@Override
	public CursoBuilderIF<T> reset() {
		this.codigo = "";
		this.nome = "";
		this.disciplinas= new LinkedList<Disciplina>();
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
		this.disciplinas.add(disciplina);
		return this;
	}

	@Override
	public CursoBuilderIF<T> addLivro(Livro livro) {
		this.livros.add(livro);
		return this;
	}

}
