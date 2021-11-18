package br.ifba.inf011.estrut.adapter;

import br.ifba.inf011.estrut.adapter.Controlador.Snapshot;

public class RecuperarState extends AbstractControladorState implements ControladorState {

	@Override
	public void restore(Snapshot snapshot) {
		snapshot.restore();
	}

	@Override
	public ControladorState ativar() {
		return new AtivoState();
	}

	@Override
	public ControladorState inativar() {
		return new InativoState();
	}

	@Override
	public String getNome() {
		return "EM RECUPERAÇÃO";
	}


}
