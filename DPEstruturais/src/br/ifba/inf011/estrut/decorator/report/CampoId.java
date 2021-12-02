package br.ifba.inf011.estrut.decorator.report;

public class CampoId extends LinhaDecorator{
	
	private static int numero = 0;
	
	public CampoId(LinhaIF decorado) {
		super(decorado);
	}
	
	public String conteudo(double setpoint, double temperatura) {
		int numero = CampoId.numero++;
		return decorado.conteudo(setpoint, temperatura) + Integer.toString(numero) + " ";
	}	

}
