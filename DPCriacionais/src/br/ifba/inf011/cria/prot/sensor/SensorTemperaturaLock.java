package br.ifba.inf011.cria.prot.sensor;

import br.ifba.inf011.cria.prot.Prototipavel;

//PROTOTYPECONCRETO em um Prototype
public class SensorTemperaturaLock extends AbstractSensor implements SensorIF{

	private double temperaturaLimite;
	private boolean lock;
	
	public SensorTemperaturaLock(double temperaturaLimite) {
		this.setTemperaturaLimite(temperaturaLimite);
		this.lock = false;
	}
	
	public SensorTemperaturaLock() {
		this.lock = false;
	}	
	
	
	public SensorTemperaturaLock(SensorTemperaturaLock sensorTemperaturaLock) {
		this(sensorTemperaturaLock.temperaturaLimite);
		this.setTemperaturaAtual(sensorTemperaturaLock.temperaturaLimite);
		this.lock = sensorTemperaturaLock.lock;
		this.setOut(sensorTemperaturaLock.getOut());
	}

	private void alarmar() {
		this.out.println("[Sensor Temperatura Lock] : " + this.temperaturaAtual + "°: [ALARME DE ALTA DE TEMPERATURA]");
		this.lock = true;
	}
	
	
	public void medir(double temperatura) {
		this.temperaturaAtual = temperatura;
		if(this.temperaturaAtual > this.getTemperaturaLimite() || this.lock)
			this.alarmar();
		else
			this.out.println("[Sensor Temperatura Lock] : " + this.temperaturaAtual + "°");
	}


	public double getTemperaturaLimite() {
		return temperaturaLimite;
	}


	private void setTemperaturaLimite(double temperaturaLimite) {
		this.temperaturaLimite = temperaturaLimite;
	}

	public void reset() {
		this.lock = false;
	}
	
	@Override
	public void ajuste(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		this.setTemperaturaLimite(temperaturaAltaLimite);
	}
	
	@Override
	public Prototipavel prototipar(){
		return new SensorTemperaturaLock(this);
	}		
	
	
}
