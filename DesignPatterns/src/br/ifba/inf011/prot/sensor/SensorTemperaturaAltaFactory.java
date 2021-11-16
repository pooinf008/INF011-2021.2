package br.ifba.inf011.prot.sensor;

public class SensorTemperaturaAltaFactory extends SensorFactory{

	public SensorTemperaturaAltaFactory(double temperaturaLimite) {
		super(temperaturaLimite);
	}
	
	public SensorTemperaturaAltaFactory() {
		super();
	}	

	public SensorIF createSensor() {
		return new SensorTemperaturaAlta(this.getTemperaturaMaxima());
	}
	

}
