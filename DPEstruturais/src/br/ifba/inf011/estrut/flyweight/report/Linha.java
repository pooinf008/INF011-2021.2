package br.ifba.inf011.estrut.flyweight.report;

public class Linha {
	
	private String hora;
	private DeltaTemperatura categoria;

	public Linha(String hora, double setpoint, double valor) {
		this.hora = hora;
		this.categoria = this.getDeltaTemperatura(setpoint, valor);
	}
	
	private boolean getAcima(double setpoint, double valor) {
		return (valor > setpoint);
	}
	
	private boolean getAbaixo(double setpoint, double valor) {
		return (valor < setpoint);
	}	
	
	private boolean getMaior1(double setpoint, double valor) {
		return Math.abs(setpoint - valor) > 0.01; 
	}
	
	private boolean getMaior5(double setpoint, double valor) {
		return Math.abs(setpoint - valor) > 0.05; 
	}	

	private DeltaTemperatura getDeltaTemperatura(double setpoint, double valor) {
		if(this.getAcima(setpoint, valor) && this.getMaior5(setpoint, valor))
			return DeltaTemperatura.ACIMA_MAIOR5;
		else if(this.getAcima(setpoint, valor) && this.getMaior1(setpoint, valor))
			return DeltaTemperatura.ACIMA_MAIOR1;
		else if(this.getAbaixo(setpoint, valor) && this.getMaior5(setpoint, valor))
			return DeltaTemperatura.ABAIXO_MAIOR5;
		else if(this.getAbaixo(setpoint, valor) && this.getMaior1(setpoint, valor))
			return DeltaTemperatura.ABAIXO_MAIOR1;
		else
			return DeltaTemperatura.FAIXA;
	}
	
	public String getCategoria() {
		return this.categoria.getSimbolo();
	}
	
	public String toString() {
		return "[" + this.hora + "] " + this.getCategoria(); 
	}
	
	public static void main(String[] args) {
		Linha linha = new Linha("00:00", 10, 10.011);
		System.out.println(linha);

	}
	
	
	


}
