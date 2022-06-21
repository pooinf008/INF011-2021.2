package br.edu.ifba.inf011.aval3.state;

import java.util.Map;

import br.edu.ifba.inf011.aval3.Disciplina;
import br.edu.ifba.inf011.aval3.ProdutoAssistivel;

public class ConcluidoState extends AbstractCursoState implements CursoState {

	@Override
	public String getNome() {
		return "CONCLUIDO";
	}
	
	
	public String emitirCertificado(String cod, String nome, Map<String, ProdutoAssistivel> assistiveis) throws OperacaoInvalida{
		String rep = "CERTIFICADO\n";
		rep =  rep + "[Curso] "  + cod + "-" + nome + "\n"; 
			for(Disciplina disciplina : this.getDisciplinas(assistiveis))
				rep = rep + "\t[" + disciplina.getCodigo() + "] - "+ disciplina.getNome() + "\n";
			return rep;	
	};
	
	

}
