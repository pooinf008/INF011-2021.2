package br.ifba.inf011.estrut.bridge;

//CONCRETEIMPLEMENTOR em um Bridge 
public class ConsoleLogger implements LoggerImplementor{

	@Override
	public void doLog(String s) {
		System.err.println(s);
	}

}
