package br.edu.ifba.inf011.aval3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ifba.inf011.aval3.decorator.LivroIF;
import br.edu.ifba.inf011.aval3.observer.CheckpointListener;
import br.edu.ifba.inf011.aval3.prototype.Prototipavel;
import br.edu.ifba.inf011.aval3.state.CursoState;
import br.edu.ifba.inf011.aval3.state.EmAndamentoState;
import br.edu.ifba.inf011.aval3.state.OperacaoInvalida;

public class Curso extends ProdutoAssistivel{
	
	public class Situacao{
		
		private Curso curso;
		private Map<String, ProdutoAssistivel> assistivel;
		
		public Situacao(Curso curso, Map<String, ProdutoAssistivel> assistivel) {
			this.curso = curso;
			this.assistivel = new HashMap<String, ProdutoAssistivel>();
			for(String codigo : assistivel.keySet())
				this.assistivel.put(codigo, 
									(ProdutoAssistivel) assistivel.get(codigo).prototipar());
		}
		
		public void restore() {
			this.curso.assistivel = this.assistivel;
		}
		
		public Map<String, ProdutoAssistivel> getProdutosAssistiveis() {
			return this.assistivel;
		}
		
	}
	
	
	private Map<String, ProdutoAssistivel> assistivel;
	private List<LivroIF> livros;
	private CursoState cursoState;
	private List<CheckpointListener> checkpointListeners;
	
	
	private Curso(Curso curso) {
		super(curso);
		this.assistivel = new HashMap<String, ProdutoAssistivel>();
		for(String codigo : curso.assistivel.keySet())
			this.assistivel.put(codigo, 
								 (ProdutoAssistivel) curso.assistivel.get(codigo).prototipar());
		this.livros = new LinkedList<LivroIF>();
		for(LivroIF l : curso.livros)
			this.livros.add((Livro)l.prototipar());
		this.checkpointListeners = new LinkedList<CheckpointListener>();
		for(CheckpointListener listener : curso.checkpointListeners)
			this.checkpointListeners.add(listener);
		this.cursoState = curso.cursoState;
	}
	
	public Curso(String codigo, String nome) {
		super(codigo, nome);
		this.assistivel = new HashMap<String, ProdutoAssistivel>();
		this.livros = new LinkedList<LivroIF>();
		this.checkpointListeners = new LinkedList<CheckpointListener>();
		this.cursoState = new EmAndamentoState();
	}
	
	public Curso(String codigo, String nome, 
				 List<ProdutoAssistivel> assistiveis,
				 List<Livro> livros) {
		super(codigo, nome);
		this.assistivel = new HashMap<String, ProdutoAssistivel>();
		for(ProdutoAssistivel p : assistiveis)
			this.assistivel.put(p.getCodigo(), p);
		this.livros = new LinkedList<LivroIF>(livros);
		this.checkpointListeners = new LinkedList<CheckpointListener>();	
		this.cursoState = new EmAndamentoState();
	}	
	
	@Override
	public double getPreco() {
		double precoAssistiveis = 0; 
		double precolivros = 0;
		for(ProdutoAssistivel produto : this.assistivel.values())
			precoAssistiveis += produto.getPreco();
		precoAssistiveis *= 0.8;
		for(LivroIF livro : this.livros)
			precolivros += livro.getPreco();
		precolivros *= 0.9;
			
		return precoAssistiveis +  precolivros;
	}
	
	public String toString() {
		String rep =  "[Curso] "  + this.getCodigo() + "-" + this.getNome() + "\n"; 
		for(ProdutoAssistivel assistivel : this.assistivel.values())
			rep = rep + assistivel + "\n";
		return rep;
	}
	
	public String emitirCertificado()  throws OperacaoInvalida{
		return this.cursoState.emitirCertificado(this.getCodigo(), this.getNome(), this.assistivel);
	}

	@Override
	public Prototipavel prototipar() {
		return new Curso(this);
	}	
	
	public void avancar(String cdDisciplina, int ch) throws OperacaoInvalida {
		this.cursoState.avancar(this.assistivel, cdDisciplina,  ch);

	}
	
	public Situacao checkpoint() throws OperacaoInvalida {
		return this.cursoState.checkpoint(this, this.assistivel, this.checkpointListeners);
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
		this.cursoState =  this.cursoState.concluir(this.assistivel);
	}

	public void cancelar() {
		this.cursoState =  this.cursoState.cancelar();	
	}
	
	public int getCHTotal() {
		int chTotal = 0; 
		for(ProdutoAssistivel assistivel : this.assistivel.values())
			chTotal += assistivel.getCHTotal();
		return chTotal;
	}

	@Override
	public int getCHCumprida() {
		int chCumprida = 0; 
		for(ProdutoAssistivel assistivel : this.assistivel.values())
			chCumprida += assistivel.getCHCumprida();
		return chCumprida;
	}
	
	@Override
	public Set<Disciplina> getDisciplinas() {
		HashSet<Disciplina> setDisciplinas = new HashSet<Disciplina>();
		for(ProdutoAssistivel assistivel : this.assistivel.values())
			setDisciplinas.addAll(assistivel.getDisciplinas());
		return setDisciplinas;
	}

	public List<LivroIF> getLivros() {
		return this.livros;
	}	

}
