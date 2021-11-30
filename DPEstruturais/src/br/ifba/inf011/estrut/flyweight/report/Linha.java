package br.ifba.inf011.estrut.flyweight.report;

public class Linha {
	
	private String hora;
	private Character forma;
	private String cor;
	
	private double setpoint;
	private double valor;
	
	private Linha(String hora, double setpoint, double valor) {
		this.hora = hora;
		this.setpoint = setpoint;
		this.valor = valor;
	}
	
	private boolean getAcima(double setpoint, double valor) {
		return (valor > setpoint);
	}
	
	private boolean getMaior1(double setpoint, double valor) {
		return Math.abs(setpoint - valor) > 0.01; 
	}
	
	private boolean getMaior5(double setpoint, double valor) {
		return Math.abs(setpoint - valor) > 0.05; 
	}	

	public String getForma() {
		if(this.getAcima(this.setpoint, this.valor) && this.getMaior5(this.setpoint, this.valor))
			
			return "^^";
		else
			return "V";
	}
	
	
	public static void main(String[] args) {
		Linha linha = new Linha("00:00", 10, 12);
		System.out.println(linha.getForma());
	}
	
	
	


}
