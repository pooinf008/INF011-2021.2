package br.edu.ifba.inf011.aval2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.aval2.observer.CheckpointListener;
import br.edu.ifba.inf011.aval2.prototype.Prototipavel;
import br.edu.ifba.inf011.aval2.state.CursoState;
import br.edu.ifba.inf011.aval2.state.EmAndamentoState;
import br.edu.ifba.inf011.aval2.state.OperacaoInvalida;

public class Curso extends Produto{
	
	public class Situacao{
		
		private Curso curso;
		private Map<String, Disciplina> disciplinas;
		
		public Situacao(Curso curso, Map<String, Disciplina> disciplinas) {
			this.curso = curso;
			this.disciplinas = new HashMap<String, Disciplina>();
			for(String codigo : disciplinas.keySet())
				this.disciplinas.put(codigo, 
									 (Disciplina) disciplinas.get(codigo).prototipar());
		}
		
		public void restore() {
			this.curso.disciplinas = this.disciplinas;
		}
		
		public Map<String, Disciplina> getDisciplinas() {
			return this.disciplinas;
		}
		
	}
	
	
	private Map<String, Disciplina> disciplinas;
	private List<Livro> livros;
	private CursoState cursoState;
	private List<CheckpointListener> checkpointListeners;
	
	
	private Curso(Curso curso) {
		super(curso);
		this.disciplinas = new HashMap<String, Disciplina>();
		for(String codigo : curso.disciplinas.keySet())
			this.disciplinas.put(codigo, 
								 (Disciplina) curso.disciplinas.get(codigo).prototipar());
		this.livros = new LinkedList<Livro>();
		for(Livro l : curso.livros)
			this.livros.add((Livro)l.prototipar());
		this.checkpointListeners = new LinkedList<CheckpointListener>();
		for(CheckpointListener listener : curso.checkpointListeners)
			this.checkpointListeners.add(listener);
		this.cursoState = curso.cursoState;
	}
	
	public Curso(String codigo, String nome) {
		super(codigo, nome);
		this.disciplinas = new HashMap<String, Disciplina>();
		this.livros = new LinkedList<Livro>();
		this.checkpointListeners = new LinkedList<CheckpointListener>();
		this.cursoState = new EmAndamentoState();
	}
	
	public Curso(String codigo, String nome, 
				 List<Disciplina> disciplinas,
				 List<Livro> livros) {
		super(codigo, nome);
		this.disciplinas = new HashMap<String, Disciplina>();
		for(Disciplina d : disciplinas)
			this.disciplinas.put(d.getCodigo(), d);
		this.livros = new LinkedList<Livro>(livros);
		this.checkpointListeners = new LinkedList<CheckpointListener>();	
		this.cursoState = new EmAndamentoState();
	}	
	
	@Override
	public double getPreco() {
		return 0;
	}
	
	public String toString() {
		String rep =  "[Curso] "  + this.getCodigo() + "-" + this.getNome() + "\n"; 
		for(Disciplina disciplina : this.disciplinas.values())
			rep = rep + disciplina + "\n";
		return rep;
	}
	
	public String emitirCertificado()  throws OperacaoInvalida{
		return this.cursoState.emitirCertificado(this.getCodigo(), this.getNome(), this.disciplinas);
	}

	@Override
	public Prototipavel prototipar() {
		return new Curso(this);
	}	
	
	public void avancar(String cdDisciplina, double pct) throws OperacaoInvalida {
		this.cursoState.avancar(this.disciplinas, cdDisciplina,  pct);

	}
	
	public Situacao checkpoint() throws OperacaoInvalida {
		return this.cursoState.checkpoint(this, this.disciplinas, this.checkpointListeners);
	}

	public void restore(Situacao situacao) throws OperacaoInvalida {
		 this.cursoState.restore(situacao, this.checkpointListeners);
	}		
	
	public void addCheckpointListener(CheckpointListener listener) {
		this.checkpointListeners.add(listener);
	}
	
	public void removeCheckpointListener(CheckpointListener listener) {
		this.checkpointListeners.remove(listener);
	}

	public void continuar() {
		this.cursoState = this.cursoState.continuar();
	}

	public void suspender() {
		this.cursoState = this.cursoState.suspender();
	}

	public void concluir() {
		this.cursoState =  this.cursoState.concluir(this.disciplinas);
	}

	public void cancelar() {
		this.cursoState =  this.cursoState.cancelar();	
	}

}
