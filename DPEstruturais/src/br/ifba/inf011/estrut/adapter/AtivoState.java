package br.ifba.inf011.estrut.adapter;

import java.util.List;


public class AtivoState extends AbstractControladorState implements ControladorState {

	@Override
	public double executar(double valor, List<Double> historico, double setpoint, double ganho,
			ControladorHandler handler) {
		historico.add(valor);
		return handler.controlar(historico, setpoint, ganho);
	}

	@Override
	public ControladorState inativar() {
		return new InativoState();
	}

	@Override
	public ControladorState restaurar() {
		return new RecuperarState();
	}

	@Override
	public String getNome() {
		return "ATIVO";
	}

}
