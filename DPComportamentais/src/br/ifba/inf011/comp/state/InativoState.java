package br.ifba.inf011.comp.state;
public class InativoState extends AbstractControladorState implements ControladorState {

	@Override
	public ControladorState ativar() {
		return new AtivoState();
	}

}
