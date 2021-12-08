package br.ifba.inf011.estrut.flyweight.report;

//CONCRETEFLYWEIGHT em Flyweight
public class DeltaTemperatura implements DeltaTemperaturaFlyweight{
	
	public static int numeroObjetos = 0;
	
	private String simbolo;
	
	private DeltaTemperatura(String simbolo) {
		this.simbolo = simbolo;
	}
	
	public String getSimbolo() {
		return this.simbolo;
	}
	
	@Override
	public String conteudo(String hora) {
		return "[" + hora + "] " + this.getSimbolo();
	}		
	
	private static boolean getAcima(double setpoint, double valor) {
		return (valor > setpoint);
	}
	
	private static boolean getAbaixo(double setpoint, double valor) {
		return (valor < setpoint);
	}	
	
	private static boolean getMaior1(double setpoint, double valor) {
		return Math.abs(setpoint - valor) > 0.01; 
	}
	
	private static boolean getMaior5(double setpoint, double valor) {
		return Math.abs(setpoint - valor) > 0.05; 
	}	

	public static DeltaTemperatura gerarCategoria(double setpoint, double valor) {
		DeltaTemperatura.numeroObjetos++;
		return new DeltaTemperatura(DeltaTemperatura.gerarSimbolo(setpoint, valor));
	}
	
	public static String gerarSimbolo(double setpoint, double valor) {
		if(DeltaTemperatura.getAcima(setpoint, valor) && DeltaTemperatura.getMaior5(setpoint, valor))
			return new String("^5");
		else if(DeltaTemperatura.getAcima(setpoint, valor) && DeltaTemperatura.getMaior1(setpoint, valor))
			return new String("^1");
		else if(DeltaTemperatura.getAbaixo(setpoint, valor) && DeltaTemperatura.getMaior5(setpoint, valor))
			return new String("v5");
		else if(DeltaTemperatura.getAbaixo(setpoint, valor) && DeltaTemperatura.getMaior1(setpoint, valor))
			return new String("v1");			
		else
			return new String("<>");
	}


	 
	
}
