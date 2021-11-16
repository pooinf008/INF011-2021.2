package br.ifba.inf011.cria.builder;

//CLIENT em um Builder
public class Aplicacao {
	
	
	public void rodarSemDiretor() throws InterruptedException {
		
		Controlador controlador = ControladorBuilder
								  .reset()
								  .addAtuador(new Resfriador(30))
								  .addSensor(new SensorAltaTemperatura(28))
								  .addSensor(new SensorTemperaturaLock(30))
								  .build();
		Ambiente ambiente = new Ambiente();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			ambiente.modificar(controlador.processar(temperatura));
			Thread.sleep(500);
			
		}
		
	}	
	
	public void rodarComDiretor() throws InterruptedException {
		
		ControladorAltaTemperaturaBuilder builder = new ControladorAltaTemperaturaBuilder();
		Diretor diretor = new Diretor(builder);
		diretor.construir();
		ControladorIF controlador = builder.getControlador();
		
		DescritorAltaTemperaturaBuilder builder2  = new DescritorAltaTemperaturaBuilder();
		diretor = new Diretor(builder2);
		diretor.construir();
		DescritorIF descritor = builder2.getDescritor();
		
		System.out.println(descritor.getConteudo());
		
		Ambiente ambiente = new Ambiente();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			ambiente.modificar(controlador.processar(temperatura));
			Thread.sleep(500);
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		(new Aplicacao()).rodarComDiretor();
	}

}
