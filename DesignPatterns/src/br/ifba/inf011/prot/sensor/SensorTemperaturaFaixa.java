package br.ifba.inf011.prot.sensor;

import br.ifba.inf011.prot.Prototipavel;

public class SensorTemperaturaFaixa extends AbstractSensor implements SensorIF{
	
	private double temperaturaAltaLimite;
	private double temperaturaBaixaLimite;
	
	public SensorTemperaturaFaixa(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		this.ajuste(temperaturaBaixaLimite, temperaturaAltaLimite);
	}
	
	public SensorTemperaturaFaixa(SensorTemperaturaFaixa sensorTemperaturaFaixa) {
		this(sensorTemperaturaFaixa.temperaturaBaixaLimite, 
			 sensorTemperaturaFaixa.temperaturaAltaLimite);
		this.setOut(sensorTemperaturaFaixa.getOut());
		this.setTemperaturaAtual(sensorTemperaturaFaixa.temperaturaAtual);
	}

	private void alarmar(boolean alta) {
		if(alta)
			this.out.println("[Sensor Temperatura Faixa] : " + this.temperaturaAtual + "°: [ALARME DE ALTA DE TEMPERATURA]");
		else
			this.out.println("[Sensor Temperatura Faixa] : " + this.temperaturaAtual + "°: [ALARME DE BAIXA DE TEMPERATURA]");
		
	}
	
	public void medir(double temperatura) {
		this.temperaturaAtual = temperatura;
		if(this.temperaturaAtual > this.getTemperaturaAltaLimite())
			this.alarmar(true);
		else if(this.temperaturaAtual < this.getTemperaturaBaixaLimite())
			this.alarmar(false);
		else
			this.out.println("[Sensor Temperatura Faixa] : " + this.temperaturaAtual + "°");
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
	
	@Override
	public Prototipavel prototipar(){
		return new SensorTemperaturaFaixa(this);
	}	
	
}
