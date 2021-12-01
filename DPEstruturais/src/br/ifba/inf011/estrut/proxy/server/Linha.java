package br.ifba.inf011.estrut.proxy.server;

public class Linha {
	
	private String hora;
	private GeraSimboloIF categoria;
	private double setpoint; 
	private double valor;

	public Linha(String hora, double setpoint, double valor) {
		this.hora = hora;
		this.setpoint = setpoint;
		this.valor = valor;
		this.categoria = new ClientServicoSimbolos();
	}
	
	public String conteudo() {
		return "[" + this.hora + "] " + this.categoria.gerarSimbolo(this.setpoint, this.valor); 
	}

	public static void main(String[] args) {
		Linha linha = new Linha("00:00", 10, 10.011);
		System.out.println(linha.conteudo());

	}


	
	
	


}
