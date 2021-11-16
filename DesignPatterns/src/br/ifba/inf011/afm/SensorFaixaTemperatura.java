package br.ifba.inf011.afm;

//CONCRETEPRODUCT em um Abstract Factory
public class SensorFaixaTemperatura implements SensorIF{
	
	private double temperaturaAltaLimite;
	private double temperaturaBaixaLimite;
	private double temperaturaAtual;
	
	public SensorFaixaTemperatura(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		this.ajuste(temperaturaBaixaLimite, temperaturaAltaLimite);
	}
	
	private void alarmar(boolean alta) {
		if(alta)
			System.out.println("[Sensor Temperatura] : " + this.temperaturaAtual + "°: [ALARME DE ALTA DE TEMPERATURA]");
		else
			System.out.println("[Sensor Temperatura] : " + this.temperaturaAtual + "°: [ALARME DE BAIXA DE TEMPERATURA]");
		
	}
	
	public void medir(double temperatura) {
		this.temperaturaAtual = temperatura;
		if(temperatura > this.getTemperaturaAltaLimite())
			this.alarmar(true);
		else if(temperatura < this.getTemperaturaBaixaLimite())
			this.alarmar(false);
		else
			System.out.println("[Sensor Temperatura] : " + this.temperaturaAtual + "°");
	}

	public double getTemperaturaAltaLimite() {
		return temperaturaAltaLimite;
	}
	
	public double getTemperaturaBaixaLimite() {
		return temperaturaBaixaLimite;
	}
	

	private void setTemperaturaAltaLimite(double temperaturaLimite) {
		this.temperaturaAltaLimite = temperaturaLimite;
	}
	
	private void setTemperaturaBaixaLimite(double temperaturaLimite) {
		this.temperaturaBaixaLimite = temperaturaLimite;
	}
	


	public void ajuste(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		this.setTemperaturaAltaLimite(temperaturaAltaLimite);
		this.setTemperaturaBaixaLimite(temperaturaBaixaLimite);
	}

}
