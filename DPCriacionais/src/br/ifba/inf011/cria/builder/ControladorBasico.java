package br.ifba.inf011.cria.builder;

//PRODUCT em Builder
public class ControladorBasico extends AbstractControlador implements ControladorIF{

	public ControladorBasico(SensorIF sensor, AtuadorIF atuador) {
		super(sensor, atuador);
	}

}
