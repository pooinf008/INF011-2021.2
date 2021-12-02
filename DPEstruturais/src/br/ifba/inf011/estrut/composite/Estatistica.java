package br.ifba.inf011.estrut.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Estatistica{
	
	private List<Double> array;
	
	public Estatistica(){
		this.array = new ArrayList<Double>();
	}
	
	public Estatistica(Collection<Double> dados){
		this.array = new ArrayList<Double>(dados);
	}	
	
	// Coeficiente de Variação de Pearson
	public double getPearson() {
		return (this.getDesvioPadrao() / this.getMediaAritmetica()) * 100;
	}
	
	public double getMediaAritmetica() {
		double total = 0;
		for (int counter = 0; counter < this.array.size(); counter++)
			total +=  this.array.get(counter);
		return total / array.size();
	}
	
	public double getSomaDosElementos() {
		double total = 0;
		for (int counter = 0; counter < this.array.size(); counter++)
			total += this.array.get(counter);
		return total;
	}
	
	public double getSomaDosElementosAoQuadrado() {
		double total = 0;
		for (int counter = 0; counter < this.array.size(); counter++)
			total += Math.pow(this.array.get(counter), 2);
		return total;
	}

	// Variância Amostral
	public double getVariancia() {
		double p1 = 1 / Double.valueOf(this.array.size() - 1);
		double p2 = this.getSomaDosElementosAoQuadrado()
						- (Math.pow(this.getSomaDosElementos(), 2) 
								/ Double.valueOf(this.array.size()));
		return p1 * p2;
	}
	// Desvio Padrão Amostral
	public double getDesvioPadrao() {
		return Math.sqrt(getVariancia());
	}
	
	public double getMediana() {
		double[] valores = new double[this.array.size()];
		for(int counter = 0; counter < this.array.size(); counter++)
			valores[counter] = this.array.get(counter);
		
		Arrays.sort(valores);
		
		int tipo = valores.length % 2;
		if (tipo == 1) {
			return valores[((valores.length + 1) / 2) - 1];
		} else {
			int m = valores.length / 2;
			return (valores[m - 1] + valores[m]) / 2;
		}
	}
	
	public double getModa() {
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		Integer i;
		Double moda = 0.0;
		Integer numAtual, numMaior = 0;
		for (int count = 0; count < this.array.size(); count++) {
			i = (Integer) map.get(this.array.get(count));
			if (i == null) {
				map.put(this.array.get(count), 1);
			} else {
				map.put(this.array.get(count), i.intValue() + 1);
				numAtual = i.intValue() + 1;
				if (numAtual > numMaior) {
					numMaior = numAtual;
					moda = this.array.get(count);
				}
			}
		}
//		 System.out.print("\n Eis o mapa: "+map.toString());
		return moda;
	}
	
	public double getCoefAssimetria() {
		return (this.getMediaAritmetica() - this.getModa()) / this.getDesvioPadrao();
	}
	
	public int getTotalElementos() {
		return this.array.size();		
	}

}
