package br.ifba.inf011.fm;

//CONCRETEPRODUCT em um Factory Method
public class SensorTemperaturaLock implements SensorIF{

	private double temperaturaLimite;
	private double temperaturaAtual;
	private boolean lock;
	
	public SensorTemperaturaLock(double temperaturaLimite2) {
		this.setTemperaturaLimite(temperaturaLimite2);
		this.lock = false;
	}
	
	public SensorTemperaturaLock() {
		this.lock = false;
	}	
	
	
	private void alarmar() {
		System.out.println("[Sensor Temperatura Lock] : " + this.temperaturaAtual + "°: [ALARME DE ALTA DE TEMPERATURA]");
		this.lock = true;
	}
	
	
	public void medir(double temperatura) {
		this.temperaturaAtual = temperatura;
		if(temperatura > this.getTemperaturaLimite() || this.lock)
			this.alarmar();
		else
			System.out.println("[Sensor Temperatura Lock] : " + this.temperaturaAtual + "°");
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
	
	public void ajuste(double temperaturaLimite) {
		this.setTemperaturaLimite(temperaturaLimite);
	}
	
}
