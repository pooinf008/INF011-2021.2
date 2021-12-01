package br.ifba.inf011.estrut.flyweight;

import java.util.Date;

import br.ifba.inf011.estrut.noflyweight.report.Relatorio;

//CLIENTE em um Adapter 
public class Aplicacao {
	
	public void run() throws InterruptedException {
		
		
		double setpoint = 25;
		Ambiente ambiente = new Ambiente();
		Controlador controlador = new Controlador(setpoint, 0.75);
		Relatorio relatorio = new Relatorio(setpoint);
		
//		controlador.attachStateChangedObserver(new StateChangedLog());
		
		Controlador.Snapshot snapshot = controlador.getSnapshot();
		
		long i = 0;
		
		while(i < 1000) {
			i++;
			
			if(i == 10)
				snapshot = controlador.getSnapshot();
			if(i % 10 == 0) {
//				System.out.println(controlador.getRelatorio());				
//				System.out.println("\nPertubação...");
				ambiente.perturbar();
				controlador.ativar();
			}	
			double temperatura = ambiente.getTemperatura();
			relatorio.addRegistro(new Date(), temperatura);
//			System.out.println("Temperatura Atual: " + temperatura);
			double atuar = controlador.executar(temperatura); 
			ambiente.atuar(atuar);
			Thread.sleep(10);
			if(i % 40 == 0) {
				controlador.restaurar();
//				System.out.println("\nFalha...");
//				System.out.println("\nRestaurando pro último estado válido");
				controlador.restore(snapshot);
//				System.out.println(controlador.getRelatorio());
				controlador.ativar();
			}
		}
		System.out.println(relatorio.conteudo());
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		(new Aplicacao()).run();
	}

}
