package br.ifba.inf011.comp.observer;
public class InativoState extends AbstractControladorState implements ControladorState {

	@Override
	public ControladorState ativar() {
		return new AtivoState();
	}

	@Override
	public String getNome() {
		return "INATIVO";
	}

}
