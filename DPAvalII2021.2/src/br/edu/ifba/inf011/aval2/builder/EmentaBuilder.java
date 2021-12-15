package br.edu.ifba.inf011.aval2.builder;

import br.edu.ifba.inf011.aval2.Ementa;

public class EmentaBuilder extends AbstractCursoBuilder<Ementa>{
	
	public static EmentaBuilder factory() {
		return new EmentaBuilder();
	}
	
	public Ementa build() {
		return new Ementa(this.codigo, this.nome, this.disciplinas, this.livros);
	}

}
