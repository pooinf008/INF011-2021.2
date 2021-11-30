package br.ifba.inf011.estrut.flyweight.report;

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
	
	public void init() {
		this.linhas.clear();
	}
	
	public void content() {
		
	}

	public void addRegistro(Date date, double temperatura) {
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String strDate = fd.format(date); 
		this.linhas.add(new Linha(strDate, this.setpoint, temperatura));
	}
	
	

}
