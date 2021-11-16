package br.ifba.inf011.cria.single.sensor;

public class SensorTemperaturaFaixaFactory extends SensorFactory{

	public SensorTemperaturaFaixaFactory(double temperaturaBaixaLimite, double temperaturaAltaLimite) {
		super(temperaturaBaixaLimite, temperaturaAltaLimite);
	}
	
	public SensorTemperaturaFaixaFactory() {
		super();
	}	

	public SensorIF createSensor() {
		return new SensorTemperaturaFaixa(this.getTemperaturaMinima(), this.getTemperaturaMaxima());
	}
	

}
