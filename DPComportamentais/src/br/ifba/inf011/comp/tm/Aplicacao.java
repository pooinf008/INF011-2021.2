package br.ifba.inf011.comp.tm;

public class Aplicacao {
	
	public void run() throws InterruptedException {
		
		Ambiente ambiente = new Ambiente();
		Controlador controlador = new Controlador(25, 0.75);
		
		int i = 0;
		
		while(true) {
			if(i++ % 50 == 0) {
				i = 1;
				System.out.println("\nPertuba��o...");
				ambiente.perturbar();
			}	
			double temperatura = ambiente.getTemperatura();
			System.out.println("Temperatura [" + i + "]:" + temperatura);
			double atuar = controlador.executar(temperatura); 
			ambiente.atuar(atuar);
			Thread.sleep(250);
		}		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		(new Aplicacao()).run();
	}

}
