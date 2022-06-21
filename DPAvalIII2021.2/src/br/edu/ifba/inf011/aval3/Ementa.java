package br.edu.ifba.inf011.aval3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Ementa {
	
	private String codigo;
	private String nome;	
	private Set<Disciplina> disciplinas;
	private List<Livro> livros;
	
	
	public Ementa(String codigo, String nome, 
				 Set<Disciplina> disciplinas,
				 List<Livro> livros) {
		this.codigo = codigo;
		this.nome = nome;
		this.disciplinas = new HashSet<Disciplina>(disciplinas);
		this.livros = new LinkedList<Livro>(livros);
	}	
	
	
	
	public String getCodigo() {
		return codigo;
	}



	public String getNome() {
		return nome;
	}


	public List<Livro> getLivros() {
		return livros;
	}

	public Set<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}	
	

	public String toString() {
		String ementa =  "[Ementa]" + this.getNome() + "\n";
			   ementa += this.getCodigo() + "\n";
			   for(Disciplina disciplina : this.getDisciplinas())	
				   ementa = ementa + "\t" + disciplina.getCodigo() + " - " + 
						   	disciplina.getNome() + " - CH: " + disciplina.getCHTotal() + "\n";
			   return ementa;
	}		

}