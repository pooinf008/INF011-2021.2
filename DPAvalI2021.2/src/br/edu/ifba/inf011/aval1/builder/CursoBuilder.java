package br.edu.ifba.inf011.aval1.builder;

import br.edu.ifba.inf011.aval1.Curso;

public class CursoBuilder extends AbstractCursoBuilder<Curso>{
	
	public static CursoBuilder factory() {
		return new CursoBuilder();
	}
	
	public Curso build() {
		return new Curso(this.codigo, this.nome, this.disciplinas, this.livros);
	}

}
