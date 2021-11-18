package br.ifba.inf011.comp.memento;

import java.util.LinkedList;
import java.util.List;

//ORIGINATOR em um Memento
public class Controlador {
	
	public class Snapshot {
		
		private Controlador controlador;
		
		private List<Double> historico;
		private double setpoint;
		private double ganho;
		private double qqcoisa;
		
		//MEMENTO em um Memento
		private Snapshot(Controlador controlador, 
						 List<Double> historico,
						 double setpoint,
						 double ganho, 	double qqcoisa) {
			
			this.controlador = controlador;
			this.historico = new LinkedList<Double>(historico);
			this.setpoint = setpoint;
			this.ganho = ganho;
			this.qqcoisa = qqcoisa;
		}
		
		private void restore() {
			this.controlador.setGanho(ganho);
			this.controlador.setSetpoint(setpoint);
			this.controlador.historico = new LinkedList<Double>(this.historico);
			this.controlador.qqcoisa = qqcoisa;
		}
	}	
	
	protected static int HISTORICO_VALUES = 5;
	
	private List<Double> historico;
	private double setpoint;
	private double ganho;
	private double qqcoisa;
	private ControladorHandler handler;
	
	public Controlador(double setpoint, double ganho){
		this.historico = new LinkedList<Double>();
		this.setpoint = setpoint;
		this.ganho = ganho;
		this.handler = new ControladorProporcionalIntegralHandler(
						   new ControladorIntegralHandler(
							   new ControladorProporcionalHandler()));
		
	}

	public double executar(double valor){
		this.historico.add(valor);
		return handler.controlar(this.historico, this.setpoint, this.ganho);
	}
	
	public String getRelatorio() {
		String relatorio = "RELATÓRIO\n";
		Estatistica estatistica = new Estatistica(this.historico);
		relatorio += "Total de Leituras: " + estatistica.getTotalElementos() + "\n";
		relatorio += "Média: " + estatistica.getMediaAritmetica() + "\n";
		relatorio += "Desvio Padrão: " + estatistica.getDesvioPadrao() + "\n";
		relatorio += "Assimetria: " + estatistica.getCoefAssimetria() + "\n";
		return relatorio;
	}

	public double getSetpoint() {
		return setpoint;
	}

	public double getGanho() {
		return ganho;
	}

	public void setSetpoint(double setpoint) {
		this.setpoint = setpoint;
	}

	public void setGanho(double ganho) {
		this.ganho = ganho;
	}
	
	public Snapshot getSnapshot() {
		return new Snapshot(this, this.historico, 
							this.setpoint, this.ganho, this.qqcoisa);
	}

	public void restore(Snapshot snapshot) {
		snapshot.restore();
	}
}
