package br.ifba.inf011.estrut.adapter;

//CLIENTE em um Adapter 
public class Aplicacao {
	
	public void run() throws InterruptedException {
		
		Ambiente ambiente = new Ambiente();
		Controlador controlador = new Controlador(25, 0.75);
		
		controlador.attachStateChangedObserver(new StateChangedLog());
		controlador.attachStateChangedObserver(new StateFileLoggerAdapter("./StateChanged.txt"));
		
		Controlador.Snapshot snapshot = controlador.getSnapshot();
		
		int i = 0;
		
		while(true) {
			i++;
			
			if(i == 10)
				snapshot = controlador.getSnapshot();
			if(i % 10 == 0) {
				System.out.println(controlador.getRelatorio());				
				System.out.println("\nPertubação...");
				ambiente.perturbar();
				controlador.ativar();
			}	
			double temperatura = ambiente.getTemperatura();
			System.out.println("Temperatura Atual: " + temperatura);
			double atuar = controlador.executar(temperatura); 
			ambiente.atuar(atuar);
			Thread.sleep(10);
			if(i % 40 == 0) {
				controlador.restaurar();
				System.out.println("\nFalha...");
				System.out.println("\nRestaurando pro último estado válido");
				controlador.restore(snapshot);
				System.out.println(controlador.getRelatorio());
				controlador.ativar();
			}
		}		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		(new Aplicacao()).run();
	}

}
