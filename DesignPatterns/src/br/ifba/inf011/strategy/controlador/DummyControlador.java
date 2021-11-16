package br.ifba.inf011.strategy.controlador;

import br.ifba.inf011.builder.ControladorIF;

public class DummyControlador implements ControladorIF{

	@Override
	public double processar(double temperatura) {
		return temperatura;
	}

}
