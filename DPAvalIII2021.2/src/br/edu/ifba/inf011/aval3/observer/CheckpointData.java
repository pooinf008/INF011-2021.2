package br.edu.ifba.inf011.aval3.observer;

import java.util.Map;

public class CheckpointData {
	
	private Map<String, Integer> pctDisciplinas;
	
	public CheckpointData(Map<String, Integer> pctDisciplinas) {
		this.pctDisciplinas = pctDisciplinas;
	}
	
	public Map<String, Integer> getPctConclusaoDisciplinas() {
		return this.pctDisciplinas;
	}
	
}
