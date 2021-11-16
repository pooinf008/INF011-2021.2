package br.ifba.inf011.cria.single.atuador;

import java.io.PrintStream;

import br.ifba.inf011.cria.single.Prototipavel;

//PROTOTYPE em um Prototype
public interface AtuadorIF extends Prototipavel{
	public void setLogger(PrintStream out);	
	public double atuar(double temperatura);
	public void ajuste(double temperaturaBaixaLimite, double temperaturaAltaLimite);
}
