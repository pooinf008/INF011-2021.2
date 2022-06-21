package br.edu.ifba.inf011.aval3.builder;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifba.inf011.aval3.Disciplina;
import br.edu.ifba.inf011.aval3.Ementa;
import br.edu.ifba.inf011.aval3.ProdutoAssistivel;

public class EmentaBuilder extends AbstractCursoBuilder<Ementa>{
	
	public static EmentaBuilder factory() {
		return new EmentaBuilder();
	}
	
	public Ementa build() {
		Set<Disciplina> disciplinas = new HashSet<Disciplina>();
		for (ProdutoAssistivel assistivel : this.assistiveis)
			disciplinas.addAll(assistivel.getDisciplinas());
		return new Ementa(this.codigo, this.nome, new HashSet<Disciplina>(disciplinas), 
						  this.livros);
	}

}
