package br.ifba.inf011.cria.prot.sensor;

public class SensorTemperaturaLockFactory extends SensorFactory{

	public SensorTemperaturaLockFactory(double temperaturaLimite) {
		super(temperaturaLimite);
	}
	
	public SensorTemperaturaLockFactory() {
		super();
	}	

	public SensorIF createSensor() {
		SensorTemperaturaLock sensor = new SensorTemperaturaLock(this.getTemperaturaMaxima());
		sensor.reset();
		return sensor;
	}	
	
}
