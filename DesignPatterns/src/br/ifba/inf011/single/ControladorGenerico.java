package br.ifba.inf011.single;

import br.ifba.inf011.single.atuador.AtuadorIF;
import br.ifba.inf011.single.sensor.SensorIF;

public class ControladorGenerico implements ControladorIF{

	private SensorIF sensor;
	private AtuadorIF atuador;	
	
	public ControladorGenerico(SensorIF sensor, AtuadorIF atuador) {
		this.sensor = sensor;
		this.atuador = atuador;
	}
	
	public SensorIF getSensor() {
		return this.sensor;
	}
	public void setSensor(SensorIF sensor) {
		this.sensor = sensor;
	}
	public AtuadorIF getAtuador() {
		return this.atuador;
	}
	public void setAtuador(AtuadorIF atuador) {
		this.atuador = atuador;
	}
	
	@Override
	public double processar(double temperatura) {
		this.getSensor().medir(temperatura);
		return this.getAtuador().atuar(temperatura);
	}	
	
}
