package br.ifba.inf011.cria.builder;

//PRODUCT em Builder
public class ControladorAltaTemperatura extends AbstractControlador implements ControladorIF {
	
	public ControladorAltaTemperatura(SensorAltaTemperatura sensor, Resfriador resfriador) {
		super(sensor, resfriador);
	}
	


}
