package br.ifba.inf011.estrut.flyweight.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Relatorio {
	
	private List<Linha> linhas;
	private double setpoint;
	private DeltaTemperaturaFactory factory;
	
	public Relatorio(double setpoint) {
		this.linhas = new LinkedList<Linha>();
		this.setpoint = setpoint;
		this.factory = new DeltaTemperaturaFactory();
	}
	
	public void init() {
		this.linhas.clear();
	}
	
	public String conteudo() {
		String valor = "RELATORIO\n";
		for(Linha linha : this.linhas)
			valor = valor + linha.conteudo() + "\n";
		valor = valor + "Numero de Objetos: " + DeltaTemperatura.numeroObjetos + "\n";
		return valor;
	}

	public void addRegistro(Date date, double temperatura) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String strDate = fd.format(date); 
		this.linhas.add(new Linha(this.factory, strDate, this.setpoint, temperatura));
	}
	
	
	

}
