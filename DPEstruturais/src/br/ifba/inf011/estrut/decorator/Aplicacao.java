package br.ifba.inf011.estrut.decorator;

import br.ifba.inf011.estrut.decorator.report.Relatorio;

//CLIENTE em um Adapter 
public class Aplicacao {
	
	public void run() throws InterruptedException {
		
		double setpoint = 25;
		Area area = this.makeArea();
		Controlador controlador = new Controlador(setpoint, 0.75);
		Relatorio relatorio = new Relatorio(setpoint);
		
		
//		controlador.attachStateChangedObserver(new StateChangedLog());
//		controlador.attachStateChangedObserver(new StateFileLoggerAdapter("./StateChanged.txt"));
		
		Controlador.Snapshot snapshot = controlador.getSnapshot();
		
		long i = 0;
		
		while(i < 1000) {
			i++;
			
			if(i == 10)
				snapshot = controlador.getSnapshot();
			if(i % 10 == 0) {
//				System.out.println(controlador.getRelatorio());				
//				System.out.println("\nPertuba��o...");
				area.perturbar();
				controlador.ativar();
			}	
			double temperatura = area.getTemperatura();
			relatorio.addRegistro(temperatura);

//			System.out.println("Temperatura Atual: " + temperatura);
			double atuar = controlador.executar(temperatura); 
			area.atuar(atuar);
			Thread.sleep(10);
			if(i % 40 == 0) {
				controlador.restaurar();
//				System.out.println("\nFalha...");
//				System.out.println("\nRestaurando pro �ltimo estado v�lido");
				controlador.restore(snapshot);
//				System.out.println(controlador.getRelatorio());
				controlador.ativar();
			}
		}
		System.out.println(relatorio.conteudo());
	}
	
	
	private Area makeArea() {
		
		Area subArea11 = new AreaSimples();
		Area subArea12 = new AreaSimples();
		Area subArea21 = new AreaSimples();
		Area subArea22 = new AreaSimples();
		Area subArea23 = new AreaSimples();
		Area subArea3 = new AreaSimples();
		
		AreaComposta subArea1 = new AreaComposta();
		subArea1.addArea(subArea11);
		subArea1.addArea(subArea12);
		subArea1.addArea(subArea21);
		
		AreaComposta subArea2 = new AreaComposta();
		subArea2.addArea(subArea22);
		subArea2.addArea(subArea23);
		
		AreaComposta area = new AreaComposta();
		area.addArea(subArea1);
		area.addArea(subArea2);
		area.addArea(subArea3);
		
		return area;
	}


	public static void main(String[] args) throws InterruptedException {
		(new Aplicacao()).run();
	}

}
