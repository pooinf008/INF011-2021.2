package br.ifba.inf011.builder;

//PRODUCT em Builder
public class ControladorFaixa extends AbstractControlador implements ControladorIF{

	public ControladorFaixa(SensorFaixaTemperatura sensor, Estabilizador resfriador) {
		super(sensor, resfriador);
	}	


}
