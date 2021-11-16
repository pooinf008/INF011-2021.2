package br.ifba.inf011.single.atuador;

import java.io.PrintStream;

public abstract class AbstractAtuador implements AtuadorIF{
	
	protected PrintStream out;

	public PrintStream getLogger() {
		return out;
	}

	public void setLogger(PrintStream out) {
		this.out = out;
	}
	
	
	

}
