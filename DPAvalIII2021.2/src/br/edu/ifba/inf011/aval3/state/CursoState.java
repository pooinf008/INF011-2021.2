package br.edu.ifba.inf011.aval3.state;

import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.aval3.Curso;
import br.edu.ifba.inf011.aval3.ProdutoAssistivel;
import br.edu.ifba.inf011.aval3.Curso.Situacao;
import br.edu.ifba.inf011.aval3.observer.CheckpointListener;

public interface CursoState {

	public void avancar(Map<String, ProdutoAssistivel> assistivel, String cdDisciplina, int ch) throws OperacaoInvalida;
	public Situacao checkpoint(Curso curso, Map<String, ProdutoAssistivel> assistivel, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida;
	public void restore(Situacao situacao, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida;
	public String emitirCertificado(String cod, String nome, Map<String, ProdutoAssistivel> assistivel) throws OperacaoInvalida;
	public CursoState continuar();
	public CursoState suspender();
	public CursoState concluir(Map<String, ProdutoAssistivel> assistivel);
	public CursoState cancelar();

}
