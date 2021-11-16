package br.ifba.inf011.cria.single.sensor;

public enum TipoSensor {
	
	BASICO("br.ifba.inf011.single.sensor.SensorTemperaturaAltaFactory"),
	FAIXA("br.ifba.inf011.single.sensor.SensorTemperaturaFaixaFactory"),
	LOCK("br.ifba.inf011.single.sensor.SensorTemperaturaLockFactory");
	
	String className;
	
	private TipoSensor(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}
	

}
