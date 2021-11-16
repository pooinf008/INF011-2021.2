package br.ifba.inf011.comp.state;

import java.util.List;

import br.ifba.inf011.comp.state.Controlador.Snapshot;

public interface ControladorState {
	public double executar(double valor, List<Double> historico, double setpoint, double ganho, ControladorHandler handler);
	public void restore(Snapshot snapshot);
	public ControladorState ativar();
	public ControladorState inativar();
	public ControladorState restaurar();
}
