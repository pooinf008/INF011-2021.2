package br.ifba.inf011.comp.memento;

import java.util.ArrayList;
import java.util.List;


//CARETAKER em um Memento 
public class Aplicacao {
	
	
	public void run01() throws InterruptedException {
		
		Ambiente ambiente = new Ambiente();
		Controlador controlador = new Controlador(25, 0.75);
		
		Controlador.Snapshot valido = null;
		
		int i = 1;
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			double atuar = controlador.executar(temperatura); 
			ambiente.atuar(atuar);
			if(i == 100)
				valido = controlador.getSnapshot();
			if(i % 100 == 0)
				System.out.println(controlador.getRelatorio());
			if(i % 500 == 0) {
				System.out.println("Valor de i: " + i);
				controlador.restore(valido);
			}
			i++;
			
		}		
	}
	
	
	public void run02() throws InterruptedException {
		
		List<Controlador.Snapshot> snapshots = new ArrayList<Controlador.Snapshot>();
		
		Ambiente ambiente = new Ambiente();
		Controlador controlador = new Controlador(25, 0.75);
		
		int i = 0;
		
		while(true) {
			i++;
			
			if(i % 20 == 0)
				snapshots.add(controlador.getSnapshot());
			if(i % 10 == 0) {
				System.out.println(controlador.getRelatorio());				
				System.out.println("\nPertubação...");
				ambiente.perturbar();
			}	
			double temperatura = ambiente.getTemperatura();
			double atuar = controlador.executar(temperatura); 
			ambiente.atuar(atuar);
			Thread.sleep(10);
			if(i % 40 == 0) {
				System.out.println("\nFalha...");
				System.out.println("\nRestaurando pro último estado válido");
				controlador.restore(snapshots.get(1));
				System.out.println(controlador.getRelatorio());				
			}
		}		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		(new Aplicacao()).run01();
	}

}
