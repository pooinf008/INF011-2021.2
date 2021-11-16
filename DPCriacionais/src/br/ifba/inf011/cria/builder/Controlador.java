package br.ifba.inf011.cria.builder;

import java.util.List;

//PRODUCT em um Builder
public class Controlador implements ControladorIF{

	private List<SensorIF> sensores;
	private List<AtuadorIF> atuadores;
	
	
	public Controlador(List<SensorIF> sensores, List<AtuadorIF> atuadores) {
		this.sensores = sensores;
		this.atuadores = atuadores;
	}
	
	@Override
	public double processar(double temperatura) {
		double tempMedia = 0;
		for(SensorIF sensor : this.sensores)
			sensor.medir(temperatura);
		for(AtuadorIF atuador : this.atuadores)
			tempMedia += atuador.atuar(temperatura);	
		return tempMedia / this.atuadores.size();
	}

}
