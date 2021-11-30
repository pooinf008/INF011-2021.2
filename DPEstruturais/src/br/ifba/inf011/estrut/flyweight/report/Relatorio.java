package br.ifba.inf011.estrut.flyweight.report;

import java.util.LinkedList;
import java.util.List;

public class Relatorio {
	
	private List<Linha> linhas;
	
	public Relatorio() {
		this.linhas = new LinkedList<Linha>();
	}
	
	public void init() {
		this.linhas.clear();
	}
	
	public void content() {
		
	}
	
	

}
