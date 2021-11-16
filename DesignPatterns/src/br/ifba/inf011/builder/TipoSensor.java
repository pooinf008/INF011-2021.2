package br.ifba.inf011.builder;

public enum TipoSensor {
	
	BASICO("br.ifba.inf011.afm.pre.SensorTemperaturaFactory"),
	FAIXA("br.ifba.inf011.afm.pre.SensorFaixaTemperaturaFactory"),
	LOCK("br.ifba.inf011.afm.pre.SensorTemperaturaLockFactory");
	
	String className;
	
	private TipoSensor(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}
	

}
