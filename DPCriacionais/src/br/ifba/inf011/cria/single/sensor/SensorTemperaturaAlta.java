package br.ifba.inf011.cria.single.sensor;

import br.ifba.inf011.cria.single.Prototipavel;

public class SensorTemperaturaAlta extends AbstractSensor implements SensorIF{
	
	private double temperaturaLimite;
		
	public SensorTemperaturaAlta(double temperaturaLimite) {
		this.setTemperaturaLimite(temperaturaLimite);
	}
		
	public SensorTemperaturaAlta(SensorTemperaturaAlta sensorTemperaturaAlta) {
		this(sensorTemperaturaAlta.temperaturaLimite);
		this.setOut(sensorTemperaturaAlta.getOut());
		this.setTemperaturaAtual(sensorTemperaturaAlta.temperaturaAtual);
	}

	private void alarmar() {
		this.out.println("[Sensor Temperatura Alta] : " + this.temperaturaAtual + "°: [ALARME DE ALTA DE TEMPERATURA]");
	}
		
	public void medir(double temperatura) {
		this.temperaturaAtual = temperatura;
		if(this.temperaturaAtual > this.getTemperaturaLimite())
			this.alarmar();
		else
			this.out.println("[Sensor Alta Temperatura] : " + this.temperaturaAtual + "°");
	}

	public double getTemperaturaLimite() {
		return this.temperaturaLimite;
	}

	private void setTemperaturaLimite(double temperaturaLimite) {
		this.temperaturaLimite = temperaturaLimite;
	}

	@Override
	public void ajuste(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		this.setTemperaturaLimite(temperaturaAltaLimite);
	}
	
	@Override
	public Prototipavel prototipar(){
		return new SensorTemperaturaAlta(this);
	}		

}
