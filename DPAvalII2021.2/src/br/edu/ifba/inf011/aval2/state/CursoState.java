package br.edu.ifba.inf011.aval2.state;

import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.aval2.Curso;
import br.edu.ifba.inf011.aval2.Curso.Situacao;
import br.edu.ifba.inf011.aval2.Disciplina;
import br.edu.ifba.inf011.aval2.observer.CheckpointListener;

public interface CursoState {

	public void avancar(Map<String, Disciplina> disciplinas, String cdDisciplina, double pct) throws OperacaoInvalida;
	public Situacao checkpoint(Curso curso, Map<String, Disciplina> disciplinas, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida;
	public void restore(Situacao situacao, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida;
	public String emitirCertificado(String cod, String nome, Map<String, Disciplina> disciplinas) throws OperacaoInvalida;
	public CursoState continuar();
	public CursoState suspender();
	public CursoState concluir(Map<String, Disciplina> disciplinas);
	public CursoState cancelar();

}
