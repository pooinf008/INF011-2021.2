package br.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.util.Date;

public class Terceirizado{

	private String nomeEmpresa;
	private FichaFuncional ficha;
	
	public Terceirizado(String nomeEmpresa, String nome, String cpf, BigDecimal salario) {
		this.ficha = new FichaFuncional(nome, cpf, salario);
		this.nomeEmpresa = nomeEmpresa;
	}

	public Terceirizado(String nomeEmpresa, String nome, String cpf, Cargo cargo, BigDecimal salario, Date dataUltReajuste, String rua,
			String numero, String cep) {
		this.ficha = new FichaFuncional(nome, cpf, cargo, salario, dataUltReajuste, rua, numero, cep);
		this.nomeEmpresa = nomeEmpresa;
	}
	
	public String getRua() {
		return this.ficha.getEndereco().getRua();
	}
	
	public void setRua(String rua) {
		this.ficha.getEndereco().setRua(rua);
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
	
	public Date getDataUltReajuste() {
		return this.ficha.getDataUltReajuste();
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
		return "Terceirizado [nomeEmpresa=" + nomeEmpresa +
				", nome=" + this.getNome() + 
				", cpf=" + this.getCpf() + 
				", cargo=" + this.getCargo() + 
				", salario=" + this.getSalario() +
				", dataUltReajuste=" + this.getDataUltReajuste() + "]";
	}
	

}
