package br.ifba.inf011.cria.fm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CREATOR em um Factory Method
public abstract class SensorFactory {
	
	private static int index = 0;
	private static Map<String, SensorFactory> map = new HashMap<String, SensorFactory>();
	private static List<String> tipos = new ArrayList<String>(); 

	static {
		SensorFactory.map.put("BASICO", new SensorTemperaturaFactory());
		SensorFactory.map.put("LOCK", new SensorTemperaturaLockFactory());
		tipos.add("BASICO");
		tipos.add("LOCK");
		
	}
	
	protected double temperaturaLimite;

	
	public static SensorIF getSensor(String factoryName) {
/*		if(factoryName.equalsIgnoreCase("BASICO"))
			return new SensorTemperaturaFactory();
		else if(factoryName.equalsIgnoreCase("LOCK"))
			return new SensorTemperaturaLockFactory();
		else
			return null;*/
		return SensorFactory.map.get(factoryName).getSensor();
	}
	
	public static SensorIF next() {
		SensorFactory.index++;
		int x = SensorFactory.index % tipos.size();
		return SensorFactory.getSensor(tipos.get(x));
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
