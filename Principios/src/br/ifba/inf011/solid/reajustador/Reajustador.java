package br.ifba.inf011.solid.reajustador;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import br.ifba.inf011.solid.exception.ValidacaoException;
import br.ifba.inf011.solid.model.Funcionario;
import br.ifba.inf011.solid.model.FuncionarioIF;
import br.ifba.inf011.solid.model.Reajustavel;

public class Reajustador {
	
	private List<RegraReajuste> regras;
	
	public Reajustador() {
		super();
		this.regras = new ArrayList<RegraReajuste>();
	}

	public void addRegraReajuste(RegraReajuste regra) {
		this.regras.add(regra);
	}
	
	public void reajustar(Reajustavel funcionario, BigDecimal indice, Date data) throws ParseException, ValidacaoException {
		
		for(RegraReajuste regra : this.regras)
			regra.validar(funcionario, indice, data);
		
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal aumento = salarioAtual.multiply(indice);
		BigDecimal salarioCorrigido = salarioAtual.add(aumento);
		funcionario.setSalario(salarioCorrigido);
		funcionario.setDataUltReajuste(data);
	}
	
	

}
