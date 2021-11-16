package br.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import br.ifba.inf011.solid.exception.ValidacaoException;

public class Funcionario implements FuncionarioIF{
	
	private FichaFuncional ficha;
	
	public Funcionario(String nome, String cpf, BigDecimal salario) {
		super();
		this.ficha = new FichaFuncional(nome, cpf, salario);
	}

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario, Date dataUltReajuste, String rua,
			String numero, String cep) {
		this.ficha = new FichaFuncional(nome, cpf, cargo, salario, dataUltReajuste, rua, numero, cep);
	}
	
	public String getRua() {
		return this.ficha.getEndereco().getRua();
	}
	
	public void setRua(String rua) {
		this.ficha.setRua(rua);
	}
	
	public String getNome() {
		return this.ficha.getNome();
	}
	
	public void setNome(String nome) {
		this.ficha.setNome(nome);
	}
	
	public String getCpf() {
		return this.ficha.getCpf();
	}
	public void setCpf(String cpf) {
		this.ficha.setCpf(cpf);
	}
	public Cargo getCargo() {
		return this.ficha.getCargo();
	}

	public BigDecimal getSalario() {
		return this.ficha.getSalario();
	}
	public void setSalario(BigDecimal salario) {
		this.ficha.setSalario(salario);
	}
	public Date getDataUltReajuste() {
		return this.ficha.getDataUltReajuste();
	}
	public void setDataUltReajuste(Date dataUltReajuste) {
		this.ficha.setDataUltReajuste(dataUltReajuste);
	}

	public void setCargo(Cargo cargo) {
		this.ficha.setCargo(cargo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getCpf() == null) ? 0 : this.getCpf().hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (this.getCpf() == null) {
			if (other.getCpf() != null)
				return false;
		} else if (!this.getCpf().equals(other.getCpf()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + this.getNome() + 
				", cpf=" + this.getCpf() + 
				", cargo=" + this.getCargo() + 
				", salario=" + this.getSalario() +
				", dataUltReajuste=" + this.getDataUltReajuste() + "]";
	}
	
}
