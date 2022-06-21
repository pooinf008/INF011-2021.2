package br.edu.ifba.inf011.aval3.state;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ifba.inf011.aval3.Curso;
import br.edu.ifba.inf011.aval3.Disciplina;
import br.edu.ifba.inf011.aval3.Curso.Situacao;
import br.edu.ifba.inf011.aval3.ProdutoAssistivel;
import br.edu.ifba.inf011.aval3.observer.CheckpointData;
import br.edu.ifba.inf011.aval3.observer.CheckpointListener;

public abstract class AbstractCursoState implements CursoState{
	
	
	private Map<String, Integer> getPctConclusaoDisciplinas(Map<String, ProdutoAssistivel> assistiveis){
		Map<String, Integer> pctConclusao = new HashMap<String, Integer>();
		for(ProdutoAssistivel assistivel : assistiveis.values())
			pctConclusao.put(assistivel.getCodigo(), assistivel.getCHCumprida());
		return pctConclusao;
	}	
	
	
	protected boolean disciplinasConcluidas(Map<String, ProdutoAssistivel> assistiveis){
		for(ProdutoAssistivel assistivel : assistiveis.values())
			if (assistivel.getPctCHCumprida() < 1)
				return false;
		return true;
	}		
	
	public void notifyCheckpointEvent(Map<String, ProdutoAssistivel> assistiveis, List<CheckpointListener> checkpointListeners) {
		CheckpointData data = new CheckpointData(this.getPctConclusaoDisciplinas(assistiveis));
		for(CheckpointListener listener : checkpointListeners)
			listener.notifyCheckpointEvent(data);
	}
	
	public void notifyRestoreEvent(Map<String, ProdutoAssistivel> assistiveis, List<CheckpointListener> checkpointListeners) {
		CheckpointData data = new CheckpointData(this.getPctConclusaoDisciplinas(assistiveis));
		for(CheckpointListener listener : checkpointListeners)
			listener.notifyRestoreEvent(data);
	}	

	@Override
	public void avancar(Map<String, ProdutoAssistivel> assistivel, String cdDisciplina, int ch) throws OperacaoInvalida{
		throw new OperacaoInvalida("O Estado " + this.getNome() + " não suporta a operação avançar");
	}

	@Override
	public Situacao checkpoint(Curso curso, Map<String, ProdutoAssistivel> assistivel, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida{
		throw new OperacaoInvalida("O Estado " + this.getNome() + " não suporta a operação checkpoint");
	}

	@Override
	public void restore(Situacao situacao, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida{
		throw new OperacaoInvalida("O Estado " + this.getNome() + " não suporta a operação restore");
	}
	
	@Override
	public String emitirCertificado(String cod, String nome, Map<String, ProdutoAssistivel> assistivel) throws OperacaoInvalida{
		throw new OperacaoInvalida("O Estado " + this.getNome() + " não suporta a operação emitir certificado");
	};

	@Override
	public CursoState continuar() {
		return this;
	}

	@Override
	public CursoState suspender() {
		return this;
	}

	@Override
	public CursoState concluir(Map<String, ProdutoAssistivel> assistivel) {
		return this;
	}

	@Override
	public CursoState cancelar() {
		return this;
	}
	
	public abstract String getNome();
	
	protected Set<Disciplina> getDisciplinas(Map<String, ProdutoAssistivel> assistiveis) {
		HashSet<Disciplina> setDisciplinas = new HashSet<Disciplina>();
		for(ProdutoAssistivel assistivel : assistiveis.values())
			setDisciplinas.addAll(assistivel.getDisciplinas());
		return setDisciplinas;
	}		
	
	
}
