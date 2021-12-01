package br.ifba.inf011.estrut.proxy.server;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Relatorio {
	
	private List<Linha> linhas;
	private double setpoint;
	
	public Relatorio(double setpoint) {
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
		this.linhas.add(new Linha(strDate, this.setpoint, temperatura));
	}
	
	
	

}
