package br.ifba.inf011.builder;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

//CONCRETEBUILDER em um Builder
//DISPENSA Diretor 
//CONSTROI Controlador
public class ControladorBuilder{

	private List<SensorIF> sensores;
	private List<AtuadorIF> atuadores;
	private PrintStream logger;
	
	public static ControladorBuilder reset() {
		return new ControladorBuilder();
	}
	
	private ControladorBuilder() {
		this.sensores = new ArrayList<SensorIF>();
		this.atuadores = new ArrayList<AtuadorIF>();
		this.logger = System.out;
	}
	
	public ControladorBuilder setLogger(PrintStream logger) {
		this.logger = logger;
		return this;
	}
	
	public ControladorBuilder addSensor(SensorIF sensor){
		this.sensores.add(sensor);
		return this;
	}
	
	public ControladorBuilder addAtuador(AtuadorIF atuador){
		this.atuadores.add(atuador);
		return this;
	}	
	
	public Controlador build() {
		for(SensorIF sensor : this.sensores)
			sensor.setLogger(this.logger);
		for(AtuadorIF atuador : this.atuadores)
			atuador.setLogger(this.logger);	
		return new Controlador(this.sensores, this.atuadores);
	}
	


}
