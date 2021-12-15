package br.edu.ifba.inf011.aval2.state;

import java.util.Map;

import br.edu.ifba.inf011.aval2.Disciplina;

public class ConcluidoState extends AbstractCursoState implements CursoState {

	@Override
	public String getNome() {
		return "CONCLUIDO";
	}
	
	
	public String emitirCertificado(String cod, String nome, Map<String, Disciplina> disciplinas) throws OperacaoInvalida{
		String rep = "CERTIFICADO\n";
		rep =  rep + "[Curso] "  + cod + "-" + nome + "\n"; 
			for(Disciplina disciplina : disciplinas.values())
				rep = rep + "\t[" + disciplina.getCodigo() + "] - "+ disciplina.getNome() + "\n";
			return rep;	
	};
	
	

}
