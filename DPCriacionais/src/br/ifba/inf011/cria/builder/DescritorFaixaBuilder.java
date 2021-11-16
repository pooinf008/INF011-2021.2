package br.ifba.inf011.cria.builder;

//CONCRETEBUILDER em um Builder
//CONSTROI Descritor - (Dados de Faixa)
public class DescritorFaixaBuilder implements BuilderIF{

	private DescritorIF descritor;
	private String descritorContent;
	
	public void append(String title, String trecho) {
		this.descritorContent = this.descritorContent + "<h1>" + title + "</h1>\n";
		this.descritorContent = this.descritorContent + "<p>" + trecho + "</p>\n";  
	}	
	
	@Override
	public void reset() {
		this.descritorContent = "";
		this.append("Temperatura", "A Faixa de temperatura do sensor de faixa é de 26° a 30°");
		
	}

	@Override
	public void setTermometro() {
		this.append("Termometro de Faixa", "O sensor do controlador de"
				+ " faixa é um sensor de faixa de temperatura");
	}

	@Override
	public void setAtuador() {
		this.append("Estabilizador", "O atuador do controlador de"
				+ " alta temperatura é um estabilizador");
	}

	@Override
	public void setLogger() {
		this.append("Log", "O log padrão do controlador de faixa "
				+ "é a System.err");
	}
	
	public DescritorIF getDescritor() {
		this.descritor = new Descritor(this.descritorContent); 
		return this.descritor;
	}	

}
