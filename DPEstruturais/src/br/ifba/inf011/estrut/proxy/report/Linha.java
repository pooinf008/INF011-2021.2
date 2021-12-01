package br.ifba.inf011.estrut.proxy.report;

import br.ifba.inf011.estrut.proxy.report.DeltaTemperatura;
import br.ifba.inf011.estrut.proxy.server.ClientDicionarioDescricoes;
import br.ifba.inf011.estrut.proxy.server.DicionarioDescricoesIF;

public class Linha {
	
	private String hora;
	private DeltaTemperatura deltaTemperatura;
	private String descricao;

	public Linha(DicionarioDescricoesIF geradorSimbolo, String hora, double setpoint, double valor) {
		this.hora = hora;
		this.deltaTemperatura = DeltaTemperatura.gerarCategoria(setpoint, valor);
		this.descricao = geradorSimbolo.buscarDescricao(this.deltaTemperatura.getSimbolo());
	}
	
	public String conteudo() {
		return "[" + this.hora + "] " + this.deltaTemperatura.getSimbolo() + " - " + this.descricao; 
	}

	public static void main(String[] args) {
		ClientDicionarioDescricoes cliente = new ClientDicionarioDescricoes();
		Linha linha = new Linha(cliente, "00:00", 10, 10.011);
		System.out.println(linha.conteudo());

	}


	
	
	


}
