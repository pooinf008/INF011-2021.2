package br.ifba.inf011.estrut.bridge;

//CONCRETEIMPLEMENTO em um Bridge 
public class ConsoleLogger implements SimpleLoggerImplementor{

	@Override
	public void doLog(String s) {
		System.err.println(s);
	}

}
