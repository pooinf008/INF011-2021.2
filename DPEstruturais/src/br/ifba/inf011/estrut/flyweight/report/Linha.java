package br.ifba.inf011.estrut.flyweight.report;

//CLIENT em Flyweight
public class Linha{
	
	private DeltaTemperatura categoria;
	private String hora;

	public Linha(DeltaTemperaturaFactory factory,
				String hora, double setpoint, double valor) {
		this.categoria = factory.getDeltaTemperatura(setpoint, valor);
		this.hora = hora;
		
	}
	
	public String conteudo() {
		return this.categoria.conteudo(hora); 
	}
	
}
