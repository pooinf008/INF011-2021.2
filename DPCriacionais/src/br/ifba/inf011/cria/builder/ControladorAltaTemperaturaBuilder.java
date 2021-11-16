package br.ifba.inf011.cria.builder;

import java.io.PrintStream;

//CONCRETEBUILDER em um Builder
//CONSTROI ControladorAltaTemperatura
public class ControladorAltaTemperaturaBuilder implements BuilderIF{

	public static final	double MAX_TEMPERATURA = 30;

	
	private ControladorAltaTemperatura controlador;
	private SensorAltaTemperatura sensor;
	private Resfriador resfriador;
	private PrintStream logger;

	
	public ControladorAltaTemperaturaBuilder() {
	}
	
	@Override
	public void reset() {
		this.controlador = null;
		this.sensor = null;
		this.resfriador = null;
	}

	@Override
	public void setTermometro() {
		this.sensor = new SensorAltaTemperatura(ControladorAltaTemperaturaBuilder.MAX_TEMPERATURA);
		this.sensor.setLogger(this.logger);
	}

	@Override
	public void setAtuador() {
		this.resfriador = new Resfriador(ControladorAltaTemperaturaBuilder.MAX_TEMPERATURA);
		this.resfriador.setLogger(this.logger);
	}
	
	@Override
	public void setLogger() {
		this.logger = System.err;
	}	
	
	public ControladorIF getControlador() {
		this.controlador = new ControladorAltaTemperatura(this.sensor, this.resfriador); 
		return this.controlador;
	}



}
