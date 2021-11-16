package br.ifba.inf011.builder;

import java.io.PrintStream;

public interface SensorIF {
	public void setLogger(PrintStream log);
	public void medir(double temperatura);
}
