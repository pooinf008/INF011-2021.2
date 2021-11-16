package br.ifba.inf011.prot.sensor;

public enum TipoSensor {
	
	BASICO("br.ifba.inf011.prot.sensor.SensorTemperaturaAltaFactory"),
	FAIXA("br.ifba.inf011.prot.sensor.SensorTemperaturaFaixaFactory"),
	LOCK("br.ifba.inf011.prot.sensor.SensorTemperaturaLockFactory");
	
	String className;
	
	private TipoSensor(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}
	

}
