package br.edu.ifba.inf011.aval3.state;

import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.aval3.Curso;
import br.edu.ifba.inf011.aval3.ProdutoAssistivel;
import br.edu.ifba.inf011.aval3.Curso.Situacao;
import br.edu.ifba.inf011.aval3.observer.CheckpointListener;

public class SuspensoState extends AbstractCursoState implements CursoState {


	@Override
	public Situacao checkpoint(Curso curso, Map<String, ProdutoAssistivel> assistiveis,
			List<CheckpointListener> checkpointListeners) throws OperacaoInvalida {
		this.notifyCheckpointEvent(assistiveis, checkpointListeners);
		return  curso.new Situacao(curso, assistiveis);
	}

	@Override
	public CursoState continuar() {
		return new EmAndamentoState();
	}

	@Override
	public CursoState cancelar() {
		return new CanceladoState();
	}

	@Override
	public String getNome() {
		return "SUSPENSO";
	}

}
