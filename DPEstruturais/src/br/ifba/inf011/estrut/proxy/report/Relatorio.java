package br.ifba.inf011.estrut.proxy.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.ifba.inf011.estrut.proxy.server.DicionarioDescricoesIF;

public class Relatorio {
	
	private DicionarioDescricoesIF geradorSimbolos;
	private List<Linha> linhas;
	private double setpoint;
	
	public Relatorio(DicionarioDescricoesIF geradorSimbolos, double setpoint) {
		this.geradorSimbolos = geradorSimbolos;
		this.linhas = new LinkedList<Linha>();
		this.setpoint = setpoint;
	}
	
	public String conteudo() {
		String valor = "RELATORIO\n";
		for(Linha linha : this.linhas)
			valor = valor + linha.conteudo() + "\n";
		return valor;
	}

	public void addRegistro(Date date, double temperatura) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String strDate = fd.format(date); 
		this.linhas.add(new Linha(this.geradorSimbolos, strDate, this.setpoint, temperatura));
	}
	
	
	

}
