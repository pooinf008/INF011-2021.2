package br.ifba.inf011.cria.afm;

//CONCRETEPRODUCT em um Abstract Factory
public class SensorAltaTemperatura implements SensorIF{
	
	private double temperaturaLimite;
	private double temperaturaAtual;
	
	public SensorAltaTemperatura(double temperaturaLimite) {
		this.setTemperaturaLimite(temperaturaLimite);
	}
	
	private void alarmar() {
		System.out.println("[Sensor Temperatura] : " + this.temperaturaAtual + "°: [ALARME DE ALTA DE TEMPERATURA]");
	}
	
	public void medir(double temperatura) {
		this.temperaturaAtual = temperatura;
		if(temperatura > this.getTemperaturaLimite())
			this.alarmar();
		else
			System.out.println("[Sensor Temperatura] : " + this.temperaturaAtual + "°");
	}

	public double getTemperaturaLimite() {
		return temperaturaLimite;
	}

	private void setTemperaturaLimite(double temperaturaLimite) {
		this.temperaturaLimite = temperaturaLimite;
	}

}
