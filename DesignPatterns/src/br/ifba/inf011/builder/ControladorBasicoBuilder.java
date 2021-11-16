package br.ifba.inf011.builder;

import java.io.PrintStream;

//CONCRETEBUILDER em um Builder
//DISPENSA Diretor 
//CONSTROI ControladorBasico
public class ControladorBasicoBuilder{

	private SensorIF sensor;
	private AtuadorIF atuador;
	private PrintStream logger;
	
	public static ControladorBasicoBuilder reset() {
		return new ControladorBasicoBuilder();
	}
	
	private ControladorBasicoBuilder() {
		this.sensor = new SensorAltaTemperatura(30);
		this.atuador = new Resfriador(30);
		this.logger = System.out;
	}
	
	public ControladorBasicoBuilder setLogger(PrintStream logger) {
		this.logger = logger;
		return this;
	}
	
	public ControladorBasicoBuilder setSensor(SensorIF sensor){
		this.sensor = sensor;
		return this;
	}
	
	public ControladorBasicoBuilder setAtuador(AtuadorIF atuador){
		this.atuador = atuador;
		return this;
	}	
	
	public ControladorIF build() {
		this.sensor.setLogger(this.logger);
		this.atuador.setLogger(this.logger);	
		return new ControladorBasico(this.sensor, this.atuador);
	}
	


}
