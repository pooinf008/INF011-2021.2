package br.ifba.inf011.estrut.decorator.report;

import java.util.LinkedList;
import java.util.List;


//CLIENT em um Decorator
public class Relatorio {
	
	private List<String> linhas;
	private double setpoint;
	
	public Relatorio(double setpoint) {
		this.linhas = new LinkedList<String>();
		this.setpoint = setpoint;
	}
	
	public String conteudo() {
		String valor = "RELATORIO\n";
		for(String linha : this.linhas)
			valor = valor + linha + "\n";
		return valor;
	}

	public void addRegistro(double temperatura) {
		LinhaIF linha = new CampoDescricao(new CampoSimbolo(new CampoId(new Linha())));
//		LinhaIF linha = new CampoDescricao(new CampoSimbolo(new CampoHora(new CampoId(new Linha()))));
		this.linhas.add(linha.conteudo(this.setpoint, temperatura));
	}
	
	public static void main(String[] args) {
//		LinhaIF linha = new CampoDescricao(new CampoSimbolo(new CampoHora(new CampoId(new Linha()))));
		LinhaIF linha = new CampoSimbolo(new CampoId(new Linha()));
		System.out.println(linha.conteudo(10, 10));
	}
	
	
	
	

}
