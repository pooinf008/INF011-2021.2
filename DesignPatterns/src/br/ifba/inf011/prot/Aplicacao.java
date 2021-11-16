package br.ifba.inf011.prot;

import br.ifba.inf011.prot.atuador.TipoAtuador;
import br.ifba.inf011.prot.sensor.TipoSensor;

public class Aplicacao {
	
	
	public void rodar() throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		GerentePrototipos gerente = new GerentePrototipos(); 
		
		ControladorIF controlador = gerente.get(TipoSensor.FAIXA, 
												TipoAtuador.ESTABILIZADOR);
		Ambiente ambiente = new Ambiente();
		
		while(true) {
			double temperatura = ambiente.getTemperatura();
			ambiente.modificar(controlador.processar(temperatura));
			Thread.sleep(500);
		}
		
	}	
	

	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		(new Aplicacao()).rodar();
	}

}
