package br.ifba.inf011.cria.prot.sensor;

import java.io.PrintStream;

import br.ifba.inf011.cria.prot.Prototipavel;

//PROTOTYPE em um Prototype
public interface SensorIF extends Prototipavel{
	public void setLogger(PrintStream log);
	public void medir(double temperatura);	
	public void ajuste(double temperaturaBaixaLimite, double temperaturaAltaLimite);
}
