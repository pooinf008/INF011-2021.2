package br.ifba.inf011.estrut.composite;

import java.util.HashSet;
import java.util.Set;

//COMPOSITE em um Composite
public class AreaComposta implements Area{
	
	private Set<Area> areas;

	public AreaComposta() {
		this.areas = new HashSet<Area>();
	}
	
	public void addArea(Area area) {
		this.areas.add(area);
	}
	
	@Override
	public double getTemperatura() {
		double temperatura = 0;
		for(Area area : this.areas)
			temperatura += area.getTemperatura();
		return temperatura / this.areas.size();
	}

	@Override
	public void atuar(double temperatura) {
		for(Area area : this.areas)
			area.atuar(temperatura);
	}

	@Override
	public void perturbar() {
		for(Area area : this.areas)
			area.perturbar();
	} 
	
	

}
