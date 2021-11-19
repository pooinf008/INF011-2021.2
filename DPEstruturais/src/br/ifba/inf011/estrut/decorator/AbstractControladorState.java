package br.ifba.inf011.estrut.decorator;

import java.util.List;

import br.ifba.inf011.estrut.decorator.Controlador.Snapshot;

public abstract class AbstractControladorState implements ControladorState{

	@Override
	public double executar(double valor, List<Double> historico, double setpoint, double ganho,
			ControladorHandler handler) {
		return 0;
	}

	@Override
	public void restore(Snapshot snapshot) {
		return;
	}

	@Override
	public ControladorState ativar() {
		return this;
	}

	@Override
	public ControladorState inativar() {
		return this;
	}

	@Override
	public ControladorState restaurar() {
		return this;
	}

}
