package br.edu.ifba.inf011.aval1.fm;

public enum TipoProduto {
	
	LIVRO("br.edu.ifba.inf011.aval1.fm.LivroFactory"),
	DISCIPLINA("br.edu.ifba.inf011.aval1.fm.DisciplinaFactory"),
	CURSO("br.edu.ifba.inf011.aval1.fm.CursoFactory");
	
	String className;
	
	private TipoProduto(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}	
	

}
