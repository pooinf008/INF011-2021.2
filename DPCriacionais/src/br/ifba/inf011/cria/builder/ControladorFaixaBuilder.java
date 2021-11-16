package br.ifba.inf011.cria.builder;

import java.io.PrintStream;

//CONCRETEBUILDER em um Builder
//CONSTROI ControladorFaixa
public class ControladorFaixaBuilder implements BuilderIF{

	public static final	double MAX_TEMPERATURA = 30;
	public static final	double MIN_TEMPERATURA = 26;
	
	
	private ControladorFaixa controlador;
	private SensorFaixaTemperatura sensor;
	private Estabilizador estabilizador;
	private PrintStream logger;
	
	
	@Override
	public void reset() {
		this.controlador = null;
		this.sensor = null;
		this.estabilizador = null;
	}

	@Override
	public void setTermometro() {
		this.sensor = new SensorFaixaTemperatura(ControladorFaixaBuilder.MIN_TEMPERATURA ,
												 ControladorFaixaBuilder.MAX_TEMPERATURA);
		this.sensor.setLogger(this.logger);
	}

	@Override
	public void setAtuador() {
		this.estabilizador = new Estabilizador(ControladorFaixaBuilder.MIN_TEMPERATURA ,
				 							ControladorFaixaBuilder.MAX_TEMPERATURA);
		this.estabilizador.setLogger(this.logger);		
	}
	
	@Override
	public void setLogger() {
		this.logger = System.err;
	}		
	
	
	public ControladorIF getControlador() {
		this.controlador = new ControladorFaixa(this.sensor, this.estabilizador); 
		return this.controlador;
	}

}
