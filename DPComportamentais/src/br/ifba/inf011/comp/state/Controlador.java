package br.ifba.inf011.comp.state;

import java.util.LinkedList;
import java.util.List;

//CONTEXT em State
public class Controlador {
	
	public class Snapshot {
		
		private Controlador controlador;
		
		private List<Double> historico;
		private double setpoint;
		private double ganho;
		
		private Snapshot(Controlador controlador, 
						 List<Double> historico,
						 double setpoint,
						 double ganho) {
			
			this.controlador = controlador;
			this.historico = new LinkedList<Double>(historico);
			this.setpoint = setpoint;
			this.ganho = ganho;
		}
		
		protected void restore() {
			this.controlador.setGanho(ganho);
			this.controlador.setSetpoint(setpoint);
			this.controlador.historico = new LinkedList<Double>(this.historico);
		}
		

	}	
	
	protected static int HISTORICO_VALUES = 5;
	
	private List<Double> historico;
	private double setpoint;
	private double ganho;
	private ControladorHandler handler;
	
	private ControladorState state;
	
	public Controlador(double setpoint, double ganho){
		this.historico = new LinkedList<Double>();
		this.setpoint = setpoint;
		this.ganho = ganho;
		this.handler = new ControladorProporcionalIntegralHandler(
						   new ControladorIntegralHandler(
							   new ControladorProporcionalHandler()));
		this.state = new AtivoState();
		
	}

	public double executar(double valor){
		return this.state.executar(valor, this.historico, 
								   this.setpoint, this.ganho, 
								   this.handler);
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
							this.setpoint, this.ganho);
	}

	public void restore(Snapshot snapshot) {
		this.state.restore(snapshot);
	}
	
	public void ativar() {
		this.state = this.state.ativar();
	};
	
	public void inativar() {
		this.state = this.state.inativar();
	};
	
	public void restaurar() {
		this.state = this.state.restaurar();
	};	
}
