package br.edu.ifba.inf011.aval3.state;

import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.aval3.Curso;
import br.edu.ifba.inf011.aval3.Disciplina;
import br.edu.ifba.inf011.aval3.ProdutoAssistivel;
import br.edu.ifba.inf011.aval3.Curso.Situacao;
import br.edu.ifba.inf011.aval3.observer.CheckpointListener;

public class EmAndamentoState extends AbstractCursoState implements CursoState {

	@Override
	public void avancar(Map<String, ProdutoAssistivel> assistiveis, String cdDisciplina, int ch) throws OperacaoInvalida{
		for(ProdutoAssistivel assistivel : assistiveis.values())
			for(Disciplina disciplina : assistivel.getDisciplinas())
				if(disciplina.getCodigo().equals(cdDisciplina))
					disciplina.avancar(ch);
	}	
	
	@Override
	public Situacao checkpoint(Curso curso, Map<String, ProdutoAssistivel> assistiveis, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida{
		this.notifyCheckpointEvent(assistiveis, checkpointListeners);
		return  curso.new Situacao(curso, assistiveis);
	}	
	
	@Override
	public void restore(Situacao situacao, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida {
		situacao.restore();
		this.notifyRestoreEvent(situacao.getProdutosAssistiveis(), checkpointListeners);
	}
	
	public CursoState suspender() {
		return new SuspensoState();
	};
	
	public CursoState concluir(Map<String, ProdutoAssistivel> assistiveis) {
		if(this.disciplinasConcluidas(assistiveis))
			return new ConcluidoState();
		return this;
	};
	
	@Override
	public String getNome() {
		return "EM ANDAMENTO";
	}
	


}
