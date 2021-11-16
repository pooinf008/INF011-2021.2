package br.ifba.inf011.cria.single.atuador;

public class AtuadorResfriadorFactory extends AtuadorFactory{

	public AtuadorResfriadorFactory(double temperaturaLimite) {
		super(temperaturaLimite);
	}
	
	public AtuadorResfriadorFactory() {
		super();
	}	

	@Override
	public AtuadorIF createAtuador() {
		return new AtuadorResfriador(this.getTemperaturaMaxima());
	}
	

}
