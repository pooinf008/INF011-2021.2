package br.ifba.inf011.comp.base2;

public class Aplicacao {
	
	public void run() throws InterruptedException {
		
		Ambiente ambiente = new Ambiente();
		Controlador controlador = new Controlador(25, 1.25);
		
		int i = 0;
		
		while(true) {
			if(i++ % 20 == 0) {
				i = 1;
				System.out.println("Ruído...");
				ambiente.perturbar();
			}	
			double temperatura = ambiente.getTemperatura();
			System.out.println("Temperatura [" + i + "]:" + temperatura);
			double atuar = 0;
			if(i % 2 == 0)
				atuar = controlador.executar(TipoControle.PROPORCIONAL, temperatura);
			else
				atuar = controlador.executar(TipoControle.INTEGRAL, temperatura);
			ambiente.atuar(atuar);
			Thread.sleep(250);
		}		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		(new Aplicacao()).run();
	}

}
