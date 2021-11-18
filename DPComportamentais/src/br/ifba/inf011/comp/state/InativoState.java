package br.ifba.inf011.comp.state;

//CONCRETESTATE em State
public class InativoState extends AbstractControladorState implements ControladorState {

	@Override
	public ControladorState ativar() {
		return new AtivoState();
	}

}
