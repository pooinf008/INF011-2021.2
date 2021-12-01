package br.ifba.inf011.estrut.flyweight.report;

import java.util.HashMap;
import java.util.Map;

//FlyweightFactory em Flyweight
public class DeltaTemperaturaFactory {
	
	private Map<String, DeltaTemperatura> deltas;
	
	public DeltaTemperaturaFactory() {
		this.deltas = new HashMap<String, DeltaTemperatura>();
	}
	
	public DeltaTemperatura getDeltaTemperatura(double setpoint, double valor) {
		String simbolo = DeltaTemperatura.gerarSimbolo(setpoint, valor);
		DeltaTemperatura delta = this.deltas.get(simbolo);
		if(delta == null) {
			delta = DeltaTemperatura.gerarCategoria(setpoint, valor);
			this.deltas.put(simbolo, delta);
		}
		return delta;
	}

}
