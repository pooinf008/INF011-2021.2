package br.ifba.inf011.estrut.decorator.report;


public class CampoDescricao extends LinhaDecorator{
	
	public CampoDescricao(LinhaIF decorado) {
		super(decorado);
	}
	
	public String conteudo(double setpoint, double temperatura) {
		DeltaTemperatura deltaTemperatura = new DeltaTemperatura(setpoint, temperatura);
		return this.decorado.conteudo(setpoint, temperatura) + " " + this.gerarDescricao(deltaTemperatura.getSimbolo());
	};
	
	private String gerarDescricao(String descricao) {
		if(descricao.contentEquals("^5"))
			return new String("Temperatura Ambiente mais que 5% Acima do SetPoint");
		else if(descricao.contentEquals("^1"))
			return new String("Temperatura Ambiente mais que 1% Acima do SetPoint");
		else if(descricao.contentEquals("v5"))
			return new String("Temperatura Ambiente menos que 5% Abaixo do SetPoint");
		else if(descricao.contentEquals("v1"))
			return new String("Temperatura Ambiente menos que 1% Abaixo do SetPoint");			
		else
			return new String("Temperatura Ambiente dentro dos padrões estabelecidos");
	}		
	
}
