package br.edu.ifba.inf011.aval1;

import java.util.LinkedList;
import java.util.List;

public class Ementa {
	
	private String codigo;
	private String nome;	
	private List<Disciplina> disciplinas;
	private List<Livro> livros;
	
	
	public Ementa(String codigo, String nome, 
				 List<Disciplina> disciplinas,
				 List<Livro> livros) {
		this.codigo = codigo;
		this.nome = nome;
		this.disciplinas = new LinkedList<Disciplina>(disciplinas);
		this.livros = new LinkedList<Livro>(livros);
	}	
	
	
	
	public String getCodigo() {
		return codigo;
	}



	public String getNome() {
		return nome;
	}



	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}



	public List<Livro> getLivros() {
		return livros;
	}



	public String toString() {
		return "#EMENTA# " + this.nome;
	}	

}