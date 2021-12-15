package br.edu.ifba.inf011.aval2;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

import br.edu.ifba.inf011.aval2.Curso.Situacao;
import br.edu.ifba.inf011.aval2.builder.CursoBuilder;
import br.edu.ifba.inf011.aval2.fm.ProdutoFactory;
import br.edu.ifba.inf011.aval2.fm.TipoProduto;
import br.edu.ifba.inf011.aval2.observer.ReportCheckpoint;
import br.edu.ifba.inf011.aval2.state.OperacaoInvalida;

public class AplicacaoII {
	
	
	
	
	private Curso makeCurso() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Disciplina disc01 = (Disciplina) 
			ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
					"DISC_COMP01", 
					"Chain of Responsibility");

		disc01.setCHTotal(15);

		Disciplina disc02 = (Disciplina) 
			ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
				   "DISC_COMP02", 
				   "Command");
			disc02.setCHTotal(30);

			Curso curso = CursoBuilder.factory()
									  .reset()
									  .setNome("Padrões Comportamentais")
									  .setCodigo("CURSO_COMP01")
									  .addDisciplina(disc01)
									  .addDisciplina(disc02)
									  .build();
			return curso;
	}	
	
	
	
	
	
	
	
	
	
	
	
	private void rodarQ1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida {
		
		Stack<Situacao> checks = new Stack<Situacao>();
		
		System.out.println("Questão I");
		
		Curso curso = this.makeCurso();
		
		checks.push(curso.checkpoint());
		System.out.println(curso);
		
		curso.avancar("DISC_COMP01", 0.25);
		checks.push(curso.checkpoint());
		System.out.println(curso);

		curso.avancar("DISC_COMP02", 0.20);
		checks.push(curso.checkpoint());
		System.out.println(curso);
		
		curso.restore(checks.pop());
		System.out.println(curso);
		
		curso.restore(checks.pop());
		System.out.println(curso);
		
		curso.restore(checks.pop());
		System.out.println(curso);
	}
	
	private void rodarQ2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida {
		
		Stack<Situacao> checks = new Stack<Situacao>();
		
		System.out.println("Questão II");
		
		Curso curso = this.makeCurso();
		
		curso.addCheckpointListener(new ReportCheckpoint());
		
		checks.push(curso.checkpoint());
		
		curso.avancar("DISC_COMP01", 0.25);
		checks.push(curso.checkpoint());

		curso.avancar("DISC_COMP02", 0.20);
		checks.push(curso.checkpoint());
		
		curso.restore(checks.pop());
		
		curso.restore(checks.pop());
		
		curso.restore(checks.pop());
	}
	
	private void rodarQ3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida {
		
		Stack<Situacao> checks = new Stack<Situacao>();
		
		System.out.println("\nQuestão III");
		
		Curso curso = this.makeCurso();
		
		curso.addCheckpointListener(new ReportCheckpoint());
		
		checks.push(curso.checkpoint());
		
		curso.avancar("DISC_COMP01", 0.25);
		checks.push(curso.checkpoint());
		
		curso.suspender();
		
		try {
			curso.avancar("DISC_COMP02", 0.20);
			checks.push(curso.checkpoint());
		}catch(OperacaoInvalida o) {
			System.err.println(o);
			curso.continuar();
		}
		
		try {
			System.out.println(curso.emitirCertificado());
		}catch(OperacaoInvalida o) {
			System.err.println(o);
		}		
		
		curso.concluir();
		try {
			System.out.println(curso.emitirCertificado());
		}catch(OperacaoInvalida o) {
			System.err.println(o);
		}
		
		curso.avancar("DISC_COMP01", 0.75);
		curso.avancar("DISC_COMP02", 1);
		curso.concluir();
		

		curso.concluir();
		try {
			System.out.println(curso.emitirCertificado());
		}catch(OperacaoInvalida o) {
			System.err.println(o);
		}
		
		
	}
	
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida {
		AplicacaoII app = new AplicacaoII();
		app.rodarQ1();
		app.rodarQ2();
		app.rodarQ3();
	}


}
