package br.ifba.inf011.solid;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ifba.inf011.solid.model.Funcionario;
import br.ifba.inf011.solid.model.FuncionarioIF;
import br.ifba.inf011.solid.model.FuncionarioPJ;
import br.ifba.inf011.solid.model.Promovivel;
import br.ifba.inf011.solid.model.Reajustavel;
import br.ifba.inf011.solid.model.Terceirizado;

public class FuncionarioDataBase {
	
	private Map<String, Funcionario> funcionarios;
	private Map<String, FuncionarioPJ> funcionariosPJ;
	
	public FuncionarioDataBase() {
		this.funcionarios = new HashMap<String, Funcionario>();
		this.funcionariosPJ = new HashMap<String, FuncionarioPJ>();
		this.carregar();
	}
	
	
	public void carregar() {
		Funcionario erich = new Funcionario("ERICH GAMMA", "001", new BigDecimal(10000));
		Funcionario helm = new Funcionario("RICHARD HELM", "002", new BigDecimal(12000));
		Funcionario ralph = new Funcionario("RALPH JOHNSON", "003", new BigDecimal(11000));
		Funcionario john = new Funcionario("JOHN VLISSIDES", "004", new BigDecimal(15000));
		FuncionarioPJ ze = new FuncionarioPJ("ZE", "005", new BigDecimal(5000));
		this.funcionarios.put(erich.getCpf(), erich);
		this.funcionarios.put(helm.getCpf(), helm);
		this.funcionarios.put(ralph.getCpf(), ralph);
		this.funcionarios.put(john.getCpf(), john);
		this.funcionariosPJ.put(ze.getCpf(), ze);
	}

	public Reajustavel findReajustavel(String cpf) {
		Reajustavel reajustavel = this.funcionarios.get(cpf);
		if(reajustavel != null)
			return reajustavel;
		return this.funcionariosPJ.get(cpf);
	}
	
	public Promovivel findPromovivel(String cpf) {
		 return this.funcionarios.get(cpf);
	}	


	public Collection<Object> findAll() {
		List<Object> todos = new ArrayList<Object>(this.funcionarios.values());
		todos.addAll(this.funcionariosPJ.values());
		return todos;
	}


}
