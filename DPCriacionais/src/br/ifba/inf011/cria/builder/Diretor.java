package br.ifba.inf011.cria.builder;


//DIRECTOR em um Builder
public class Diretor{
	
	private BuilderIF builder;
	
	public Diretor(BuilderIF builder) {
		this.builder = builder;
	}
	
	public void construir() {
		this.builder.reset();
		this.builder.setLogger();
		this.builder.setTermometro();
		this.builder.setAtuador();
	}

}
