package br.ifba.inf011.afm;

//CONCRETEFACTORY em um Abstract Factory
public class ControladorAltaTemperaturaFactory extends AbstractControladorFactory
												implements ControladorFactoryIF{

	public ControladorAltaTemperaturaFactory() {
		super();
	}
	
	
	public ControladorAltaTemperaturaFactory(double temperaturaLimite) {
		super(temperaturaLimite);
	}
	
	
	@Override
	public SensorIF getSensor() {
		return new SensorAltaTemperatura(this.temperaturaMaxima);
	}

	@Override
	public AtuadorIF getAtuador() {
		return new Resfriador(this.temperaturaMaxima);
	}



}
