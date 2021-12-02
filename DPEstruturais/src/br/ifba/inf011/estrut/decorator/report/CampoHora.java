package br.ifba.inf011.estrut.decorator.report;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CampoHora extends LinhaDecorator{

	public CampoHora(LinhaIF decorado) {
		super(decorado);
	}
	
	public String conteudo(double setpoint, double temperatura) {
		Date date = new Date();
		SimpleDateFormat fd = new SimpleDateFormat("hh:mm:ss:SSSS");
		String strDate = fd.format(date); 
		return this.decorado.conteudo(setpoint, temperatura) + " " + strDate;
	}
	
	
	
	

}
