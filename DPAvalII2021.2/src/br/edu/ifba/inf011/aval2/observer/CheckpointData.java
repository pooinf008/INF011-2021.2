package br.edu.ifba.inf011.aval2.observer;

import java.util.Map;

public class CheckpointData {
	
	private Map<String, Double> pctDisciplinas;
	
	public CheckpointData(Map<String, Double> pctDisciplinas) {
		this.pctDisciplinas = pctDisciplinas;
	}
	
	public Map<String, Double> getPctConclusaoDisciplinas() {
		return this.pctDisciplinas;
	}
	
}
