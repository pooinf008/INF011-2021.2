package br.ifba.inf011.estrut.noflyweight.report;

public class Linha {
	
	private String hora;
	private DeltaTemperatura categoria;

	public Linha(String hora, double setpoint, double valor) {
		this.hora = hora;
		this.categoria = DeltaTemperatura.gerarCategoria(setpoint, valor);
	}
	
	public String conteudo() {
		return "[" + this.hora + "] " + this.getCategoria().getSimbolo(); 
	}
	
	public DeltaTemperatura getCategoria() {
		return this.categoria;
	}

	public static void main(String[] args) {
		Linha linha = new Linha("00:00", 10, 10.011);
		System.out.println(linha.conteudo());

	}


	
	
	


}
