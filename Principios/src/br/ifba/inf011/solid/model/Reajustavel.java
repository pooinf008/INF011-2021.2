package br.ifba.inf011.solid.model;

import java.math.BigDecimal;
import java.util.Date;

public interface Reajustavel {
	public BigDecimal getSalario();
	public void setSalario(BigDecimal salario);
	public Date getDataUltReajuste();
	public void setDataUltReajuste(Date dataUltReajuste);
}
