package br.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.util.Date;

public class FichaFuncional {
	
	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	private Date dataUltReajuste;
	private Endereco endereco;
	
	
	public FichaFuncional(String nome, String cpf, BigDecimal salario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.cargo = Cargo.ASSISTENTE;
		this.dataUltReajuste = new Date();
		this.endereco = new Endereco();
	}

	public FichaFuncional(String nome, String cpf, Cargo cargo, BigDecimal salario, Date dataUltReajuste, String rua,
			String numero, String cep) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
		this.dataUltReajuste = dataUltReajuste;

	}
	
	public void setRua(String rua) {
		this.endereco.setRua(rua);
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Date getDataUltReajuste() {
		return dataUltReajuste;
	}

	public void setDataUltReajuste(Date dataUltReajuste) {
		this.dataUltReajuste = dataUltReajuste;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	

	
	
}
