package br.ifba.inf011.cria.builder;

import java.io.PrintStream;

public interface AtuadorIF {
	public double atuar(double temperatura);
	public void setLogger(PrintStream out);
}
