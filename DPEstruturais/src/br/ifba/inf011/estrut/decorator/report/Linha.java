package br.ifba.inf011.estrut.decorator.report;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Linha implements LinhaIF{
	
	public Linha() {

	}
	
	@Override
	public String conteudo(double setpoint, double temperatura) {
		Locale.setDefault(new Locale("pt", "BR"));
		NumberFormat format = new DecimalFormat("00.000");
		return "["+ format.format(temperatura) + "°] ";
	}

}
