package br.ifba.inf011.afm;

//CONCRETEFACTORY em um Abstract Factory
public class ControladorFaixaTemperaturaFactory extends AbstractControladorFactory 
												implements ControladorFactoryIF {
	
	private static double DELTA = 5; 
	
	public ControladorFaixaTemperaturaFactory(double temperaturaMaxima) {
		super(temperaturaMaxima);
	}
	
	public ControladorFaixaTemperaturaFactory() {
		super();
	}	
	
	
	@Override
	public SensorIF getSensor() {
		return new SensorFaixaTemperatura(this.temperaturaMaxima - ControladorFaixaTemperaturaFactory.DELTA,
										  this.temperaturaMaxima);
	}

	@Override
	public AtuadorIF getAtuador() {
		return new Estabilizador(this.temperaturaMaxima - ControladorFaixaTemperaturaFactory.DELTA, 
								 this.temperaturaMaxima);
	}

}
