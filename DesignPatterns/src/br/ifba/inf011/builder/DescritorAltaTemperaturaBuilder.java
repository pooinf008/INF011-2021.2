package br.ifba.inf011.builder;

//CONCRETEBUILDER em um Builder
//CONSTROI Descritor - (Dados de AltaTemperatura)
public class DescritorAltaTemperaturaBuilder implements BuilderIF{

	private DescritorIF descritor;
	private String descritorContent;
	
	public void append(String title, String trecho) {
		this.descritorContent = this.descritorContent + "<h1>" + title + "</h1>\n";
		this.descritorContent = this.descritorContent + "<p>" + trecho + "</p>\n";  
	}	
	
	@Override
	public void reset() {
		this.descritorContent = "";
		this.append("Temperatura", "A temperatura do sensor de alta é 30°");
		
	}

	@Override
	public void setTermometro() {
		this.append("Termometro de Alta Temperatura", "O sensor do controlador de"
				+ " alta temperatura é um sensor de alta temperatura");
		
	}

	@Override
	public void setAtuador() {
		this.append("Resfriador", "O atuador do controlador de"
				+ " alta temperatura é um resfriador simples");
	}

	@Override
	public void setLogger() {
		this.append("Log", "O log padrão do controlador de alta temperatura "
				+ "é a System.err");
	}
	
	public DescritorIF getDescritor() {
		this.descritor = new Descritor(this.descritorContent); 
		return this.descritor;
	}	

}
