package br.ifba.inf011.cria.single.sensor;

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
