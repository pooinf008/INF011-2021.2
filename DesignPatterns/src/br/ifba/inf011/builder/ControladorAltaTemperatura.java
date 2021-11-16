package br.ifba.inf011.builder;

//PRODUCT em Builder
public class ControladorAltaTemperatura extends AbstractControlador implements ControladorIF {
	
	public ControladorAltaTemperatura(SensorAltaTemperatura sensor, Resfriador resfriador) {
		super(sensor, resfriador);
	}
	


}
