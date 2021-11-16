package br.ifba.inf011.prot.atuador;

public class AtuadorEstabilizadorFactory extends AtuadorFactory{

	public AtuadorEstabilizadorFactory(double temperaturaLimite) {
		super(temperaturaLimite);
	}
	
	public AtuadorEstabilizadorFactory() {
		super();
	}	

	@Override
	public AtuadorIF createAtuador() {
		return new AtuadorEstabilizador(this.getTemperaturaMinima(),
									    this.getTemperaturaMaxima());
	}
	

}
