package br.edu.ifba.inf011.aval2.state;

import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.aval2.Curso;
import br.edu.ifba.inf011.aval2.Curso.Situacao;
import br.edu.ifba.inf011.aval2.Disciplina;
import br.edu.ifba.inf011.aval2.observer.CheckpointListener;

public class SuspensoState extends AbstractCursoState implements CursoState {


	@Override
	public Situacao checkpoint(Curso curso, Map<String, Disciplina> disciplinas,
			List<CheckpointListener> checkpointListeners) throws OperacaoInvalida {
		this.notifyCheckpointEvent(disciplinas, checkpointListeners);
		return  curso.new Situacao(curso, disciplinas);
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
