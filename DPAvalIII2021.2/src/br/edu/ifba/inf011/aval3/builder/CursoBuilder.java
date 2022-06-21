package br.edu.ifba.inf011.aval3.builder;

import br.edu.ifba.inf011.aval3.Curso;

public class CursoBuilder extends AbstractCursoBuilder<Curso>{
	
	public static CursoBuilder factory() {
		return new CursoBuilder();
	}
	
	public Curso build() {
		return new Curso(this.codigo, this.nome, this.assistiveis, this.livros);
	}

}
