package br.ifba.inf011.estrut.proxy;
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
