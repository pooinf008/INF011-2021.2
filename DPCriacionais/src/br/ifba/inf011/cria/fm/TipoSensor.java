package br.ifba.inf011.cria.fm;

public enum TipoSensor {
	
	BASICO("br.ifba.inf011.fm.SensorTemperaturaFactory"), 
	LOCK("br.ifba.inf011.fm.SensorTemperaturaLockFactory");
	
	String className;
	
	private TipoSensor(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}
	

}
