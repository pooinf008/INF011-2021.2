package br.ifba.inf011.cria.afm;

//ABSTRACTFACTORY em um Abstract Factory
public interface ControladorFactoryIF {
	public SensorIF getSensor();
	public AtuadorIF getAtuador();
}
