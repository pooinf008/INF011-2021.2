package br.ifba.inf011.comp.strategy;


//CLIENTE em um Strategy
public class Aplicacao {
	
	public void run() throws InterruptedException {
		
		Ambiente ambiente = new Ambiente();
		Controlador controlador = new Controlador(25, 1.5);
		
		int i = 0;
		
		while(true) {
			if(i++ % 50 == 0) {
				System.out.println("RUIDO...");
				ambiente.perturbar();
			}	
			if(i%2==0)
				controlador.setStrategy(new StrategyProporcional());
			else
				controlador.setStrategy(new StrategyIntegral());
			double temperatura = ambiente.getTemperatura();
			double atuar = controlador.executar(temperatura); 
			System.out.println("Temperatura " + temperatura);
			ambiente.atuar(atuar);
			Thread.sleep(250);
		}		
	}
	
	public void run2() throws InterruptedException {
		
		Ambiente ambiente = new Ambiente();
		Controlador2 controlador = new Controlador2(25, 1.5);
		
		int i = 0;
		
		while(true) {
			if(i++ % 50 == 0) {
				System.out.println("RUIDO...");
				ambiente.perturbar();
			}	
			if(i%2==0)
				controlador.setStrategy(TipoControle.PROPORCIONAL);
			else
				controlador.setStrategy(TipoControle.INTEGRAL);
			double temperatura = ambiente.getTemperatura();
			double atuar = controlador.executar(temperatura); 
			System.out.println("Temperatura " + temperatura);
			ambiente.atuar(atuar);
			Thread.sleep(250);
		}		
	}	
	
	public static void main(String[] args) throws InterruptedException {
		(new Aplicacao()).run2();
	}

}
