package br.ifba.inf011.solid;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.ifba.inf011.solid.exception.ValidacaoException;
import br.ifba.inf011.solid.model.Funcionario;
import br.ifba.inf011.solid.model.FuncionarioIF;
import br.ifba.inf011.solid.model.Promovivel;
import br.ifba.inf011.solid.model.Reajustavel;
import br.ifba.inf011.solid.model.Terceirizado;
import br.ifba.inf011.solid.promovedor.Promovedor;
import br.ifba.inf011.solid.reajustador.Reajustador;
import br.ifba.inf011.solid.reajustador.RegraPercentual;
import br.ifba.inf011.solid.reajustador.RegraPercentualMinimo;
import br.ifba.inf011.solid.reajustador.RegraPeriodo;

public class App {

	private FuncionarioDataBase funcionarioDB = new FuncionarioDataBase();

	public void reajustar(String cpf, String indice, String data) throws ParseException, ValidacaoException  {
		Reajustador reajustador = new Reajustador();
		reajustador.addRegraReajuste(new RegraPercentual());
		reajustador.addRegraReajuste(new RegraPeriodo());
		reajustador.addRegraReajuste(new RegraPercentualMinimo());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataReajuste = format.parse(data); 
		Reajustavel reajustavel =   this.funcionarioDB.findReajustavel(cpf);
		reajustador.reajustar(reajustavel, new BigDecimal(indice), dataReajuste);
	}
	
	public String printRelatorio() {
		String relatorio = "FUNCIONARIOS\n";
		for(Object f : this.funcionarioDB.findAll())
			relatorio = relatorio + f + "\n";
		return relatorio;
	}
	
	public void promover(String cpf) {
		Promovedor promovedor = new Promovedor();
		Promovivel promovivel = (Funcionario) this.funcionarioDB.findPromovivel(cpf);
		promovedor.promover(promovivel);
	}
	
	public void run() throws ParseException, ValidacaoException {
		System.out.println(this.printRelatorio());
		this.reajustar("003", "0.10", "25/08/2022");
		System.out.println(this.printRelatorio());
	}
	
	public void run2() throws ParseException, ValidacaoException {
		System.out.println(this.printRelatorio());
		this.promover("003");
		System.out.println(this.printRelatorio());
	}
	
	public void run3() throws ParseException, ValidacaoException {
		System.out.println(this.printRelatorio());
		this.reajustar("005", "0.10", "25/08/2022");
		System.out.println(this.printRelatorio());
	}	
	
	public static void main(String[] args) throws ParseException, ValidacaoException {
		(new App()).run3();
	}
}
