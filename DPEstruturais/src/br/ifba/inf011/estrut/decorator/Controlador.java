package br.ifba.inf011.estrut.decorator;

import java.util.LinkedList;
import java.util.List;

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
	
	private List<StateChangedObserver> observers;
	
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
		this.observers = new LinkedList<StateChangedObserver>();
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
		String de = this.state.getNome();
		this.state = this.state.ativar();
		String para = this.state.getNome();
		this.fireStateChangedEvent(de, para);
	};
	
	public void inativar() {
		String de = this.state.getNome();
		this.state = this.state.inativar();
		String para = this.state.getNome();
		this.fireStateChangedEvent(de, para);
	};
	
	public void restaurar() {
		String de = this.state.getNome();
		this.state = this.state.restaurar();
		String para = this.state.getNome();
		this.fireStateChangedEvent(de, para);
	};	
	
	public void attachStateChangedObserver(StateChangedObserver observer) {
		this.observers.add(observer); 
	}
	
	public void detachStateChangedObserver(StateChangedObserver observer) {
		this.observers.remove(observer); 
	}
	
	public void fireStateChangedEvent(String de, String para) {
		for(StateChangedObserver observer : this.observers)
			observer.notifyStateChanged(new StateChangedEvent(de, para));
	}
	
	
}
