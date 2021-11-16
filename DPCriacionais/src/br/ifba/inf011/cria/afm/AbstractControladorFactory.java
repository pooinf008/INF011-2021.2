package br.ifba.inf011.cria.afm;

//ABSTRACTFACTORY em um Abstract Factory
public abstract class AbstractControladorFactory implements ControladorFactoryIF{
	protected double temperaturaMaxima;
	
	public AbstractControladorFactory() {
		super();
	}

	public AbstractControladorFactory(double temperaturaMaxima) {
		super();
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public double getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}
	
}
