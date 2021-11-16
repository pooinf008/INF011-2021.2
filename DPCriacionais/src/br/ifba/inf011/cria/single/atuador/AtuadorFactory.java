package br.ifba.inf011.cria.single.atuador;

import java.io.PrintStream;

public abstract class AtuadorFactory {
	
	public static PrintStream LOG_STREAM = System.err;
	
	protected double temperaturaMaxima;
	protected double temperaturaMinima;

	public AtuadorFactory() {
		this.temperaturaMaxima = Double.NaN;
		this.temperaturaMinima = Double.NaN;
	}
	
	public AtuadorFactory(double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMinima = Double.NaN;
	}
	
	public AtuadorFactory(double temperaturaMinima, double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMinima = temperaturaMinima;
	}	
	
	public abstract AtuadorIF createAtuador();

	public AtuadorIF getAtuador() {
		AtuadorIF atuador = this.createAtuador();
		atuador.ajuste(this.temperaturaMinima, this.temperaturaMaxima);
		return atuador;
	}
	
	public AtuadorIF getAtuador(double temperaturaMinima,  double temperaturaMaxima) {
		AtuadorIF atuador = this.createAtuador();
		atuador.setLogger(AtuadorFactory.LOG_STREAM);
		atuador.ajuste(temperaturaMinima, temperaturaMaxima);
		return atuador;
	}	
	
	public AtuadorIF getAtuador(double temperaturaLimite) {
		AtuadorIF atuador = this.createAtuador();
		atuador.setLogger(AtuadorFactory.LOG_STREAM);
		atuador.ajuste(this.temperaturaMinima, temperaturaLimite);
		return atuador;
	}

	public double getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public double getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}	
	
	
	

}
