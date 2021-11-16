package br.edu.ifba.inf011.aval1;

import java.util.LinkedList;
import java.util.List;

import br.edu.ifba.inf011.aval1.prototype.Prototipavel;

public class Curso extends Produto{
	
	private List<Disciplina> disciplinas;
	private List<Livro> livros;
	
	private Curso(Curso curso) {
		super(curso);
		this.disciplinas = new LinkedList<Disciplina>();
		for(Disciplina d : curso.disciplinas)
			this.disciplinas.add((Disciplina)d.prototipar());
		this.livros = new LinkedList<Livro>();
		for(Livro l : curso.livros)
			this.livros.add((Livro)l.prototipar());
	}
	
	public Curso(String codigo, String nome) {
		super(codigo, nome);
		this.disciplinas = new LinkedList<Disciplina>();
		this.livros = new LinkedList<Livro>();
	}
	
	public Curso(String codigo, String nome, 
				 List<Disciplina> disciplinas,
				 List<Livro> livros) {
		super(codigo, nome);
		this.disciplinas = new LinkedList<Disciplina>(disciplinas);
		this.livros = new LinkedList<Livro>(livros);
	}	
	
	@Override
	public double getPreco() {
		return 0;
	}
	
	public String toString() {
		return "#Curso#" + super.toString();
	}

	@Override
	public Prototipavel prototipar() {
		return new Curso(this);
	}	

}
