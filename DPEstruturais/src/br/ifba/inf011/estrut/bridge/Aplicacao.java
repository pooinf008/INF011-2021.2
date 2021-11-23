package br.ifba.inf011.estrut.bridge;

public class Aplicacao {
	
	private static final boolean DIGEST_LOG = true;
	private static final boolean IMPL_LOG = false;
	
	public void run() throws InterruptedException {
		
		
		Ambiente ambiente = new Ambiente();
		Controlador controlador = new Controlador(25, 0.75);
		SimpleLoggerImplementor logger;
		
		if(Aplicacao.IMPL_LOG)
			logger = new ConsoleLogger();
		else
			logger = new FileLogger("./BRIDGE_LOG.txt");
		
		
		if(Aplicacao.DIGEST_LOG)
			controlador.attachStateChangedObserver(new StateChangedLog(new DigestLogger(logger)));
		else
			controlador.attachStateChangedObserver(new StateChangedLog(new SimpleLogger(logger)));
		
		
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
