package br.ifba.inf011.estrut.decorator.report;

public abstract class LinhaDecorator implements LinhaIF{
	
	protected LinhaIF decorado;
	
	public LinhaDecorator(LinhaIF decorado) {
		this.decorado = decorado;
	}

	@Override
	public String conteudo(double setpoint, double temperatura) {
		return this.decorado.conteudo(setpoint, temperatura);
	}

}
