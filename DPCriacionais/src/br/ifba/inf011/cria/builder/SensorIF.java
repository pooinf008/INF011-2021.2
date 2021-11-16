package br.ifba.inf011.cria.builder;

import java.io.PrintStream;

public interface SensorIF {
	public void setLogger(PrintStream log);
	public void medir(double temperatura);
}
