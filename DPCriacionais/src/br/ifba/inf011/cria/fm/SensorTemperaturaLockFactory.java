package br.ifba.inf011.cria.fm;

//CREATOR em Factory Method
public class SensorTemperaturaLockFactory extends SensorFactory{

	public SensorTemperaturaLockFactory(double temperaturaLimite) {
		super(temperaturaLimite);
	}
	
	public SensorTemperaturaLockFactory() {
		super();
	}	

	public SensorIF createSensor() {
		SensorTemperaturaLock sensor = new SensorTemperaturaLock(this.temperaturaLimite);
		sensor.reset();
		return sensor;
	}	
	
}
