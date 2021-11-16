package br.ifba.inf011.cria.builder;

//PRODUCT em um Builder
public class Descritor implements DescritorIF {

	private String conteudo;

	public Descritor(String conteudo) {
		this.conteudo = conteudo;
	}	
	
	
	@Override
	public String getConteudo() {
		return this.conteudo;
	}

}
