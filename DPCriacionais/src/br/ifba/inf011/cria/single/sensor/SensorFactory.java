package br.ifba.inf011.cria.single.sensor;

import java.io.PrintStream;

public abstract class SensorFactory {
	
	public static PrintStream LOG_STREAM = System.err;
	
	protected double temperaturaMaxima;
	protected double temperaturaMinima;

	public SensorFactory() {
		this.temperaturaMaxima = Double.NaN;
		this.temperaturaMinima = Double.NaN;
	}
	
	public SensorFactory(double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMinima = Double.NaN;
	}
	
	public SensorFactory(double temperaturaMinima, double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMinima = temperaturaMinima;
	}	
	
	public abstract SensorIF createSensor();

	public SensorIF getSensor() {
		return this.getSensor(this.temperaturaMinima, this.temperaturaMaxima);
	}
	
	public SensorIF getSensor(double temperaturaMinima,  double temperaturaMaxima) {
		SensorIF sensor = this.createSensor();
		sensor.setLogger(SensorFactory.LOG_STREAM);
		sensor.ajuste(temperaturaMinima, temperaturaMaxima);
		return sensor;
	}	
	
	public SensorIF getSensor(double temperaturaLimite) {
		return this.getSensor(this.temperaturaMinima, temperaturaLimite);
	}

	public double getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public double getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}	
	

	

}
