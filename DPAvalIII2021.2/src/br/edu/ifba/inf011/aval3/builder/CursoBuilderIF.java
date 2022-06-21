package br.edu.ifba.inf011.aval3.builder;

import br.edu.ifba.inf011.aval3.Curso;
import br.edu.ifba.inf011.aval3.Disciplina;
import br.edu.ifba.inf011.aval3.Livro;
import br.edu.ifba.inf011.aval3.ProdutoAssistivel;

public interface CursoBuilderIF<T> {
	public CursoBuilderIF<T> reset();
	public CursoBuilderIF<T> setNome(String nome);
	public CursoBuilderIF<T> setCodigo(String codigo);
	public CursoBuilderIF<T> addDisciplina(Disciplina disciplina);
	public CursoBuilderIF<T> addCurso(Curso curso);
	public CursoBuilderIF<T> addCursavel(ProdutoAssistivel assistivel);
	public CursoBuilderIF<T> addLivro(Livro livro);
	public T build();
}
