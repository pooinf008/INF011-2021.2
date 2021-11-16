package br.ifba.inf011.fm;


//CREATOR em um Factory Method
public abstract class SensorFactory {
	
	
	protected double temperaturaLimite;

	public static SensorFactory getFactory(String factoryName) {
		if(factoryName.equalsIgnoreCase("BASICO"))
			return new SensorTemperaturaFactory();
		else if(factoryName.equalsIgnoreCase("LOCK"))
			return new SensorTemperaturaLockFactory();
		else
			return null;
	}
	
	public SensorFactory() {
		this.temperaturaLimite = Double.NaN;
	}
	
	
	public SensorFactory(double temperaturaLimite) {
		this.temperaturaLimite = temperaturaLimite;
	}
	
/*	public SensorIF createSensor() {
		switch(Aplicacao.SENSOR) {
			case BASICO : return new SensorTemperatura(temperaturaLimite);
			case LOCK : return new SensorTemperaturaLock(temperaturaLimite);
		}
		return null;
	};
*/	
	public abstract SensorIF createSensor();

	
	public SensorIF getSensor() {
		SensorIF sensor = this.createSensor();
		sensor.ajuste(this.temperaturaLimite);
		return sensor;
	}
	
	public SensorIF getSensor(double temperaturaLimite) {
		SensorIF sensor = this.createSensor();
		sensor.ajuste(temperaturaLimite);
		return sensor;
	}	
	

}
