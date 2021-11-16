package br.ifba.inf011.cria.fm;

//CREATOR em Factory Method
public class SensorTemperaturaFactory extends SensorFactory{

	public SensorTemperaturaFactory(double temperaturaLimite) {
		super(temperaturaLimite);
	}
	
	public SensorTemperaturaFactory() {
		super();
	}	

	public SensorIF createSensor() {
		return new SensorTemperatura(this.temperaturaLimite);
	}
	

}
